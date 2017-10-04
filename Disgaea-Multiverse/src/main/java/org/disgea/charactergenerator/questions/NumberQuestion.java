package org.disgea.charactergenerator.questions;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.text.DefaultFormatterFactory;

public class NumberQuestion extends Question<Integer> {

	SpinnerNumberModel spinnerModel = new SpinnerNumberModel(0, 0, 100, 1);
	JSpinner spinner = new JSpinner(spinnerModel);

	public NumberQuestion(String question) {
		super(question);
		((DefaultEditor) spinner.getEditor()).getTextField().setEditable(false);
	}
	
	@Override
	public JPanel generateQuestionPanel() {
		JPanel panel = new JPanel();
		panel.add(spinner);

		return panel;
	}

	@Override
	public void submit() {
		answer = (Integer) spinner.getValue();
	}

	@Override
	public Integer getAnswer() {
		return answer;
	}
	
	public void setStep(int step) {
		spinnerModel.setStepSize(step);
	}

	public void setMax(int max) {
		spinnerModel.setMaximum(max);
	}

	public void setMin(int min) {
		spinnerModel.setMinimum(min);
	}
	
	public void setValue(int value) {
		spinner.setValue(value);
	}
	
	public void addChangeListener(ChangeListener listener) {
		spinner.addChangeListener(listener);
	}
	
	public void removeChangeListener(ChangeListener listener) {
		spinner.removeChangeListener(listener);
	}

	@Override
	public boolean getValid() {
		return true;
	}
	
	public void setFormatter(AbstractFormatter formatter) {
		((DefaultEditor) spinner.getEditor()).getTextField().setFormatterFactory(new DefaultFormatterFactory(formatter));
	}

}
