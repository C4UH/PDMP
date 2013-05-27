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


import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import java.io.StringReader;
import java.io.StringWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.namespace.QName;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.nabp.pmpi.DataElementsType;
import org.nabp.pmpi.DisclosingPmpRequestType;
import org.nabp.pmpi.DisclosingPmpsType;
import org.nabp.pmpi.SearchParametersType;
import org.nabp.pmpi.SearchRequestType;
import org.nabp.pmpi.SearchingPmpType;
import org.nabp.pmpi.UserRoleTypeEnumeration;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Vishnu
 */
public class PMIX2PMPIQueryConstructor {

    private static final Logger logger = Logger.getLogger(PMIX2PMPIQueryConstructor.class.getName());

    public static String constructSearchRequest(String AESEncryptedRequest,
            String RsaEncryptedAesKey,
            String Sender,
            String Receiver,
            String UnencryptedData_for_table_of_contents){

        List<String> dataElementsList = getXpathsFromPMIX(UnencryptedData_for_table_of_contents);

        
        SearchRequestType searchRequest = new SearchRequestType(); //Top Element

        
        SearchingPmpType searchingPmp = new SearchingPmpType();
        searchingPmp.setInterconnectPmpId(new BigInteger(Sender));
        searchingPmp.setPmpUserRole(UserRoleTypeEnumeration.PHARMACIST);
        searchingPmp.setPmpSearchId("YOURPMPSIDFORTHEREQUEST");
        searchRequest.setSearchingPmp(searchingPmp); //SearchingPmp

        DisclosingPmpsType disclosingPmps = new DisclosingPmpsType();
        DisclosingPmpRequestType disclosingPmp = new DisclosingPmpRequestType();
        disclosingPmp.getInterconnectPmpId().add(new BigInteger(Receiver));
        disclosingPmp.setRsaEncryptedAesKey(RsaEncryptedAesKey);
        disclosingPmps.getDisclosingPmp().add(disclosingPmp);
        searchRequest.setDisclosingPmps(disclosingPmps);

        SearchParametersType searchParameters = new SearchParametersType();
        DataElementsType dataElements = new DataElementsType();
        
        for(String dataElement : dataElementsList){
            dataElements.getDataElement().add(dataElement);
        }
        searchParameters.setDataElements(dataElements);
        searchParameters.setAesEncryptedData(AESEncryptedRequest);
        searchRequest.setSearchParameters(searchParameters);

        

        StringWriter strWriter = new StringWriter();
        try {
            JAXBContext ctx = JAXBContext.newInstance(searchRequest.getClass());
            Marshaller marshaller = ctx.createMarshaller();
            marshaller.setProperty("com.sun.xml.bind.namespacePrefixMapper",new MyNamespacePrefixMapper());
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            
            marshaller.marshal(new JAXBElement(new QName("http://pmpi.nabp.org/", "SearchRequest","pmpi"), SearchRequestType.class, searchRequest),strWriter);
            
            

            //JAXB.marshal(searchRequest, strWriter);
            //JAXB.marshal(new JAXBElement(new QName("http://pmpi.nabp.org/", "SearchRequest","pmpi"), SearchRequestType.class, searchRequest),strWriter);
        } catch (JAXBException ex) {
            Logger.getLogger(PMIX2PMPIQueryConstructor.class.getName()).log(Level.SEVERE, null, ex);
        }
        //JAXB.marshal(searchRequest, strWriter);
        //JAXB.marshal(new JAXBElement(new QName("http://pmpi.nabp.org/", "SearchRequest","pmpi"), SearchRequestType.class, searchRequest),strWriter);

        return strWriter.toString();

        
    }
    public static List<String> getXpathsFromPMIX(String pmixXml){

        try{
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            MyDefaultHandler handler = new MyDefaultHandler();
            saxParser.parse(new InputSource(new StringReader(pmixXml)),handler);
            return handler.getXPaths();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
        
    }

}

class MyDefaultHandler extends DefaultHandler{

    private static final Logger logger = Logger.getLogger(MyDefaultHandler.class.getName());
    ArrayList<String> xpaths = new ArrayList<String>();
    HashMap<String,String> prefixMap = new HashMap<String,String>();

    String currentXPath = "";

    private int elementNo = 0;
    
    public void startElement(String uri, String localName,String qName,
                Attributes attributes) throws SAXException {

        logger.finest("Started Element : " +  qName);
       elementNo++;
       this.currentXPath = this.currentXPath + "/" + qName;
       if(elementNo == 1){
           return;
       }
       
       xpaths.add(this.currentXPath);
        

    }

    public void startPrefixMapping(String prefix, String uri)
                        throws SAXException{
        logger.finest("Started Prefix Mapping : " + prefix + ":" + uri);
        prefixMap.put(uri, prefix);
    }

    public void endElement(String uri, String localName, String qName)
                throws SAXException{
        logger.finest("Ended Element : " + qName);
        this.currentXPath = this.currentXPath.replace("/" + qName,"");
    }

    public List<String> getXPaths(){
        return this.xpaths;
    }
 
}

class MyNamespacePrefixMapper extends NamespacePrefixMapper{

    HashMap<String,String> nsMap = new HashMap<String,String>();

    public MyNamespacePrefixMapper(){
        nsMap.put("http://pmpi.nabp.org/","pmpi");
    }
    
    
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requiredPrefix) {
        return nsMap.get(namespaceUri);
    }
    
}

