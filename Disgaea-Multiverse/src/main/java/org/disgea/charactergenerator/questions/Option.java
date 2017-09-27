package org.disgea.charactergenerator.questions;

public class Option<T> {
	private String OptionText;
	private T value;
	
	/**
	 * @param optionText
	 * @param value
	 */
	public Option(String optionText, T value) {
		super();
		OptionText = optionText;
		this.value = value;
	}
	public String getOptionText() {
		return OptionText;
	}
	public void setOptionText(String optionText) {
		OptionText = optionText;
	}
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	
	
}
