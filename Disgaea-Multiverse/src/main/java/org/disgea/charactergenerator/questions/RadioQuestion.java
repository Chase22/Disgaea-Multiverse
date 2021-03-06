package org.disgea.charactergenerator.questions;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.javatuples.Pair;

public class RadioQuestion<T> extends Question<Option<T>> {

	private List<Pair<Option<T>, JRadioButton>> options = new ArrayList<>();

	public RadioQuestion(String question) {
		super(question);
	}
	
	@Override
	public JPanel generateQuestionPanel() {
		JPanel panel = new JPanel();
		ButtonGroup group = new ButtonGroup();

		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.setAlignmentX(Component.LEFT_ALIGNMENT);
		
		panel.add(new JLabel(question));
		
		for (Pair<Option<T>, JRadioButton> op : options) {
			group.add(op.getValue1());
			panel.add(op.getValue1());
		}
		

		return panel;
	}

	@Override
	public void submit() {
		for (Pair<Option<T>, JRadioButton> op : options) {
			if (op.getValue1().isSelected()) {
				answer = op.getValue0();
				break;
			}

		}
	}

	@Override
	public Option<T> getAnswer() {
		return answer;
	}

	public void add(Option<T> option) {
		options.add(new Pair<Option<T>, JRadioButton>(option, new JRadioButton(option.getOptionText())));
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

}
