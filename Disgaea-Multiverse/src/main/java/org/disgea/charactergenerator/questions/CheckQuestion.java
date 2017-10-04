package org.disgea.charactergenerator.questions;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.javatuples.Pair;

public class CheckQuestion<T> extends Question<List<Option<T>>> implements ChangeListener{

	private List<Pair<Option<T>, JCheckBox>> options = new ArrayList<>();
	
	private int maxSelected;

	public CheckQuestion(String question, int maxSelected) {
		super(question);
		this.maxSelected = maxSelected;
	}
	
	@Override
	public JPanel generateQuestionPanel() {
		JPanel panel = new JPanel();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		panel.add(new JLabel(question));
		
		for (Pair<Option<T>, JCheckBox> op : options) {
			panel.add(op.getValue1());
			op.getValue1().addChangeListener(this);
		}

		return panel;
	}

	@Override
	public void submit() {
		answer = new ArrayList<>();
		for (Pair<Option<T>, JCheckBox> op : options) {
			if (op.getValue1().isSelected()) {
				answer.add(op.getValue0());
			}

		}
	}

	@Override
	public List<Option<T>> getAnswer() {
		return answer;
	}

	public void add(Option<T> option) {
		options.add(new Pair<Option<T>, JCheckBox>(option, new JCheckBox(option.getOptionText())));
	}

	public void remove(Option<String> option) {
		Pair remove = null;
		for (Pair p : options) {
			if (p.getValue0() == option) {
				remove = p;
				break;
			}
		}
		if (remove == null)
			return;
		options.remove(remove);
	}

	public void remove(int index) {
		options.remove(index);
	}

	@Override
	public boolean getValid() {
		return true;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int selected = 0;
		for (Pair<Option<T>, JCheckBox> op : options) {
			if (op.getValue1().isSelected()) selected++;
		}
		if (selected >= maxSelected) {
			for (Pair<Option<T>, JCheckBox> op : options) {
				op.getValue1().setEnabled(op.getValue1().isSelected());
			}
		} else {
			for (Pair<Option<T>, JCheckBox> op : options) {
				op.getValue1().setEnabled(true);
			}
		}
	}

}
