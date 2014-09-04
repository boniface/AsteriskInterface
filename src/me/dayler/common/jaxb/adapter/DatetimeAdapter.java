/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package me.dayler.common.jaxb.adapter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import me.dayler.common.util.date.DateFormatter;

import java.util.Date;

/**
 * Generic date format adapter.
 *
 * @author asalazar
 */
public class DatetimeAdapter extends XmlAdapter<String, Date> {

    /**
     * {@inheritDoc}
     */
    @Override
    public Date unmarshal(String value) throws Exception {
        return DateFormatter.ALL.parse(value);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String marshal(Date value) throws Exception {
        return DateFormatter.LONG.format(value);
    }

}
