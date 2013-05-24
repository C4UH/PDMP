/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logicoy.pdmp.pmpi.http;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Vishnu
 */
public abstract class BasePMPIHttpClient {

    protected String base_url;
    protected UserNameAndPassword userNameAndPassword;
    protected SessionObject sessionObj;
    
    public BasePMPIHttpClient(String base_url, String username,  String password, String interconnectid)
        {
            if (base_url == null)
                throw new RuntimeException(" Base URL was null. ");

            if (password == null)
                throw new RuntimeException(" Username sent to PMPIHttpClient was null. ");

            if (interconnectid == null)
                throw new RuntimeException(" Password sent to PMPIHttpClient was null. ");

            this.base_url = base_url;
            this.userNameAndPassword = new UserNameAndPassword(username, password,interconnectid);
            this.sessionObj = SessionObjectSelector.getInstance().getSessionObject(interconnectid);
        }

     

     public abstract PMPIHttpClientResponse retrievePublicKey(String PMPInterconnectId, boolean retrying);

     
}
