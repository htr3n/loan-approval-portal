package com.westbank.helper;

import java.util.Date;

import org.apache.commons.lang.RandomStringUtils;

public class DbHelper {

	public static final int PIN_LENGTH = 6;

	/**
	 * Converts a java.util.Date input into ANSI SQL DATE format
	 * 
	 * YYYY-MM-DD
	 * 
	 * @param c
	 *            -- the input java.util.Date
	 * @return -- ANSI SQL date format or null
	 */
	public static String convertDate(Date input) {
		final java.sql.Date d = new java.sql.Date(input.getTime());
		return d.toString();
	}

	public static String generatePassword(int length) {
		final String tmp = "qwertzuiopasdfghjklyxcvbnmQWERTZUIOPASDFGHJKLYXCVBNM1234567890";
		return RandomStringUtils.random(length, tmp);
	}

	public static String generateString(int length) {
		final String tmp = "qwertzuiopasdfghjklyxcvbnmQWERTZUIOPASDFGHJKLYXCVBNM1234567890!$%&/()=?#+~*-.,<>@";
		return RandomStringUtils.random(length, tmp);
	}

}
