package com.westbank.helper;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DateHelper {

	static final Logger log = LoggerFactory.getLogger(DateHelper.class);

	/**
	 * Convert a java.util.Date object into an XMLGregorianCalendar object
	 * 
	 * @param date
	 * @return
	 */
	public static XMLGregorianCalendar convert(Date date) {
		if (date != null) {
			final GregorianCalendar gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.setTime(date);
			return convert(gregorianCalendar);
		}
		return null;
	}

	public static XMLGregorianCalendar convert(GregorianCalendar date) {
		if (date != null) {
			try {
				return DatatypeFactory.newInstance().newXMLGregorianCalendar(date);
			} catch (final DatatypeConfigurationException e) {
				log.error("Cannot convert date '" + date + "': " + e.getMessage());
			}
		}
		return null;
	}

}
