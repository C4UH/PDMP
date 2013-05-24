/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.logicoy.pdmp.pmpi.crypto;

import java.io.StringReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilderFactory;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.AESEngine;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.paddings.PKCS7Padding;
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.util.PrivateKeyFactory;
import org.bouncycastle.crypto.util.PublicKeyFactory;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author Vishnu
 */
public class EncryptionClient {

    private static final Logger logger = Logger.getLogger(EncryptionClient.class.getName());

    public String generatePassword() {
        //There is a max length that the password can be based on the size of the RSA key.
        //PMPI recommends everyone uses 2048 bit RSA keys.  But if a PMP uses a shorter key
        //then you have to be careful how many bytes you make your password. Each byte can be
        //thought off as one ascii character.
        int min_bytes = 50;
        int max_bytes = 64;
        SecureRandom rngCsp = new SecureRandom();
        byte[] howmanybytes = new byte[1];
        rngCsp.nextBytes(howmanybytes);
        Random r = new Random(howmanybytes[0]);
        //byte[] randomNumber = new byte[r.Next(min_bytes,max_bytes)]; C#DIFF
        //byte[] randomNumber = new byte[r.nextInt(max_bytes)];
        byte[] randomNumber = new byte[(r.nextInt(max_bytes - min_bytes) + min_bytes)];
        rngCsp.nextBytes(randomNumber);

        //Base 64 so that all bytes can be represented in text.
        String password = new String(Base64.encode(randomNumber));

        logger.info("password length = " + password.length());
        return password;
    }

    public String getAES256Cipher(String inputText, String password, boolean decrypt) {
            KeyIVGenerator  derivedFromPassword = new KeyIVGenerator(password);
            // Set up key and IV these are derived from the password, using MD5 very simple. See class details.

            try
            {
                byte[] buffer;
                //Sting to encrypt
                if (!decrypt)
                {
                    buffer = inputText.getBytes(Charset.forName("UTF-8"));
                }
                else
                {
                    buffer = Base64.decode(inputText);
                }

                // Aes Encryption
                BlockCipher blockCipher = new AESEngine();
                
                // Mode CBC
                blockCipher = new CBCBlockCipher(blockCipher);

                
                BlockCipherPadding padding = new PKCS7Padding();

                // Get our Cipher.
                PaddedBufferedBlockCipher cipher = new PaddedBufferedBlockCipher(blockCipher,padding);

                
                // Initialize the cipher.
                cipher.init(!decrypt, new ParametersWithIV(new KeyParameter(derivedFromPassword.getKey()), derivedFromPassword.getIV()));
                //byte[] bytes_output = cipher.doFinal(buffer,0);
                byte bytes_output[] = new byte[cipher.getOutputSize(buffer.length)];
                int len = cipher.processBytes(buffer, 0, buffer.length, bytes_output, 0);
                int noOfBytesCopied = cipher.doFinal(bytes_output, len);


                if (!decrypt)
                {
                    //Return base 64 encrypted text.
                    return new String(Base64.encode(bytes_output),Charset.forName("UTF-8"));
                    //return Convert.ToBase64String(bytes_output, Base64FormattingOptions.InsertLineBreaks);
                }
                else
                {
                    //Return plain text.
                    return new String(bytes_output,Charset.forName("UTF-8"));
                }

            }
            catch (Exception e)
            {
                logger.severe(" Failure attempting to AES256 encrypt/decrypt the xml " + e.toString());
                e.printStackTrace();
                throw new RuntimeException(" Failure attempting AES256 " + (decrypt ? "decryption" : "encryption") + " :" + e.getMessage());
        } finally {
            derivedFromPassword.Clean();
        }

    }

    /// <summary>
        /// Take a string and then encrypt it and return a base64 string.
        /// </summary>
        /// <param name="TextToEncrypt">Text to encrypt</param>
        /// <param name="RSAPublicKey">RsaKeyParamters containing a RSAPublicKey</param>
        /// <returns></returns>
        public String rsaEncryptPassword(String publicKeyInPEM, String password)
        {
            String encrypted = "";
            try
            {
                RSAKeyParameters rsaPublicKey;
                Reader reader = new StringReader(publicKeyInPEM);
                PemObject pemObj = new PemReader(reader).readPemObject();

                rsaPublicKey = (RSAKeyParameters)PublicKeyFactory.createKey(pemObj.getContent());

                byte[] bytesToEncrypt = password.getBytes(Charset.forName("UTF-8"));

                PKCS1Encoding encryptEngine = new PKCS1Encoding(new RSAEngine());
                encryptEngine.init(true, rsaPublicKey);
                encrypted = new String(Base64.encode(encryptEngine.processBlock(bytesToEncrypt, 0, bytesToEncrypt.length)),Charset.forName("UTF-8"));

            }
            catch (Exception ex)
            {
                logger.severe(" Failure attempting to encrypt via RSA.  \r\n PublicKeyInPEM:" + publicKeyInPEM + "\r\n Exception : " + ex.toString());
                throw new RuntimeException(" Failure attempting to encrypt the RSA encrypted password. See Interface log for more details. Message : " + ex.getMessage());
            }
            return encrypted;

        }

        /// <summary>
        /// Take a Base64Encrypted string and an RsaKeyParameters object containing a private key.
        /// and decrypt them returning the unencrypted string.
        /// </summary>
        /// <param name="Base64Encrypted">Base64Encrypted</param>
        /// <param name="RSAprivateKey">RSAprivateKey</param>
        /// <returns></returns>
        public String rsaDecryptPassword(String PrivateKeyInPEM, String Base64Encrypted)
        {
            String decrypted = "";
            try
            {
                RSAKeyParameters rsaprivateKey;

                Reader reader = new StringReader(PrivateKeyInPEM);
                PemObject pemObj = new PemReader(reader).readPemObject();

                rsaprivateKey = (RSAKeyParameters)PrivateKeyFactory.createKey(pemObj.getContent());
                

                byte[] bytesToDecrypt = Base64.decode(Base64Encrypted);
                //byte[] bytesToDecrypt = Convert.FromBase64String(Base64Encrypted);

                PKCS1Encoding decryptEngine = new PKCS1Encoding(new RSAEngine());
                decryptEngine.init(false, rsaprivateKey);
                decrypted = new String(decryptEngine.processBlock(bytesToDecrypt, 0, bytesToDecrypt.length),Charset.forName("UTF-8"));
                //decrypted = Encoding.UTF8.GetString(decryptEngine.ProcessBlock(bytesToDecrypt, 0, bytesToDecrypt.Length));

            }
            catch (Exception ex)
            {
                //Without logging the private key lets get some info to make sure it looks like it could be a proper private key.
                String private_key_message = " Private key ";
                if (PrivateKeyInPEM.indexOf("----BEGIN PRIVATE KEY----") > 0)
                {
                    private_key_message += " Has '----BEGIN PRIVATE KEY----' at pos " + PrivateKeyInPEM.indexOf("----BEGIN PRIVATE KEY----");
                }
                if (PrivateKeyInPEM.indexOf("----END PRIVATE KEY----") > 0)
                {
                    private_key_message += " Has '----END PRIVATE KEY----' at pos " + PrivateKeyInPEM.indexOf("----END PRIVATE KEY----");
                }
                private_key_message += " Length : " + PrivateKeyInPEM.length();

                logger.log(Level.SEVERE," Failure attempting to decrypt via RSA. \r\n Base64Encrypted string : " + Base64Encrypted + " \r\n PrivateKeyInPEM " + private_key_message + " \r\n Exception : " + ex.toString(),ex);
                throw new RuntimeException(" Failure attempting to encrypt the RSA encrypted password. See Interface log for more details. Message : " + ex.getMessage());
            }
            return decrypted.toString();
        }

        /// <summary>
            /// Take a Hub retrieve key xml response and get the PEM from it.
            /// </summary>
            /// <returns></returns>
            public static String getPEMFormatFromResponseXML(String XMLFormat)
            {

                try{
                    Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new InputSource(new StringReader(XMLFormat)));
                    
                    logger.info("pemFormat = " + doc.getDocumentElement().getTextContent());

                    NodeList nodes  = doc.getElementsByTagNameNS("http://pmpi.nabp.org/", "pmpi:RsaPublicKey");
                    String pemFormat =  doc.getDocumentElement().getTextContent();
                    
                    //System.Xml.Linq.XNamespace pmpi = "http://pmpi.nabp.org/";
                    //String PEMFormat = doc.Element(pmpi + "RsaPublicKey").Value;

                    //Make sure we have no leading line breaks...
                    //Regex reg = new Regex(@"^\s*\n", RegexOptions.Multiline);
                    pemFormat = pemFormat.replaceFirst("^\\s*\\n", "");
                    //Pattern reg = Pattern.compile("^\s*\n");
                    //PEMFormat = reg.Replace(PEMFormat, "", 1);
                    return pemFormat;

                }catch(Exception e){
                    throw new RuntimeException(e);
                }
            }
}
