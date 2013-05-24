/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logicoy.pdmp.pmpi.http;

/**
 *
 * @author Vishnu
 */
public class PMPIHttpClientResponse {


        private boolean success = false;
        private String serverResponse;
        private int httpStatusCode;

        private String httpRequestHeaders;
        private String httpResponseHeaders;
        private String cookiesInfo;
        private String httpStatusDesc;

        public PMPIHttpClientResponse()
        {
        }

    public String getHttpRequestHeaders() {
        return httpRequestHeaders;
    }

    public void setHttpRequestHeaders(String httpRequestHeaders) {
        this.httpRequestHeaders = httpRequestHeaders;
    }

    public String getHttpResponseHeaders() {
        return httpResponseHeaders;
    }

    public void setHttpResponseHeaders(String httpResponseHeaders) {
        this.httpResponseHeaders = httpResponseHeaders;
    }

    public int getHttpStatusCode() {
        return httpStatusCode;
    }

    public void setHttpStatusCode(int httpStatusCode) {
        this.httpStatusCode = httpStatusCode;
    }

    public String getServerResponse() {
        return serverResponse;
    }

    public void setServerResponse(String serverResponse) {
        this.serverResponse = serverResponse;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCookiesInfo() {
        return cookiesInfo;
    }

    public void setCookiesInfo(String cookiesInfo) {
        this.cookiesInfo = cookiesInfo;
    }

    public String getHttpStatusDesc() {
        return httpStatusDesc;
    }

    public void setHttpStatusDesc(String httpStatusDesc) {
        this.httpStatusDesc = httpStatusDesc;
    }


}
