package org.disgea.charactergenerator.questions;

import java.util.List;

import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.javatuples.Pair;
import org.javatuples.Quartet;

public class DistributeQuestion extends Question<List<Quartet<String, Integer, Integer, Integer>>> implements ChangeListener {
	
	private int pointsToDistribute;
	List<Pair<Quartet<String, Integer, Integer, Integer>, NumberQuestion>> options;
	
	public DistributeQuestion(List<Quartet<String, Integer, Integer, Integer>> options) {
		for (Quartet<String, Integer, Integer, Integer> opt : options) {
			NumberQuestion question = new NumberQuestion();
			question.setMin(opt.getValue2());
			question.setMax(opt.getValue3());
			question.setValue(opt.getValue1());
			this.options.add(new Pair<Quartet<String,Integer,Integer,Integer>, NumberQuestion>(opt, question));
		}
	}
	

	@Override
	public JPanel generateQuestionPanel() {
		
	}

	@Override
	public void submit() {
		
	}

	@Override
	public List<Quartet<String, Integer, Integer, Integer>> getAnswer() {
		return null;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		
	}


	@Override
	public boolean getValid() {
		return true;
	}

}
