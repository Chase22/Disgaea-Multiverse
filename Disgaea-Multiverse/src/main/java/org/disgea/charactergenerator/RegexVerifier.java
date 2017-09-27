package org.disgea.charactergenerator;

import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class RegexVerifier extends InputVerifier {

	private String regex;
	
	public RegexVerifier(String regex) {
		this.regex = regex;
	}
	
	@Override
	public boolean verify(JComponent input) {
		return ( (JTextField) input).getText().matches(regex);
	}

}
