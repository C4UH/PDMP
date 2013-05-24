/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logicoy.pdmp.pmpi.http;

import java.nio.charset.Charset;
import java.text.MessageFormat;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;

/**
 *
 * @author Vishnu
 */
public class PMPIHttpClient extends BasePMPIHttpClient{


    private static final Logger log = Logger.getLogger(PMPIHttpClient.class.getName());

    private boolean loggedIn = false;
    
    public PMPIHttpClient(String base_url, String username, String password, String interconnectid){
        super(base_url,username,password,interconnectid);
    }

    public boolean doLogin(boolean force){

        if(force || !this.sessionObj.inSessionTimeoutWindow() || loggedIn){
            if(this.userNameAndPassword == null){
                throw new RuntimeException("Attempting to post to authenticate but the userNameAndPassword have not been set! ");
            }

            Charset utf8 = Charset.forName("UTF-8");
            String strMessageBody = "";
            char checkmark = '\u2713'; //check mark in utf8. Not sure if it is needed. But it was present in the web form.
            strMessageBody += "utf-8=" + checkmark;
            strMessageBody += "&user_session[login]=" + userNameAndPassword.getUsername();
            strMessageBody += "&user_session[password]=" + userNameAndPassword.getPassword();
            //strMessageBody += "&commit=Login"; //this causes failure for the system user now..

            String URI = base_url + "/user_sessions";

            SimpleWebClient swc = new SimpleWebClient();
            PMPIHttpClientResponse resp = swc.sendRequest(this.sessionObj,new SimpleWebClientSettings(URI, SimpleWebClientSettings.ActionType.POST, "application/x-www-form-urlencoded", strMessageBody, "application/xml",false, false, false));

            log.info(new MessageFormat("Attempting login for Interconnect ID : {0} user {1} ").format(this.userNameAndPassword.getInterocnnectid(), this.userNameAndPassword.getUsername()));
            if (resp != null)
            {
                if (resp.getHttpStatusCode() == HttpStatus.SC_OK)
                {
                    //Request ok, attempt to parse xml.
                    //this.ErrorMessage(currentMethod, "302 Found", swc, resp);
                    log.warning("Server returned OK " + resp.getHttpStatusDesc());
                    loggedIn = false;
                    return loggedIn;
                }
                else if (resp.getHttpStatusCode() == HttpStatus.SC_MOVED_TEMPORARILY)
                {
                    log.info(" Login expect (302 Found) received " + String.valueOf(resp.getHttpStatusCode()) + " " + resp.getHttpStatusCode() + " indicating that we have successfully logged in and the web server is trying to redirect us to the landing page. ");
                    loggedIn = true;
                    return loggedIn;
                }
                else
                {
                    //this.ErrorMessage(currentMethod, "302 Found", swc, resp);
                    log.warning("Server returned " + resp.getHttpStatusCode() + " " + resp.getHttpStatusDesc());
                    loggedIn = false;
                    return loggedIn;
                }
            }
            else
            {
                log.warning("No Response from Web Server");
                loggedIn = false;
                return loggedIn;
            }
        }
        else  // Because we are not forcing a login and our session object has been created we are going to assume
        {     // that we don't need to log in and just return success.
             // If we needed to really log in then our operation would fail and our method would try to login later.
            return true;
        }
           

    }

    public PMPIHttpClientResponse retrievePublicKey(String PMPInterconnectId, boolean retrying)
    {
            String URI = base_url + "/hub/v1/pmps/" + PMPInterconnectId + "/key";
            SimpleWebClient swc = new SimpleWebClient();
            PMPIHttpClientResponse resp = swc.sendRequest(this.sessionObj,
                        new SimpleWebClientSettings(URI, SimpleWebClientSettings.ActionType.GET,"application/xml", "", "application/xml", false, true, true));

                    if (resp != null)
                    {

                        if (resp.getHttpStatusCode() == HttpStatus.SC_OK)
                        {
                            //Request ok, attempt to parse xml.
                            log.info(" retrieve public key returned (200 OK!) indicating success  Data Length Returned : " + resp.getServerResponse().length());
                            resp.setSuccess(true);

                        }
                        else if (resp.getHttpStatusCode() == HttpStatus.SC_UNAUTHORIZED)
                        {
                            if (!retrying && doLogin(true))
                            {
                                log.warning("Received Unauthorized as response, login and try again. ");
                                resp = retrievePublicKey(PMPInterconnectId, true);
                            }
                            else
                            {
                                log.warning("Server returned " + resp.getHttpStatusCode() + " " + resp.getHttpStatusDesc());
                            }
                        }
                        else
                        {
                            log.warning("Server returned " + resp.getHttpStatusCode() + " " + resp.getHttpStatusDesc());
                        }
                    } else{
                        throw new RuntimeException("No Response from web server ");
                    }

            return resp;
        }

    /// <summary>
        /// This makes a synchronous report request.  As in 0-synchronous-report-retrieval
        /// </summary>
        /// <param name="strMessageBody"></param>
        /// <param name="retrying"></param>
        /// <returns></returns>
        public PMPIHttpClientResponse reportRequest(String strMessageBody, boolean retrying)
        {

            String URI = base_url + "/hub/v1/search/requests";
            log.info(" Sending Report Request to Hub at " + URI);
            SimpleWebClient swc = new SimpleWebClient();
            PMPIHttpClientResponse resp = swc.sendRequest(this.sessionObj,
                new SimpleWebClientSettings(URI, SimpleWebClientSettings.ActionType.POST, "application/xml", strMessageBody, "application/xml", true, true, false));
              


            //Log cookie info to debug...
            if (resp != null)
            {

                if (resp.getHttpStatusCode() == HttpStatus.SC_OK)
                {
                    //Request ok, attempt to parse xml.
                    log.info(" report_request got (200 OK) indicating that the service is reachable. DataLength Returned: " + resp.getServerResponse().length());
                    resp.setSuccess(true);
                }
                else if (resp.getHttpStatusCode() == HttpStatus.SC_UNAUTHORIZED)
                {
                    if (!retrying && doLogin(true))
                    {
                        log.warning("Received Unauthorized as response, Attempting to login and try again. ");
                        resp = reportRequest(strMessageBody, true);
                    }
                    else
                    {
                       log.warning("Server returned : " + resp.getHttpStatusCode() + " " + resp.getHttpStatusDesc());
                    }

                }
                else
                {
                    log.warning("Server returned : " + resp.getHttpStatusCode() + " " + resp.getHttpStatusDesc());
                }
            }
            else
            {
                log.warning(" No Response from server. Indicating that the service is unreachable. ");
            }

            return resp;
        }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    


}
    

