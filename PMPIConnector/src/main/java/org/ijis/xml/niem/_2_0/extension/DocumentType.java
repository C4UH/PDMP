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


//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.04 at 02:02:33 PM IST 
//


package org.ijis.xml.niem._2_0.extension;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocumentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocumentType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}DocumentType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xml.ijis.org/niem/2.0/extension}PMPDocumentAugmentation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocumentType", propOrder = {
    "pmpDocumentAugmentation"
})
@XmlSeeAlso({
    PharmacyReportingPrescriptionReportType.class,
    RequestResponsePrescriptionReportType.class
})
public class DocumentType
    extends gov.niem.niem.niem_core._2.DocumentType
{

    @XmlElement(name = "PMPDocumentAugmentation")
    protected PMPDocumentAugmentationType pmpDocumentAugmentation;

    /**
     * Gets the value of the pmpDocumentAugmentation property.
     * 
     * @return
     *     possible object is
     *     {@link PMPDocumentAugmentationType }
     *     
     */
    public PMPDocumentAugmentationType getPMPDocumentAugmentation() {
        return pmpDocumentAugmentation;
    }

    /**
     * Sets the value of the pmpDocumentAugmentation property.
     * 
     * @param value
     *     allowed object is
     *     {@link PMPDocumentAugmentationType }
     *     
     */
    public void setPMPDocumentAugmentation(PMPDocumentAugmentationType value) {
        this.pmpDocumentAugmentation = value;
    }

}
