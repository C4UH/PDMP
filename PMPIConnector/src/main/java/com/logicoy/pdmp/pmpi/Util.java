/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logicoy.pdmp.pmpi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Vishnu
 */
public class Util {

    public static String readFileAsString(File file)
   {
        try{
            StringBuffer fileData = new StringBuffer(1000);
            BufferedReader reader = new BufferedReader(
            new FileReader(file));
            char[] buf = new char[1024];
            int numRead=0;
            while((numRead=reader.read(buf)) != -1){
                String readData = String.valueOf(buf, 0, numRead);
                fileData.append(readData);
                buf = new char[1024];
            }
            reader.close();
            System.out.println(fileData.toString());
            return fileData.toString();
        }catch(IOException e){
            throw new RuntimeException(e);
        }

    }
    
   public static String readInputStreamAsString(InputStream file)
   {
        try{
            StringBuffer fileData = new StringBuffer(1000);
            //BufferedReader reader = new BufferedReader(
            //new FileReader(file));
            byte[] buf = new byte[1024];
            int numRead=0;
            while((numRead=file.read(buf)) != -1){
                String readData = new String(buf, 0, numRead);
                fileData.append(readData);
                buf = new byte[1024];
            }

            System.out.println(fileData.toString());
            return fileData.toString();
        }catch(IOException e){
            throw new RuntimeException(e);
        }finally{
            try {
                file.close();
            } catch (IOException ex) {
                Logger.getLogger(PMPIClient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
}
