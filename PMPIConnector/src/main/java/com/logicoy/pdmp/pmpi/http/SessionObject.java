/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
