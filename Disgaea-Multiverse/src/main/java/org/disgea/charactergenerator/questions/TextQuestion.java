package org.disgea.charactergenerator.questions;

import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextQuestion extends Question<String> {
	private JTextField field = new JTextField();
	private int maxLength = field.getColumns();
	
	public TextQuestion(String question) {
		super(question);
	}
	
	public TextQuestion(String question, int maxLength) {
		super(question);
		this.maxLength = maxLength;
	}
	
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
		panel.setLayout(new FlowLayout());
		
		panel.add(new JLabel(question));
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
