/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
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
