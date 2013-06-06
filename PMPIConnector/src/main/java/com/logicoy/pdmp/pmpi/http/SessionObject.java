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


import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;

/**
 *
 * @author Vishnu
 */
public class SessionObject {

    private String interconnectId;
    private long lastUpdatedAt;
    private static final int TIMEOUT_IN_MINS = 10;

    private CookieStore cookieStore;
    
    public SessionObject(String interconnectId){
        this.interconnectId = interconnectId;
        this.cookieStore = new BasicCookieStore();
    }

    public boolean inSessionTimeoutWindow(){

        long now = System.currentTimeMillis();
        long diff = now - lastUpdatedAt;

        long timeoutInMillis = 1000 * 60 * TIMEOUT_IN_MINS;
        if (diff > timeoutInMillis){
            return false;
        }else{
            return true;
        }
    }

    public CookieStore getCookieStore() {
        synchronized(this){
            return cookieStore;
        }
    }

    
    
}
