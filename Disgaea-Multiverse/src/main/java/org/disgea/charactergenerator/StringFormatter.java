package org.disgea.charactergenerator;

import java.text.ParseException;

import javax.swing.JFormattedTextField.AbstractFormatter;

public class StringFormatter extends AbstractFormatter {
	
	private String format;

	/**
	 * @param format
	 */
	public StringFormatter(String format) {
		super();
		this.format = format;
	}

	@Override
	public Object stringToValue(String text) throws ParseException {
		return null;
	}

	@Override
	public String valueToString(Object value) throws ParseException {
		return String.format(format, value);
	}

	/**
	 * @return the format
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * @param format the format to set
	 */
	public void setFormat(String format) {
		this.format = format;
	}
	
	

}
