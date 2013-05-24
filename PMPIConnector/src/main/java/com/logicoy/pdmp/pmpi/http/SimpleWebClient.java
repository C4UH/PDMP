/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logicoy.pdmp.pmpi.http;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 *
 * @author Vishnu
 */
public class SimpleWebClient {

    private static final Logger logger = Logger.getLogger(SimpleWebClient.class.getName());
    private String requestHeadersString;
    private String responseHeadersString;
    private String serverResponseString;

    public boolean ok = false;
    public boolean response_read = false;

    public static boolean IgnoreSslErrors = false;

    public enum ActionType { GET, POST, PUT, DELETE };

    private HttpResponse httpResponse = null;

    private DefaultHttpClient httpclient = null;
    
    public SimpleWebClient( ){
        httpclient = new DefaultHttpClient();

    }

    public PMPIHttpClientResponse sendRequest(SessionObject SessionObj , SimpleWebClientSettings settings){

        HttpRequestBase httpRequest = null;
        //HttpPost httpPost = null;
        //HttpGet httpGet = null;
        try{

            if(settings.getAction() == SimpleWebClientSettings.ActionType.POST){
                httpRequest = new HttpPost(settings.getUri());
            }else{
                httpRequest = new HttpGet(settings.getUri());
            }
            
            httpRequest.setHeader("Content-Type", settings.getContentType());
            httpRequest.setHeader("Allow-Auto-Redirect",String.valueOf(settings.getAutoRedirect()));
            httpRequest.setHeader("Keep-Alive", String.valueOf(settings.getKeepAlive()));

            if(settings.getAccept() != null && !settings.getAccept().equals("")){
                httpRequest.setHeader("Accept", settings.getAccept());
            }
            if(settings.getMessageBody() != null && !settings.getMessageBody().equals("")  && settings.getAction() == SimpleWebClientSettings.ActionType.POST ){
                byte[] postData = settings.getMessageBody().getBytes(Charset.forName("UTF-8"));

                StringEntity entity = new StringEntity(settings.getMessageBody(), ContentType.create(settings.getContentType(), Charset.forName("UTF-8")));
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                entity.writeTo(baos);
                HttpPost httpPost = (HttpPost)httpRequest;
                httpPost.setEntity(entity);
                
            }
            try{
                 
                 httpclient.setCookieStore(SessionObj.getCookieStore());
                 httpResponse = httpclient.execute(httpRequest);
                }catch(IOException ioe){
                    logger.log(Level.SEVERE,"Error while posting data",ioe);
                    throw ioe;
                }
                PMPIHttpClientResponse resp = new PMPIHttpClientResponse();
                populateResponseObject(httpResponse, resp);
                System.out.println("Status code returned from server : " + httpResponse.getStatusLine().getStatusCode());
                System.out.println("Status resson phrase returned from server : " + httpResponse.getStatusLine().getReasonPhrase());
                //EntityUtils.consume(httpResponse.getEntity());
                return resp;


        }catch(Exception e){
            ok = false;
            logger.log(Level.SEVERE,e.getMessage(),e);
            return null;
        }finally{
            if(httpRequest != null){
                httpRequest.releaseConnection();
            }
        }

        
    }

    private void populateResponseObject(HttpResponse httpResp, PMPIHttpClientResponse respobj)
        {
         try{
            /*respobj.HttpRequestHeaders = swc.RequestHeadersText;
            respobj.HttpResponseHeaders = swc.ResponseHeadersText;*/
            /*InputStream is = httpResp.getEntity().getContent();

            byte[] content = new byte[1024 * 10];

            int numRead=0;

            StringBuilder strContent = new StringBuilder();
            numRead = is.read(content, 0, content.length);
            while(numRead != -1){
                String readData = new String(content,0,numRead);
                strContent.append(readData);
                numRead = is.read(content, 0, content.length);
            }*/

            //respobj.setServerResponse(strContent.toString());
            respobj.setServerResponse(EntityUtils.toString(httpResp.getEntity()));
            respobj.setHttpStatusCode(httpResp.getStatusLine().getStatusCode());
            respobj.setHttpStatusDesc(httpResp.getStatusLine().getReasonPhrase());
            
         }catch(Exception e){
             throw new RuntimeException(e);
         }

            //respobj.setServerResponse(swc.);
        }
    
}
