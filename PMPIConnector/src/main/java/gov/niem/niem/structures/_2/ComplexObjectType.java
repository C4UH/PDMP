//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.04 at 02:02:33 PM IST 
//


package gov.niem.niem.structures._2;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import gov.niem.niem.niem_core._2.AddressType;
import gov.niem.niem.niem_core._2.ContactInformationType;
import gov.niem.niem.niem_core._2.DateType;
import gov.niem.niem.niem_core._2.DocumentType;
import gov.niem.niem.niem_core._2.EntityType;
import gov.niem.niem.niem_core._2.FullTelephoneNumberType;
import gov.niem.niem.niem_core._2.IdentificationType;
import gov.niem.niem.niem_core._2.LocationType;
import gov.niem.niem.niem_core._2.MeasureType;
import gov.niem.niem.niem_core._2.OrganizationType;
import gov.niem.niem.niem_core._2.PersonNameType;
import gov.niem.niem.niem_core._2.PersonType;
import gov.niem.niem.niem_core._2.StreetType;
import gov.niem.niem.niem_core._2.StructuredAddressType;
import gov.niem.niem.niem_core._2.TelephoneNumberType;
import org.ijis.xml.niem._2.PMPRequestType;
import org.ijis.xml.niem._2_0.extension.CompoundDrugIngredientType;
import org.ijis.xml.niem._2_0.extension.PrescriptionDrugType;
import org.ijis.xml.niem._2_0.extension.PrescriptionType;
import org.ijis.xml.niem._2_0.extension.ReportDateRangeType;
import org.ijis.xml.niem._2_0.extension.RequestPrescriptionDateRangeType;


/**
 * The ComplexObjectType type provides a base class
 *       for object definition, association definitions, and external adapter
 *       type definitions. An instance of one of these types may have an ID.
 *       It may have metadata as it establishes the existence of an object
 *       (maybe a conceptual object). It may also have link metadata, as an
 *       element of one of these types establishes a relationship between its
 *       value and its context.
 * 
 * <p>Java class for ComplexObjectType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ComplexObjectType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute ref="{http://niem.gov/niem/structures/2.0}id"/>
 *       &lt;attribute ref="{http://niem.gov/niem/structures/2.0}metadata"/>
 *       &lt;attribute ref="{http://niem.gov/niem/structures/2.0}linkMetadata"/>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ComplexObjectType")
@XmlSeeAlso({
    PersonNameType.class,
    EntityType.class,
    FullTelephoneNumberType.class,
    DateType.class,
    ContactInformationType.class,
    TelephoneNumberType.class,
    IdentificationType.class,
    LocationType.class,
    AddressType.class,
    StreetType.class,
    StructuredAddressType.class,
    MeasureType.class,
    PMPRequestType.class,
    OrganizationType.class,
    RequestPrescriptionDateRangeType.class,
    PrescriptionDrugType.class,
    DocumentType.class,
    PersonType.class,
    PrescriptionType.class,
    ReportDateRangeType.class,
    CompoundDrugIngredientType.class
})
public abstract class ComplexObjectType {

    @XmlAttribute(namespace = "http://niem.gov/niem/structures/2.0")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    protected String id;
    @XmlAttribute(namespace = "http://niem.gov/niem/structures/2.0")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> metadata;
    @XmlAttribute(namespace = "http://niem.gov/niem/structures/2.0")
    @XmlIDREF
    @XmlSchemaType(name = "IDREFS")
    protected List<Object> linkMetadata;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the metadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the metadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getMetadata() {
        if (metadata == null) {
            metadata = new ArrayList<Object>();
        }
        return this.metadata;
    }

    /**
     * Gets the value of the linkMetadata property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the linkMetadata property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLinkMetadata().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Object }
     * 
     * 
     */
    public List<Object> getLinkMetadata() {
        if (linkMetadata == null) {
            linkMetadata = new ArrayList<Object>();
        }
        return this.linkMetadata;
    }

}
