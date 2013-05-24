//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-558 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.02.04 at 02:02:33 PM IST 
//


package gov.niem.niem.niem_core._2;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;
import gov.niem.niem.fbi._2.DrugMeasurementCodeType;
import gov.niem.niem.fbi._2.SEXCodeType;
import gov.niem.niem.post_canada._2.CanadianProvinceCodeType;
import gov.niem.niem.proxy.xsd._2.Date;
import gov.niem.niem.proxy.xsd._2.String;
import gov.niem.niem.structures._2.ReferenceType;
import gov.niem.niem.usps_states._2.USStateCodeType;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the gov.niem.niem.niem_core._2 package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PersonBirthDate_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonBirthDate");
    private final static QName _FullTelephoneNumber_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "FullTelephoneNumber");
    private final static QName _AddressFullText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressFullText");
    private final static QName _IdentificationJurisdiction_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IdentificationJurisdiction");
    private final static QName _PersonSexCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonSexCode");
    private final static QName _LocationPostalCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationPostalCode");
    private final static QName _StructuredAddress_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StructuredAddress");
    private final static QName _PersonSSNIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonSSNIdentification");
    private final static QName _ContactTelephoneNumber_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactTelephoneNumber");
    private final static QName _RoleOf_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "RoleOf");
    private final static QName _TelephoneNumberRepresentation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneNumberRepresentation");
    private final static QName _ContactMailingAddress_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactMailingAddress");
    private final static QName _SubstanceUnitCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "SubstanceUnitCode");
    private final static QName _Date_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "Date");
    private final static QName _EntityPerson_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EntityPerson");
    private final static QName _PersonName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonName");
    private final static QName _LocationState_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationState");
    private final static QName _EntityRepresentation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EntityRepresentation");
    private final static QName _PersonLicenseIdentification_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonLicenseIdentification");
    private final static QName _IdentificationJurisdictionText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IdentificationJurisdictionText");
    private final static QName _LocationStreet_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationStreet");
    private final static QName _OrganizationName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationName");
    private final static QName _OrganizationLocation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationLocation");
    private final static QName _LocationPostalExtensionCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationPostalExtensionCode");
    private final static QName _LocationStateUSPostalServiceCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationStateUSPostalServiceCode");
    private final static QName _PersonFullName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonFullName");
    private final static QName _AddressDeliveryPoint_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressDeliveryPoint");
    private final static QName _LocationStateCanadianProvinceCode_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationStateCanadianProvinceCode");
    private final static QName _PersonGivenName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonGivenName");
    private final static QName _StreetFullText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "StreetFullText");
    private final static QName _EntityOrganization_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "EntityOrganization");
    private final static QName _ContactEntity_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactEntity");
    private final static QName _TelephoneNumberFullID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "TelephoneNumberFullID");
    private final static QName _LocationCityName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationCityName");
    private final static QName _PersonNamePrefixText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonNamePrefixText");
    private final static QName _ContactMeans_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "ContactMeans");
    private final static QName _OrganizationPrimaryContactInformation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationPrimaryContactInformation");
    private final static QName _RoleOfOrganizationReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "RoleOfOrganizationReference");
    private final static QName _RoleOfPersonReference_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "RoleOfPersonReference");
    private final static QName _DateRepresentation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "DateRepresentation");
    private final static QName _IdentificationID_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "IdentificationID");
    private final static QName _PersonSex_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonSex");
    private final static QName _PersonMiddleName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonMiddleName");
    private final static QName _LocationAddress_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "LocationAddress");
    private final static QName _PersonNameSuffixText_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonNameSuffixText");
    private final static QName _OrganizationDoingBusinessAsName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "OrganizationDoingBusinessAsName");
    private final static QName _PersonSurName_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "PersonSurName");
    private final static QName _AddressRepresentation_QNAME = new QName("http://niem.gov/niem/niem-core/2.0", "AddressRepresentation");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: gov.niem.niem.niem_core._2
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link FullTelephoneNumberType }
     * 
     */
    public FullTelephoneNumberType createFullTelephoneNumberType() {
        return new FullTelephoneNumberType();
    }

    /**
     * Create an instance of {@link EntityType }
     * 
     */
    public EntityType createEntityType() {
        return new EntityType();
    }

    /**
     * Create an instance of {@link TextType }
     * 
     */
    public TextType createTextType() {
        return new TextType();
    }

    /**
     * Create an instance of {@link DateType }
     * 
     */
    public DateType createDateType() {
        return new DateType();
    }

    /**
     * Create an instance of {@link PersonNameTextType }
     * 
     */
    public PersonNameTextType createPersonNameTextType() {
        return new PersonNameTextType();
    }

    /**
     * Create an instance of {@link TelephoneNumberType }
     * 
     */
    public TelephoneNumberType createTelephoneNumberType() {
        return new TelephoneNumberType();
    }

    /**
     * Create an instance of {@link SubstanceMeasureType }
     * 
     */
    public SubstanceMeasureType createSubstanceMeasureType() {
        return new SubstanceMeasureType();
    }

    /**
     * Create an instance of {@link ContactInformationType }
     * 
     */
    public ContactInformationType createContactInformationType() {
        return new ContactInformationType();
    }

    /**
     * Create an instance of {@link MeasureType }
     * 
     */
    public MeasureType createMeasureType() {
        return new MeasureType();
    }

    /**
     * Create an instance of {@link LocationType }
     * 
     */
    public LocationType createLocationType() {
        return new LocationType();
    }

    /**
     * Create an instance of {@link DocumentType }
     * 
     */
    public DocumentType createDocumentType() {
        return new DocumentType();
    }

    /**
     * Create an instance of {@link ProperNameTextType }
     * 
     */
    public ProperNameTextType createProperNameTextType() {
        return new ProperNameTextType();
    }

    /**
     * Create an instance of {@link OrganizationType }
     * 
     */
    public OrganizationType createOrganizationType() {
        return new OrganizationType();
    }

    /**
     * Create an instance of {@link PersonNameType }
     * 
     */
    public PersonNameType createPersonNameType() {
        return new PersonNameType();
    }

    /**
     * Create an instance of {@link AddressType }
     * 
     */
    public AddressType createAddressType() {
        return new AddressType();
    }

    /**
     * Create an instance of {@link PersonType }
     * 
     */
    public PersonType createPersonType() {
        return new PersonType();
    }

    /**
     * Create an instance of {@link IdentificationType }
     * 
     */
    public IdentificationType createIdentificationType() {
        return new IdentificationType();
    }

    /**
     * Create an instance of {@link StreetType }
     * 
     */
    public StreetType createStreetType() {
        return new StreetType();
    }

    /**
     * Create an instance of {@link StructuredAddressType }
     * 
     */
    public StructuredAddressType createStructuredAddressType() {
        return new StructuredAddressType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DateType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonBirthDate")
    public JAXBElement<DateType> createPersonBirthDate(DateType value) {
        return new JAXBElement<DateType>(_PersonBirthDate_QNAME, DateType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link FullTelephoneNumberType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "FullTelephoneNumber", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "TelephoneNumberRepresentation")
    public JAXBElement<FullTelephoneNumberType> createFullTelephoneNumber(FullTelephoneNumberType value) {
        return new JAXBElement<FullTelephoneNumberType>(_FullTelephoneNumber_QNAME, FullTelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressFullText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressRepresentation")
    public JAXBElement<TextType> createAddressFullText(TextType value) {
        return new JAXBElement<TextType>(_AddressFullText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IdentificationJurisdiction")
    public JAXBElement<Object> createIdentificationJurisdiction(Object value) {
        return new JAXBElement<Object>(_IdentificationJurisdiction_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SEXCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonSexCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "PersonSex")
    public JAXBElement<SEXCodeType> createPersonSexCode(SEXCodeType value) {
        return new JAXBElement<SEXCodeType>(_PersonSexCode_QNAME, SEXCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationPostalCode")
    public JAXBElement<String> createLocationPostalCode(String value) {
        return new JAXBElement<String>(_LocationPostalCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StructuredAddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StructuredAddress", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressRepresentation")
    public JAXBElement<StructuredAddressType> createStructuredAddress(StructuredAddressType value) {
        return new JAXBElement<StructuredAddressType>(_StructuredAddress_QNAME, StructuredAddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonSSNIdentification")
    public JAXBElement<IdentificationType> createPersonSSNIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonSSNIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TelephoneNumberType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactTelephoneNumber", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ContactMeans")
    public JAXBElement<TelephoneNumberType> createContactTelephoneNumber(TelephoneNumberType value) {
        return new JAXBElement<TelephoneNumberType>(_ContactTelephoneNumber_QNAME, TelephoneNumberType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "RoleOf")
    public JAXBElement<Object> createRoleOf(Object value) {
        return new JAXBElement<Object>(_RoleOf_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneNumberRepresentation")
    public JAXBElement<Object> createTelephoneNumberRepresentation(Object value) {
        return new JAXBElement<Object>(_TelephoneNumberRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactMailingAddress", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "ContactMeans")
    public JAXBElement<AddressType> createContactMailingAddress(AddressType value) {
        return new JAXBElement<AddressType>(_ContactMailingAddress_QNAME, AddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DrugMeasurementCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "SubstanceUnitCode")
    public JAXBElement<DrugMeasurementCodeType> createSubstanceUnitCode(DrugMeasurementCodeType value) {
        return new JAXBElement<DrugMeasurementCodeType>(_SubstanceUnitCode_QNAME, DrugMeasurementCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Date }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "Date", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "DateRepresentation")
    public JAXBElement<Date> createDate(Date value) {
        return new JAXBElement<Date>(_Date_QNAME, Date.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EntityPerson", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<PersonType> createEntityPerson(PersonType value) {
        return new JAXBElement<PersonType>(_EntityPerson_QNAME, PersonType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonName")
    public JAXBElement<PersonNameType> createPersonName(PersonNameType value) {
        return new JAXBElement<PersonNameType>(_PersonName_QNAME, PersonNameType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationState")
    public JAXBElement<Object> createLocationState(Object value) {
        return new JAXBElement<Object>(_LocationState_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EntityRepresentation")
    public JAXBElement<Object> createEntityRepresentation(Object value) {
        return new JAXBElement<Object>(_EntityRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IdentificationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonLicenseIdentification")
    public JAXBElement<IdentificationType> createPersonLicenseIdentification(IdentificationType value) {
        return new JAXBElement<IdentificationType>(_PersonLicenseIdentification_QNAME, IdentificationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IdentificationJurisdictionText", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "IdentificationJurisdiction")
    public JAXBElement<TextType> createIdentificationJurisdictionText(TextType value) {
        return new JAXBElement<TextType>(_IdentificationJurisdictionText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link StreetType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationStreet", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "AddressDeliveryPoint")
    public JAXBElement<StreetType> createLocationStreet(StreetType value) {
        return new JAXBElement<StreetType>(_LocationStreet_QNAME, StreetType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationName")
    public JAXBElement<TextType> createOrganizationName(TextType value) {
        return new JAXBElement<TextType>(_OrganizationName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link LocationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationLocation")
    public JAXBElement<LocationType> createOrganizationLocation(LocationType value) {
        return new JAXBElement<LocationType>(_OrganizationLocation_QNAME, LocationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationPostalExtensionCode")
    public JAXBElement<String> createLocationPostalExtensionCode(String value) {
        return new JAXBElement<String>(_LocationPostalExtensionCode_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link USStateCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationStateUSPostalServiceCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "LocationState")
    public JAXBElement<USStateCodeType> createLocationStateUSPostalServiceCode(USStateCodeType value) {
        return new JAXBElement<USStateCodeType>(_LocationStateUSPostalServiceCode_QNAME, USStateCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonFullName")
    public JAXBElement<PersonNameTextType> createPersonFullName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonFullName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressDeliveryPoint")
    public JAXBElement<Object> createAddressDeliveryPoint(Object value) {
        return new JAXBElement<Object>(_AddressDeliveryPoint_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link CanadianProvinceCodeType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationStateCanadianProvinceCode", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "LocationState")
    public JAXBElement<CanadianProvinceCodeType> createLocationStateCanadianProvinceCode(CanadianProvinceCodeType value) {
        return new JAXBElement<CanadianProvinceCodeType>(_LocationStateCanadianProvinceCode_QNAME, CanadianProvinceCodeType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonGivenName")
    public JAXBElement<PersonNameTextType> createPersonGivenName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonGivenName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "StreetFullText")
    public JAXBElement<TextType> createStreetFullText(TextType value) {
        return new JAXBElement<TextType>(_StreetFullText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link OrganizationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "EntityOrganization", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "EntityRepresentation")
    public JAXBElement<OrganizationType> createEntityOrganization(OrganizationType value) {
        return new JAXBElement<OrganizationType>(_EntityOrganization_QNAME, OrganizationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EntityType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactEntity")
    public JAXBElement<EntityType> createContactEntity(EntityType value) {
        return new JAXBElement<EntityType>(_ContactEntity_QNAME, EntityType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "TelephoneNumberFullID")
    public JAXBElement<String> createTelephoneNumberFullID(String value) {
        return new JAXBElement<String>(_TelephoneNumberFullID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProperNameTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationCityName")
    public JAXBElement<ProperNameTextType> createLocationCityName(ProperNameTextType value) {
        return new JAXBElement<ProperNameTextType>(_LocationCityName_QNAME, ProperNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonNamePrefixText")
    public JAXBElement<TextType> createPersonNamePrefixText(TextType value) {
        return new JAXBElement<TextType>(_PersonNamePrefixText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "ContactMeans")
    public JAXBElement<Object> createContactMeans(Object value) {
        return new JAXBElement<Object>(_ContactMeans_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ContactInformationType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationPrimaryContactInformation")
    public JAXBElement<ContactInformationType> createOrganizationPrimaryContactInformation(ContactInformationType value) {
        return new JAXBElement<ContactInformationType>(_OrganizationPrimaryContactInformation_QNAME, ContactInformationType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "RoleOfOrganizationReference", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "RoleOf")
    public JAXBElement<ReferenceType> createRoleOfOrganizationReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_RoleOfOrganizationReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReferenceType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "RoleOfPersonReference", substitutionHeadNamespace = "http://niem.gov/niem/niem-core/2.0", substitutionHeadName = "RoleOf")
    public JAXBElement<ReferenceType> createRoleOfPersonReference(ReferenceType value) {
        return new JAXBElement<ReferenceType>(_RoleOfPersonReference_QNAME, ReferenceType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "DateRepresentation")
    public JAXBElement<Object> createDateRepresentation(Object value) {
        return new JAXBElement<Object>(_DateRepresentation_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "IdentificationID")
    public JAXBElement<String> createIdentificationID(String value) {
        return new JAXBElement<String>(_IdentificationID_QNAME, String.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonSex")
    public JAXBElement<Object> createPersonSex(Object value) {
        return new JAXBElement<Object>(_PersonSex_QNAME, Object.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonMiddleName")
    public JAXBElement<PersonNameTextType> createPersonMiddleName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonMiddleName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddressType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "LocationAddress")
    public JAXBElement<AddressType> createLocationAddress(AddressType value) {
        return new JAXBElement<AddressType>(_LocationAddress_QNAME, AddressType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonNameSuffixText")
    public JAXBElement<TextType> createPersonNameSuffixText(TextType value) {
        return new JAXBElement<TextType>(_PersonNameSuffixText_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "OrganizationDoingBusinessAsName")
    public JAXBElement<TextType> createOrganizationDoingBusinessAsName(TextType value) {
        return new JAXBElement<TextType>(_OrganizationDoingBusinessAsName_QNAME, TextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PersonNameTextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "PersonSurName")
    public JAXBElement<PersonNameTextType> createPersonSurName(PersonNameTextType value) {
        return new JAXBElement<PersonNameTextType>(_PersonSurName_QNAME, PersonNameTextType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Object }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://niem.gov/niem/niem-core/2.0", name = "AddressRepresentation")
    public JAXBElement<Object> createAddressRepresentation(Object value) {
        return new JAXBElement<Object>(_AddressRepresentation_QNAME, Object.class, null, value);
    }

}
