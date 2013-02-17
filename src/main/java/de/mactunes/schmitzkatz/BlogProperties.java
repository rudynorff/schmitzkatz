package de.mactunes.schmitzkatz;

import java.util.Properties;



public class BlogProperties extends Properties {

	private static final String		VALUE_TRUE = "true",
									VALUE_FALSE = "false";



	private boolean getBooleanValueForString(String string) {
		if (null == string) {
			return false;
		}

		return (VALUE_TRUE.equals(string)) ? true : false;
	}

	private int getIntFromString(String string) {
		int parsed = 0;

		try {
			parsed = Integer.parseInt(string);
		} catch (NumberFormatException nfe) {}

		return parsed;
	}
}













