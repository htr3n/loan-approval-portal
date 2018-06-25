
package org.w3._2001.xmlschema;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter3
    extends XmlAdapter<String, Integer>
{


    public Integer unmarshal(String value) {
        return ((int)javax.xml.bind.DatatypeConverter.parseLong(value));
    }

    public String marshal(Integer value) {
        if (value == null) {
            return null;
        }
        return (javax.xml.bind.DatatypeConverter.printLong((long)(int)value));
    }

}
