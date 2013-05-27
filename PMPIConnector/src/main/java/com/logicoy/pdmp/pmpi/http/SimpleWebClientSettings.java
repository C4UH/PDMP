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

import java.util.Map;

/**
 *
 * @author Vishnu
 */
public class SimpleWebClientSettings {

    public SimpleWebClientSettings(String uri,ActionType action,String contentType, String MessageBody,String accept,boolean autoRedirect,
             boolean keepAlive,boolean preAuth){
            this.AddHeaders = null;
            this.uri = uri;
            this.action = action;
            this.ContentType = contentType;
            this.MessageBody = MessageBody;
            this.accept = accept;
            this.keepAlive = keepAlive;
        }
    
    public enum ActionType{
        GET,
        POST,
        PUT,
        DELETE
    }

    private String uri;
    private String ContentType;
    private String MessageBody;
    private String accept;
    private boolean autoRedirect;
    private boolean keepAlive;
    private boolean preAuth;
    private Map<String, String> AddHeaders;
    private ActionType action;

    public ActionType getAction() {
        return action;
    }

    public void setAction(ActionType action) {
        this.action = action;
    }

    

    public Map<String, String> getAddHeaders() {
        return AddHeaders;
    }

    public void setAddHeaders(Map<String, String> AddHeaders) {
        this.AddHeaders = AddHeaders;
    }

    public String getContentType() {
        return ContentType;
    }

    public void setContentType(String ContentType) {
        this.ContentType = ContentType;
    }

    public String getMessageBody() {
        return MessageBody;
    }

    public void setMessageBody(String MessageBody) {
        this.MessageBody = MessageBody;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public boolean getAutoRedirect() {
        return autoRedirect;
    }

    public void setAutoRedirect(boolean autoRedirect) {
        this.autoRedirect = autoRedirect;
    }

    public boolean getKeepAlive() {
        return keepAlive;
    }

    public void setKeepAlive(boolean keepAlive) {
        this.keepAlive = keepAlive;
    }

    public boolean isPreAuth() {
        return preAuth;
    }

    public void setPreAuth(boolean preAuth) {
        this.preAuth = preAuth;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    
}
