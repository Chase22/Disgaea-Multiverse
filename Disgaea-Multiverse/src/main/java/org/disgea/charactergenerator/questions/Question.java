package org.disgea.charactergenerator.questions;

import javax.swing.JPanel;

public abstract class Question<T> {
	protected String question;
	protected T answer;
	
	/**
	 * @param question
	 */
	public Question(String question) {
		super();
		this.question = question;
	}
	public abstract JPanel generateQuestionPanel();
	public abstract void submit();
	public abstract T getAnswer();
	public T submitGet() {
		submit();
		return getAnswer();
	}
	public abstract boolean getValid();
	
}
