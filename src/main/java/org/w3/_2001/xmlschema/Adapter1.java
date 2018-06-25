
package org.w3._2001.xmlschema;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Double>
{


    public Double unmarshal(String value) {
        return ((double)javax.xml.bind.DatatypeConverter.parseFloat(value));
    }

    public String marshal(Double value) {
        if (value == null) {
            return null;
        }
        return (javax.xml.bind.DatatypeConverter.printFloat((float)(double)value));
    }

}
