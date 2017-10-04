package org.disgea.charactergenerator.questions;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.javatuples.Pair;
import org.javatuples.Quartet;

public class DistributeQuestion extends Question<List<DistributeQuestion.DistributeOption>> implements ChangeListener {
	
	private int pointsToDistribute;
	private int pointsLeftToDistribute;
	
	List<Pair<DistributeOption, NumberQuestion>> options = new ArrayList<>();
	
	private JLabel PointsLeft = new JLabel();
	final String LABEL_FORMAT = "Points left: %d";
	
	public DistributeQuestion(String questionText, List<DistributeOption> options, int pointToDistribute) {
		super(questionText);
		int pointsUsed = 0;
		for (DistributeOption opt : options) {
			NumberQuestion question = new NumberQuestion(opt.label);
			question.setMin(opt.min);
			question.setMax(opt.max);
			question.setValue(opt.value);
			question.setStep(opt.step);
			question.addChangeListener(this);
			if (opt.format != null) question.setFormatter(opt.format);
			this.options.add(new Pair<DistributeOption, NumberQuestion>(opt, question));
			pointsUsed += opt.value;
		}
		this.pointsToDistribute = pointToDistribute + pointsUsed;
		PointsLeft.setText(String.format(LABEL_FORMAT, pointToDistribute));
	}
	

	@Override
	public JPanel generateQuestionPanel() {
		JPanel panel = new JPanel();
		
		for (Pair<DistributeOption, NumberQuestion> quest : options) {
			panel.add(new JLabel(quest.getValue1().question));
			panel.add(quest.getValue1().generateQuestionPanel());
		}
		panel.add(PointsLeft);
		return panel;
	}

	@Override
	public void submit() {
		answer.clear();
		for (Pair<DistributeOption, NumberQuestion> quest : options) {
			quest.getValue1().submit();
			quest.getValue0().value = quest.getValue1().getAnswer();
			answer.add(quest.getValue0());
		}
	}

	@Override
	public List<DistributeOption> getAnswer() {
		return answer;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int pointsUsed = 0;
		
		for (Pair<DistributeOption, NumberQuestion> quest : options) {
			pointsUsed += quest.getValue1().submitGet();
		}
		this.pointsLeftToDistribute = pointsToDistribute - pointsUsed;
		PointsLeft.setText(String.format(LABEL_FORMAT, pointsLeftToDistribute));
		
	}


	@Override
	public boolean getValid() {
		int pointsUsed = 0;
		
		for (Pair<DistributeOption, NumberQuestion> quest : options) {
			pointsUsed += quest.getValue1().submitGet();
		}
		return pointsUsed == 0;
	}
	
	public static class DistributeOption {
		public String label;
		public int value;
		public int min;
		public int max;
		public int step;
		public AbstractFormatter format;

		public DistributeOption(String label, int value, int min, int max, int step) {
			super();
			this.label = label;
			this.value = value;
			this.min = min;
			this.max = max;
			this.step = step;
		}
		
		public DistributeOption(String label, int value, int min, int max, int step, AbstractFormatter format) {
			super();
			this.label = label;
			this.value = value;
			this.min = min;
			this.max = max;
			this.step = step;
			this.format = format;
		}
		
		public DistributeOption(String label, int value, int min, int max) {
			super();
			this.label = label;
			this.value = value;
			this.min = min;
			this.max = max;
			this.step = 1;
		}
		
		public DistributeOption(String label, int value, int min, int max, AbstractFormatter format) {
			super();
			this.label = label;
			this.value = value;
			this.min = min;
			this.max = max;
			this.step = 1;
			this.format = format;
		}
		
		
	}

}
