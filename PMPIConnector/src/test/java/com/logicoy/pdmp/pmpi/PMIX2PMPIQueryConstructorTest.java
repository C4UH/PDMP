/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.logicoy.pdmp.pmpi;

import java.io.File;
import java.util.List;

/**
 *
 * @author Vishnu
 */
public class PMIX2PMPIQueryConstructorTest {

    public void testGetXPaths(){
        PMIX2PMPIQueryConstructor queryConstructor = new PMIX2PMPIQueryConstructor();
        String xml = Util.readInputStreamAsString(this.getClass().getResourceAsStream("/pmix-request.xml"));
        List<String> xpaths = queryConstructor.getXpathsFromPMIX(xml);

        for(String xpath : xpaths){
            System.out.println(xpath);
        }

    }

    public void testConstructPMPIQuery(){
        System.out.println("Constructing PMPI Query");
        PMIX2PMPIQueryConstructor queryConstructor = new PMIX2PMPIQueryConstructor();
        String xml = Util.readInputStreamAsString(this.getClass().getResourceAsStream("/pmix-request.xml"));
        String constructedXml = queryConstructor.constructSearchRequest("THISISaesEncRYPtedDatA", "THisSRsaEncryptedKEy", "30", "12", xml);
        System.out.println(constructedXml);
    }
}
