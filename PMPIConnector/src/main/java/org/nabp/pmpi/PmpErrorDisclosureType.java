//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.04 at 02:02:33 PM IST 
//


package org.nabp.pmpi;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for PmpErrorDisclosureType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="PmpErrorDisclosureType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Type" type="{http://pmpi.nabp.org/}DisclosureResponseTypeEnumeration"/>
 *         &lt;element name="InterconnectSearchId" type="{http://pmpi.nabp.org/}InterconnectSearchIdType" minOccurs="0"/>
 *         &lt;element name="InterconnectDisclosureId" type="{http://pmpi.nabp.org/}InterconnectDisclosureIdType" minOccurs="0"/>
 *         &lt;element name="SearchingPmp" type="{http://pmpi.nabp.org/}SearchingPmpOptionalType" minOccurs="0"/>
 *         &lt;element name="DisclosingPmp" type="{http://pmpi.nabp.org/}DisclosingPmpOptionalType" minOccurs="0"/>
 *         &lt;element name="PlaintextData" type="{http://pmpi.nabp.org/}PlaintextDataType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "PmpErrorDisclosureType", propOrder = {
    "type",
    "interconnectSearchId",
    "interconnectDisclosureId",
    "searchingPmp",
    "disclosingPmp",
    "plaintextData"
})
public class PmpErrorDisclosureType {

    @XmlElement(name = "Type", required = true)
    protected DisclosureResponseTypeEnumeration type;
    @XmlElement(name = "InterconnectSearchId")
    protected BigInteger interconnectSearchId;
    @XmlElement(name = "InterconnectDisclosureId")
    protected BigInteger interconnectDisclosureId;
    @XmlElement(name = "SearchingPmp")
    protected SearchingPmpOptionalType searchingPmp;
    @XmlElement(name = "DisclosingPmp")
    protected DisclosingPmpOptionalType disclosingPmp;
    @XmlElement(name = "PlaintextData")
    protected String plaintextData;

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link DisclosureResponseTypeEnumeration }
     *     
     */
    public DisclosureResponseTypeEnumeration getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisclosureResponseTypeEnumeration }
     *     
     */
    public void setType(DisclosureResponseTypeEnumeration value) {
        this.type = value;
    }

    /**
     * Gets the value of the interconnectSearchId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInterconnectSearchId() {
        return interconnectSearchId;
    }

    /**
     * Sets the value of the interconnectSearchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInterconnectSearchId(BigInteger value) {
        this.interconnectSearchId = value;
    }

    /**
     * Gets the value of the interconnectDisclosureId property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInterconnectDisclosureId() {
        return interconnectDisclosureId;
    }

    /**
     * Sets the value of the interconnectDisclosureId property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInterconnectDisclosureId(BigInteger value) {
        this.interconnectDisclosureId = value;
    }

    /**
     * Gets the value of the searchingPmp property.
     * 
     * @return
     *     possible object is
     *     {@link SearchingPmpOptionalType }
     *     
     */
    public SearchingPmpOptionalType getSearchingPmp() {
        return searchingPmp;
    }

    /**
     * Sets the value of the searchingPmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchingPmpOptionalType }
     *     
     */
    public void setSearchingPmp(SearchingPmpOptionalType value) {
        this.searchingPmp = value;
    }

    /**
     * Gets the value of the disclosingPmp property.
     * 
     * @return
     *     possible object is
     *     {@link DisclosingPmpOptionalType }
     *     
     */
    public DisclosingPmpOptionalType getDisclosingPmp() {
        return disclosingPmp;
    }

    /**
     * Sets the value of the disclosingPmp property.
     * 
     * @param value
     *     allowed object is
     *     {@link DisclosingPmpOptionalType }
     *     
     */
    public void setDisclosingPmp(DisclosingPmpOptionalType value) {
        this.disclosingPmp = value;
    }

    /**
     * Gets the value of the plaintextData property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlaintextData() {
        return plaintextData;
    }

    /**
     * Sets the value of the plaintextData property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlaintextData(String value) {
        this.plaintextData = value;
    }

}
