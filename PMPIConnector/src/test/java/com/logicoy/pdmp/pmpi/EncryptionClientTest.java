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

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logicoy.pdmp.pmpi;

import com.logicoy.pdmp.pmpi.crypto.EncryptionClient;
import java.io.File;
import java.net.URI;
import java.util.logging.Logger;

/**
 *
 * @author Vishnu
 */
public class EncryptionClientTest {

    private static final Logger log = Logger.getLogger(EncryptionClientTest.class.getName());

    public void testEncryptDecript() throws Exception{
        String plainText = " Here is the plain text that will be encrypted and decrypted. ";
        //Note PMPI uses PEM formatted keys. Here we just pulling these out of local files.
            //if you would like to grab these from the windows Csp then I have some code that can do that also just ask me.
        URI publicKeyPath = this.getClass().getClassLoader().getResource("key/public.pem").toURI();
        URI privateKeyPath = this.getClass().getClassLoader().getResource("key/private.pem").toURI();
        log.info("public key path " + publicKeyPath);
        log.info("private key path " + privateKeyPath);
        String PublicKeyInPEMFormat = Util.readFileAsString(new File(publicKeyPath));
        String PrivateKeyInPEMFormat = Util.readFileAsString(new File(privateKeyPath));

        EncryptionClient enc = new EncryptionClient();

        String password = enc.generatePassword();
        //log.info("Password :\r\n " + password);

        //AES encrypt the Request.
        String AESEncryptedMessage = enc.getAES256Cipher(plainText, password,false);
        //RSA encrypt the password.
        String RSAEncryptedPassword = enc.rsaEncryptPassword(PublicKeyInPEMFormat, password);

        log.info("AES encrypted message goes in <AesEncryptedData> node :\r\n " + AESEncryptedMessage);
        log.info("RSA encrypted password goes in <RsaEncryptedAesKey> node:\r\n " + RSAEncryptedPassword);

        String RSADecryptedPassword = enc.rsaDecryptPassword(PrivateKeyInPEMFormat, RSAEncryptedPassword);

        log.info("RSA decrypted password :\r\n " + RSADecryptedPassword);

        String AESDecryptedText = enc.getAES256Cipher(AESEncryptedMessage, RSADecryptedPassword, true);

        log.info("AES Decrypted Text :\r\n " + AESDecryptedText);

    }

}
