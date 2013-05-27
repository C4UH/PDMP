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

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.PersonType;


/**
 * <p>Java class for PharmacistType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PharmacistType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://niem.gov/niem/niem-core/2.0}PersonType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xml.ijis.org/niem/2.0/extension}PersonPrimaryContactInformation" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://xml.ijis.org/niem/2.0/extension}NPIIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://xml.ijis.org/niem/2.0/extension}StateLicenseIdentifier" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PharmacistType", propOrder = {
    "personPrimaryContactInformation",
    "npiIdentifier",
    "stateLicenseIdentifier"
})
public class PharmacistType
    extends PersonType
{

    @XmlElement(name = "PersonPrimaryContactInformation")
    protected List<ContactInformationType> personPrimaryContactInformation;
    @XmlElement(name = "NPIIdentifier", nillable = true)
    protected List<IdentificationType> npiIdentifier;
    @XmlElement(name = "StateLicenseIdentifier", nillable = true)
    protected List<IdentificationType> stateLicenseIdentifier;

    /**
     * Gets the value of the personPrimaryContactInformation property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the personPrimaryContactInformation property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPersonPrimaryContactInformation().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContactInformationType }
     * 
     * 
     */
    public List<ContactInformationType> getPersonPrimaryContactInformation() {
        if (personPrimaryContactInformation == null) {
            personPrimaryContactInformation = new ArrayList<ContactInformationType>();
        }
        return this.personPrimaryContactInformation;
    }

    /**
     * Gets the value of the npiIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the npiIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNPIIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getNPIIdentifier() {
        if (npiIdentifier == null) {
            npiIdentifier = new ArrayList<IdentificationType>();
        }
        return this.npiIdentifier;
    }

    /**
     * Gets the value of the stateLicenseIdentifier property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stateLicenseIdentifier property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStateLicenseIdentifier().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link IdentificationType }
     * 
     * 
     */
    public List<IdentificationType> getStateLicenseIdentifier() {
        if (stateLicenseIdentifier == null) {
            stateLicenseIdentifier = new ArrayList<IdentificationType>();
        }
        return this.stateLicenseIdentifier;
    }

}
