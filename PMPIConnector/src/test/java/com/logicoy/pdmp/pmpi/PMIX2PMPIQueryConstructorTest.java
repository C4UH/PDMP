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
