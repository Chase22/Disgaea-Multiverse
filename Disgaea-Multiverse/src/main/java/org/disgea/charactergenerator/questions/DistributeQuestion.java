package org.disgea.charactergenerator.questions;

import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.javatuples.Pair;
import org.javatuples.Quartet;

// Quartet<String, Integer, Integer, Integer> Label, Value, Min, Max
public class DistributeQuestion extends Question<List<Quartet<String, Integer, Integer, Integer>>> implements ChangeListener {
	
	private int pointsToDistribute;
	private int pointsLeftToDistribute;
	
	List<Pair<Quartet<String, Integer, Integer, Integer>, NumberQuestion>> options;
	
	private JLabel PointsLeft = new JLabel();
	final String LABEL_FORMAT = "Points left: %d";
	
	public DistributeQuestion(List<Quartet<String, Integer, Integer, Integer>> options, int pointToDistribute) {
		int pointsUsed = 0;
		for (Quartet<String, Integer, Integer, Integer> opt : options) {
			NumberQuestion question = new NumberQuestion();
			question.setMin(opt.getValue2());
			question.setMax(opt.getValue3());
			question.setValue(opt.getValue1());
			this.options.add(new Pair<Quartet<String,Integer,Integer,Integer>, NumberQuestion>(opt, question));
			this.pointsToDistribute += opt.getValue1();
		}
		pointsUsed = pointsToDistribute;
		this.pointsToDistribute += pointToDistribute;
		this.pointsLeftToDistribute = pointToDistribute - pointsUsed;
		PointsLeft.setText(String.format(LABEL_FORMAT, pointsLeftToDistribute));
	}
	

	@Override
	public JPanel generateQuestionPanel() {
		JPanel panel = new JPanel();
		
		for (Pair<Quartet<String, Integer, Integer, Integer>, NumberQuestion> quest : options) {
			panel.add(quest.getValue1().generateQuestionPanel());
		}
		panel.add(PointsLeft);
		return panel;
	}

	@Override
	public void submit() {
		answer.clear();
		for (Pair<Quartet<String, Integer, Integer, Integer>, NumberQuestion> quest : options) {
			quest.getValue1().submit();
			quest.getValue0().setAt1(quest.getValue1().getAnswer());
			answer.add(quest.getValue0());
		}
	}

	@Override
	public List<Quartet<String, Integer, Integer, Integer>> getAnswer() {
		return answer;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int pointsUsed = 0;
		
		for (Pair<Quartet<String, Integer, Integer, Integer>, NumberQuestion> quest : options) {
			pointsUsed += quest.getValue1().submitGet();
		}
		this.pointsLeftToDistribute = pointsToDistribute - pointsUsed;
		PointsLeft.setText(String.format(LABEL_FORMAT, pointsLeftToDistribute));
		
	}


	@Override
	public boolean getValid() {
		int pointsUsed = 0;
		
		for (Pair<Quartet<String, Integer, Integer, Integer>, NumberQuestion> quest : options) {
			pointsUsed += quest.getValue1().submitGet();
		}
		return pointsUsed == 0;
	}

}
