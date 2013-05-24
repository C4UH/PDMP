/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logicoy.pdmp.pmpi.http;

import java.nio.charset.Charset;

/**
 *
 * @author Vishnu
 */
public class UserNameAndPassword {


    private String username;
    private String password;
    private String interocnnectid;

    public UserNameAndPassword(String username, String password, String interconnectid)
    {
        this.username = username;
        this.password = password;
        this.interocnnectid = interconnectid;
    }

    public String getInterocnnectid() {
        return interocnnectid;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }



}
