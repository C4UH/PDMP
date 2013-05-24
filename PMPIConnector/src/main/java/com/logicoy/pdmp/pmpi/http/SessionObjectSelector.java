/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logicoy.pdmp.pmpi.http;

import java.util.Hashtable;
import java.util.Map;

/**
 *
 * @author Vishnu
 */
public class SessionObjectSelector {

    private static volatile SessionObjectSelector instance = null;
    private static final Object syncRoot = new Object();

    private Map<String, SessionObject> sessionObjects = new Hashtable<String, SessionObject>();

    public SessionObject getSessionObject(String interconnectId){
        
        synchronized(this){
            if(sessionObjects.containsKey(interconnectId)){
                return sessionObjects.get(interconnectId);
            }else{
                SessionObject sessionObj = new SessionObject(interconnectId);
                sessionObjects.put(interconnectId,sessionObj);
                return sessionObj;
            }
        }

    }

    public static SessionObjectSelector getInstance(){
        if(instance == null){
            synchronized(syncRoot){
                if(instance == null){
                    instance = new SessionObjectSelector();
                }
            }
        }
        return instance;
    }
}
