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


package gov.niem.niem.niem_core._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.post_canada._2.CanadianProvinceCodeType;
import gov.niem.niem.proxy.xsd._2.String;
import gov.niem.niem.structures._2.ComplexObjectType;
import gov.niem.niem.usps_states._2.USStateCodeType;


/**
 * <p>Java class for StructuredAddressType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="StructuredAddressType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType">
 *       &lt;sequence>
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}AddressDeliveryPoint" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}LocationCityName" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}LocationState" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}LocationPostalCode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://niem.gov/niem/niem-core/2.0}LocationPostalExtensionCode" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StructuredAddressType", propOrder = {
    "addressDeliveryPoint",
    "locationCityName",
    "locationState",
    "locationPostalCode",
    "locationPostalExtensionCode"
})
public class StructuredAddressType
    extends ComplexObjectType
{

    @XmlElementRef(name = "AddressDeliveryPoint", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class)
    protected List<JAXBElement<?>> addressDeliveryPoint;
    @XmlElement(name = "LocationCityName", nillable = true)
    protected List<ProperNameTextType> locationCityName;
    @XmlElementRef(name = "LocationState", namespace = "http://niem.gov/niem/niem-core/2.0", type = JAXBElement.class)
    protected List<JAXBElement<?>> locationState;
    @XmlElement(name = "LocationPostalCode", nillable = true)
    protected List<String> locationPostalCode;
    @XmlElement(name = "LocationPostalExtensionCode", nillable = true)
    protected List<String> locationPostalExtensionCode;

    /**
     * Gets the value of the addressDeliveryPoint property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressDeliveryPoint property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressDeliveryPoint().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link StreetType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getAddressDeliveryPoint() {
        if (addressDeliveryPoint == null) {
            addressDeliveryPoint = new ArrayList<JAXBElement<?>>();
        }
        return this.addressDeliveryPoint;
    }

    /**
     * Gets the value of the locationCityName property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locationCityName property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocationCityName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProperNameTextType }
     * 
     * 
     */
    public List<ProperNameTextType> getLocationCityName() {
        if (locationCityName == null) {
            locationCityName = new ArrayList<ProperNameTextType>();
        }
        return this.locationCityName;
    }

    /**
     * Gets the value of the locationState property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locationState property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocationState().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link CanadianProvinceCodeType }{@code >}
     * {@link JAXBElement }{@code <}{@link Object }{@code >}
     * {@link JAXBElement }{@code <}{@link USStateCodeType }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getLocationState() {
        if (locationState == null) {
            locationState = new ArrayList<JAXBElement<?>>();
        }
        return this.locationState;
    }

    /**
     * Gets the value of the locationPostalCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locationPostalCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocationPostalCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLocationPostalCode() {
        if (locationPostalCode == null) {
            locationPostalCode = new ArrayList<String>();
        }
        return this.locationPostalCode;
    }

    /**
     * Gets the value of the locationPostalExtensionCode property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the locationPostalExtensionCode property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLocationPostalExtensionCode().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLocationPostalExtensionCode() {
        if (locationPostalExtensionCode == null) {
            locationPostalExtensionCode = new ArrayList<String>();
        }
        return this.locationPostalExtensionCode;
    }

}
