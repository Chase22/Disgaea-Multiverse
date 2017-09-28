package org.disgea.charactergenerator.questions;

import javax.swing.JPanel;

public abstract class Question<T> {
	protected String question;
	protected T answer;
	
	public abstract JPanel generateQuestionPanel();
	public abstract void submit();
	public abstract T getAnswer();
	public T submitGet() {
		submit();
		return getAnswer();
	}
	public abstract boolean getValid();
	
}
