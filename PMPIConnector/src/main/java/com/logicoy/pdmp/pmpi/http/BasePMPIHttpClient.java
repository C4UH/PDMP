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
