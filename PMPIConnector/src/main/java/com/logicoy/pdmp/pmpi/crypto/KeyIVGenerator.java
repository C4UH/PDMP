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

package com.logicoy.pdmp.pmpi.crypto;

import java.math.BigInteger;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.logging.Logger;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author Vishnu
 */
public class KeyIVGenerator {


            private static final Logger logger = Logger.getLogger(KeyIVGenerator.class.getName());
            private String password;
            private byte[] iv;
            private byte[] key;

            /// <summary>
            /// This provides takes the password that you supply
            /// Use this if you have an incoming password you want the key and IV for
            /// or you want to generate your own passwords.
            /// </summary>
            /// <param name="password"></param>
            public KeyIVGenerator(String password)
            {
                this.password = password;
                deriveKeyAndIV();
            }


            // for the uberparnoid
            public void Clean()
            {
                for (int i = 0; i < this.key.length; i++)
                {
                    this.key[i] = 0;
                }
                for (int i = 0; i < this.iv.length; i++)
                {
                    this.iv[i] = 0;
                }

                this.password  = "";
            }


            /// <summary>
            /// Here we are Deriving the Key and IV from the
            /// password.  The way this is done is
            /// Key = sha256(password)
            /// IV = MD5(key)
            /// </summary>
            private void deriveKeyAndIV()
            {

                try{
                    //MessageDigest sha256 = MessageDigest.getInstance("SHA");
                    //MessageDigest md5 = MessageDigest.getInstance("MD5");
                    // Create Key and IV from password
                    byte[] password = this.password.getBytes(Charset.forName("UTF-8"));

                    // Key = sha256(password)
                    
                    this.key = DigestUtils.sha256(password);
                    logger.info("Key length= " + this.key.length);
                    // IV = MD5(password)
                    //this.iv = md5.digest(this.key);
                    this.iv = DigestUtils.md5(this.key);
                   
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
            }


            public String getPassword()
            {
                return this.password;
            }


            public byte[] getKey()
            {
                return this.key;
            }


            public byte[] getIV()
            {
                return this.iv;
            }


            // take a string and produce a MD5 of that string.
           /* private static String MD5(String password)
            {
                try
                {
                    MessageDigest x = MessageDigest.getInstance("MD5");
                    byte[] bs = password.getBytes(Charset.forName("UTF-8"));
                    bs = x.digest(bs);
                   StringBuilder s = new StringBuilder();
                    for(byte b : bs)
                    {
                        //s.append()
                        //s.append(b.toString("x2").toLower());
                    }
                    password = s.toString();
                    return password;
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
            
            

        }*/
}
