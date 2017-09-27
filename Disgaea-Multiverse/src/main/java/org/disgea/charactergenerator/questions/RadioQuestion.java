package org.disgea.charactergenerator.questions;

import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.javatuples.Pair;

public class RadioQuestion extends Question<Option<String>> {
	private List<Pair<Option<String>, JRadioButton>> options = new ArrayList<>();

	@Override
	public JPanel generateQuestionPanel() {
		JPanel panel = new JPanel();
		ButtonGroup group = new ButtonGroup();

		for (Pair<Option<String>, JRadioButton> op : options) {
			group.add(op.getValue1());
			panel.add(op.getValue1());
		}
		

		return panel;
	}

	@Override
	public void submit() {
		for (Pair<Option<String>, JRadioButton> op : options) {
			if (op.getValue1().isSelected()) {
				answer = op.getValue0();
				break;
			}

		}
	}

	@Override
	public Option<String> getAnswer() {
		return answer;
	}

	public void add(Option<String> option) {
		options.add(new Pair<Option<String>, JRadioButton>(option, new JRadioButton(option.getOptionText())));
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
