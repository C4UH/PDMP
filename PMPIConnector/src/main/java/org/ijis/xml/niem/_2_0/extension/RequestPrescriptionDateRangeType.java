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
import javax.xml.bind.annotation.XmlType;
import gov.niem.niem.proxy.xsd._2.Date;
import gov.niem.niem.structures._2.ComplexObjectType;


/**
 * 
 *         Date range for prescription dispensing being requested
 *       
 * 
 * <p>Java class for RequestPrescriptionDateRangeType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RequestPrescriptionDateRangeType">
 *   &lt;complexContent>
 *     &lt;extension base="{http://niem.gov/niem/structures/2.0}ComplexObjectType">
 *       &lt;sequence>
 *         &lt;element ref="{http://xml.ijis.org/niem/2.0/extension}RequestPrescriptionDateRangeBegin"/>
 *         &lt;element ref="{http://xml.ijis.org/niem/2.0/extension}RequestPrescriptionDateRangeEnd"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RequestPrescriptionDateRangeType", propOrder = {
    "requestPrescriptionDateRangeBegin",
    "requestPrescriptionDateRangeEnd"
})
public class RequestPrescriptionDateRangeType
    extends ComplexObjectType
{

    @XmlElement(name = "RequestPrescriptionDateRangeBegin", required = true, nillable = true)
    protected Date requestPrescriptionDateRangeBegin;
    @XmlElement(name = "RequestPrescriptionDateRangeEnd", required = true, nillable = true)
    protected Date requestPrescriptionDateRangeEnd;

    /**
     * Gets the value of the requestPrescriptionDateRangeBegin property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getRequestPrescriptionDateRangeBegin() {
        return requestPrescriptionDateRangeBegin;
    }

    /**
     * Sets the value of the requestPrescriptionDateRangeBegin property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setRequestPrescriptionDateRangeBegin(Date value) {
        this.requestPrescriptionDateRangeBegin = value;
    }

    /**
     * Gets the value of the requestPrescriptionDateRangeEnd property.
     * 
     * @return
     *     possible object is
     *     {@link Date }
     *     
     */
    public Date getRequestPrescriptionDateRangeEnd() {
        return requestPrescriptionDateRangeEnd;
    }

    /**
     * Sets the value of the requestPrescriptionDateRangeEnd property.
     * 
     * @param value
     *     allowed object is
     *     {@link Date }
     *     
     */
    public void setRequestPrescriptionDateRangeEnd(Date value) {
        this.requestPrescriptionDateRangeEnd = value;
    }

}
