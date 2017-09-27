package org.disgea.charactergenerator.questions;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextQuestion extends Question<String> {
	private JTextField field = new JTextField();
	private int maxLength = field.getColumns();
	
	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public String getAnswer() {
		return answer;
	}

	@Override
	public JPanel generateQuestionPanel() {
		field.setColumns(maxLength);
		JPanel panel = new JPanel();
		panel.add(field);
		return panel;
	}

	@Override
	public void submit() {
		answer = field.getText();
	}

	@Override
	public boolean getValid() {
		return true;
	}

}
