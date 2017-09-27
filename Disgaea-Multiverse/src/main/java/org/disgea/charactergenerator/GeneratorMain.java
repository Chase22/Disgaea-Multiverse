package org.disgea.charactergenerator;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.disgea.charactergenerator.questions.Option;
import org.disgea.charactergenerator.questions.RadioQuestion;
import org.disgea.charactergenerator.questions.TextQuestion;

public class GeneratorMain {

	public static void main(String[] args) {
		JFrame main = new JFrame();
		TextQuestion question = new TextQuestion();
		RadioQuestion radio = new RadioQuestion();
		
		radio.add(new Option<String>("Test 1", "Test 1"));
		radio.add(new Option<String>("Test 2", "Test 2"));
		radio.add(new Option<String>("Test 3", "Test 3"));
		radio.add(new Option<String>("Test 4", "Test 4"));
		
		JButton button = new JButton("Submit");
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				question.submit();
				radio.submit();
				System.out.println(question.getAnswer());
				System.out.println(radio.getAnswer().getValue());
			}
		});
		
		question.setMaxLength(40);
		main.setLayout(new FlowLayout());
		main.add(question.generateQuestionPanel());
		main.add(radio.generateQuestionPanel());
		main.add(button);
		
		main.setSize(new Dimension(600, 400));
		//main.pack();
		main.setVisible(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
