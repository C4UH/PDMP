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

package com.logicoy.pdmp.pmpi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/**
 *
 * @author Vishnu
 */
public class XMLValidator {

    private static final Logger log = Logger.getLogger(XMLValidator.class.getName());

    private String validatResults;

    private Schema schema;

    public XMLValidator(URL schemaLocation){
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        try {
            System.out.println("scchema Location is "+schemaLocation.toURI());
            schema = factory.newSchema(new File(schemaLocation.toURI()));
            //schema = factory.newSchema(new StreamSource)
        } catch (Exception ex) {
            Logger.getLogger(XMLValidator.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    public XMLValidator(InputStream schemaLocation){
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        try {
            
            //schema = factory.newSchema(new File(schemaLocation.toURI()));
            schema = factory.newSchema(new StreamSource(schemaLocation));
        } catch (Exception ex) {
            Logger.getLogger(XMLValidator.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException(ex);
        }
    }
    public String getValidatResults() {
        return validatResults;
    }

    public boolean isXMLValid(Source source){
        try{
            Validator validator = schema.newValidator();
            StringWriter strWriter = new StringWriter();
            StreamResult result = new StreamResult(strWriter);
            validator.validate(source,result);
            this.validatResults = strWriter.toString();
            return true;
        }
        catch (SAXException ex) {
            log.log(Level.SEVERE,ex.getMessage(),ex);
            throw new RuntimeException(ex.getMessage(),ex);
        }catch (IOException ex) {
            log.log(Level.SEVERE,ex.getMessage(),ex);
            throw new RuntimeException(ex.getMessage(),ex);
        }
        
    }
}
