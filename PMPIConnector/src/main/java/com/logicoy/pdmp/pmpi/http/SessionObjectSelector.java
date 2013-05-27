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
