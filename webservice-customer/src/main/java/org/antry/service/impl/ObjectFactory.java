
package org.antry.service.impl;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.antry.service.impl package. 
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

    private final static QName _ShowUserResponse_QNAME = new QName("http://impl.service.antry.org/", "showUserResponse");
    private final static QName _ShowUser_QNAME = new QName("http://impl.service.antry.org/", "showUser");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.antry.service.impl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ShowUserResponse }
     * 
     */
    public ShowUserResponse createShowUserResponse() {
        return new ShowUserResponse();
    }

    /**
     * Create an instance of {@link ShowUser }
     * 
     */
    public ShowUser createShowUser() {
        return new ShowUser();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowUserResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.antry.org/", name = "showUserResponse")
    public JAXBElement<ShowUserResponse> createShowUserResponse(ShowUserResponse value) {
        return new JAXBElement<ShowUserResponse>(_ShowUserResponse_QNAME, ShowUserResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ShowUser }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://impl.service.antry.org/", name = "showUser")
    public JAXBElement<ShowUser> createShowUser(ShowUser value) {
        return new JAXBElement<ShowUser>(_ShowUser_QNAME, ShowUser.class, null, value);
    }

}
