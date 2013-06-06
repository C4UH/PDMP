/*
   Copyright 2013 Collaborative For Universal Health (C4UH), Logicoy Inc.

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
  */


package com.logicoy.pdmp.pmpi;

import com.logicoy.pdmp.pmpi.crypto.EncryptionClient;
import com.logicoy.pdmp.pmpi.http.PMPIHttpClient;
import com.logicoy.pdmp.pmpi.http.PMPIHttpClientResponse;
import java.io.InputStream;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXB;
import javax.xml.transform.stream.StreamSource;
import org.nabp.pmpi.DisclosureResponseTypeEnumeration;
import org.nabp.pmpi.PmpDisclosureType;
import org.nabp.pmpi.PmpDisclosuresType;

/**
 * Main class for connecting and sending search requests to PMPI server
 * @author Vishnu
 */
public class PMPIClient {


    private static final Logger log = Logger.getLogger(PMPIClient.class.getName());

    PMPIHttpClient httpClient;
    private String interConnectId;

    /**
     * 
     * @param url
     * @param username
     * @param password
     * @param interconnectId
     */
    public PMPIClient(String url, String username, String password, String interconnectId){
         this.interConnectId = interconnectId;
         httpClient = new PMPIHttpClient(url, username, password, interconnectId);
    }


   

    /**
     * 
     * @return true if authentication is successfull
     */
    public boolean authenticate(){
        return httpClient.doLogin(true);
    }

    

    /**
     * 
     * @param PmixRequest PMIX request xml
     * @param toInterconnectId destination interconnect id for this search
     * @return
     */
    public String searchRequest(String PmixRequest, String toInterconnectId){

            log.info(" Attempts to send a dummy Request.  ");
            String response = null;

            try
            {
                
                if(!httpClient.isLoggedIn()){
                    boolean authenticated = httpClient.doLogin(true);
                    if(!authenticated){
                        throw new RuntimeException("Authentication failed");
                    }
                }
                


                /*XMLValidator validate_pmix_request = new XMLValidator( this.getClass().getClassLoader().getResourceAsStream("xsd-v03.00.00-ov2/xsd/pmix/niem/PMIX_NIEM_2.0_Request_Schema.xsd"));
                if (!validate_pmix_request.isXMLValid(new StreamSource(new StringReader(PmixRequest))))
                {
                    log.severe("Returned PMIX xml is not valid : " + validate_pmix_request.getValidatResults() + "\r\n" + PmixRequest);
                    throw new RuntimeException("PMIX request xml is not valid :" + validate_pmix_request.getValidatResults());
                }*/


                log.info("Running retrieve public key for pmp #" + toInterconnectId);
                PMPIHttpClientResponse publicKeyRet = httpClient.retrievePublicKey(toInterconnectId,false);
                log.info("Public key returned from server = " + publicKeyRet.getServerResponse());

                String publicKeyInPEMFormat = EncryptionClient.getPEMFormatFromResponseXML(publicKeyRet.getServerResponse());




                EncryptionClient enc = new EncryptionClient();
                //Generate AES password.
                String generatedPwd = enc.generatePassword();
                //AES encrypt the Request.
                String AESEncryptedMessage = enc.getAES256Cipher(PmixRequest, generatedPwd,false);
                //RSA encrypt the password.
                String RSAEncryptedPassword = enc.rsaEncryptPassword(publicKeyInPEMFormat, generatedPwd);


                String PMPIRequest = PMIX2PMPIQueryConstructor.constructSearchRequest(AESEncryptedMessage,
                                                                                      RSAEncryptedPassword,
                                                                                      this.interConnectId,
                                                                                      toInterconnectId,
                                                                                      PmixRequest);

                /*XMLValidator searchRequestXmlValidator = new XMLValidator(this.getClass().getClassLoader().getResource("xsd-v03.00.00-ov2/0-synchronous-report-retrieval/0-report-request/pmpi-search-request.xsd"));
                if (!searchRequestXmlValidator.isXMLValid(new StreamSource(new StringReader(PMPIRequest))))
                {
                    log.severe("Generated request is invalid : " + searchRequestXmlValidator.getValidatResults() + "\r\n" + PMPIRequest);
                    throw new RuntimeException("PMPI request xml is not valid :\r\n" + searchRequestXmlValidator.getValidatResults());
                }*/


                log.info(" Constructed PMPI Request :  " + PMPIRequest);
                PMPIHttpClientResponse resp = httpClient.reportRequest(PMPIRequest,false);
                log.info(" Response : \r\n" + resp.getServerResponse());

                if(!resp.isSuccess()){
                    return null;
                }


                PmpDisclosuresType disclosures = JAXB.unmarshal(new StreamSource(new StringReader(resp.getServerResponse())), PmpDisclosuresType.class);
                PmpDisclosureType disclosure = disclosures.getPmpDisclosure().get(0);
                
                //Process the response:
                if (disclosure.getType() == DisclosureResponseTypeEnumeration.COMPLETE)
                {
                    log.info("Got back  completed response ");

                    InputStream privateKeyPath = this.getClass().getClassLoader().getResourceAsStream("key/private.pem");
                    String PrivateKeyInPEM = Util.readInputStreamAsString(privateKeyPath);
                    String rsaDecryptedPassword = enc.rsaDecryptPassword(PrivateKeyInPEM, disclosure.getEncryptedData().getRsaEncryptedAesKey());
                    String PMIXResponseXml = enc.getAES256Cipher(disclosure.getEncryptedData().getAesEncryptedData(), rsaDecryptedPassword, true);
                    PMIXResponseXml = PMIXResponseXml.trim();
                    log.info("PMIXResponseXml-->>>>" + PMIXResponseXml + "<<<<--");
                    /*XMLValidator pmixResponseValidator = new XMLValidator( this.getClass().getClassLoader().getResource("xsd-v03.00.00-ov2/xsd/pmix/niem/PMIX_NIEM_2.0_PMP_Prescription_Report.xsd"));
                    if (!pmixResponseValidator.isXMLValid(new StreamSource(new StringReader(PMIXResponseXml))))
                    {
                        log.severe("Returned pmix xml is not valid : " + pmixResponseValidator.getValidatResults()+ "\r\n" + PMIXResponseXml);
                        throw new RuntimeException("Returned pmix xml is not valid. " + pmixResponseValidator.getValidatResults());
                    }else
                    {*/
                        log.info(PMIXResponseXml);
                        response = PMIXResponseXml;
                    //}

                }
                else if (disclosure.getType() == DisclosureResponseTypeEnumeration.REFUSED)
                {
                    log.info("Got back a 'refused' response.  Which almost always means we couldn't find any data. ");
                    if (disclosure.getPlaintextData() != null) log.info("More info ?:  " + disclosure.getPlaintextData());
                }
                else if (disclosure.getType() == DisclosureResponseTypeEnumeration.PMPERROR)
                {
                    log.info("Got back a 'pmperror' response which means the destination pmp had a problem.  ");
                    if (disclosure.getPlaintextData() != null) log.info("More info ?:  " + disclosure.getPlaintextData());
                }
                else if (disclosure.getType() == DisclosureResponseTypeEnumeration.ERROR)
                {
                    log.info("Got back a 'error' response which means the Hub had some problem.  ");
                    if (disclosure.getPlaintextData() != null) log.info("More info ?:  " + disclosure.getPlaintextData());
                }
                else if (disclosure.getType() == DisclosureResponseTypeEnumeration.DISALLOWED)
                {
                    log.info("Got back a 'disallowed' response which means one of the business rules set at the Hub has be violated by the request.  ");
                    if (disclosure.getPlaintextData() != null) log.info("More info ?:  " + disclosure.getPlaintextData());
                }

                

                }
            catch (Exception ex)
            {
                log.log(Level.SEVERE," Problem sending a request : " + ex,ex);
                throw new RuntimeException(ex);
            }

            return response;
        }

        
}
