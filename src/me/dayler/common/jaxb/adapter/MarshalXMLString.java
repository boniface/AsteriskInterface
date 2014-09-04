/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dayler.common.jaxb.adapter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import me.dayler.common.util.StringUtils;

import java.io.ByteArrayOutputStream;

/**
 * @author clvelarde
 */
public class MarshalXMLString {

    public static String getXMLString(Class contextClass, Object instanceClass) throws JAXBException {
        String xmlToString = StringUtils.EMPTY;

        if (instanceClass != null) {
            JAXBContext context = JAXBContext.newInstance(contextClass);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            ByteArrayOutputStream outByteArray = new ByteArrayOutputStream();
            marshaller.marshal(instanceClass, outByteArray);
            xmlToString = new String(outByteArray.toByteArray());
        }

        return xmlToString;
    }
}
