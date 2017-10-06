package org.disgea.charactergenerator;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;

import org.disgea.charactergenerator.questions.CheckQuestion;
import org.disgea.charactergenerator.questions.DistributeQuestion;
import org.disgea.charactergenerator.questions.DistributeQuestion.DistributeOption;
import org.disgea.charactergenerator.questions.Option;
import org.disgea.charactergenerator.questions.RadioQuestion;
import org.disgea.charactergenerator.questions.TextQuestion;
import org.disgea.data.character.Character;
import org.javatuples.Quartet;

public class GeneratorMain implements ActionListener {

	static TextQuestion name;
	static TextQuestion player;
	static TextQuestion race;
	static TextQuestion gender;

	static DistributeQuestion base;
	static DistributeQuestion affinity;

	static RadioQuestion<Integer> fight;
	static RadioQuestion<Integer> weapon;
	static RadioQuestion<Integer> target;
	static RadioQuestion<Integer> character;

	static CheckQuestion<Integer> attributes;

	static RadioQuestion<Integer> classQuestion;

	static JButton buttonSubmit;

	public static void main(String[] args) {
		JFrame main = new JFrame();

		Box questionbox = Box.createVerticalBox();

		ResourceBundle questionBundle = ResourceBundle.getBundle("QuestionBundle");

		JScrollPane pane = new JScrollPane(questionbox);

		main.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				super.mousePressed(e);
				System.out.println(e.getX());
			}
		});

		buttonSubmit = new JButton("Submit");
		buttonSubmit.addActionListener(new GeneratorMain());

		name = new TextQuestion("Name:", 40);
		player = new TextQuestion("Spieler:", 40);
		race = new TextQuestion("Rasse:", 40);
		gender = new TextQuestion("Geschlecht:", 40);

		List<DistributeOption> options = new ArrayList<>();
		options.add(new DistributeOption("TP", 4, 4, 8));
		options.add(new DistributeOption("SP", 2, 2, 6));
		options.add(new DistributeOption("STr", 2, 2, 6));
		options.add(new DistributeOption("Abw", 2, 2, 6));
		options.add(new DistributeOption("Int", 2, 2, 6));
		options.add(new DistributeOption("Res", 2, 2, 6));
		options.add(new DistributeOption("Trff", 2, 2, 6));
		options.add(new DistributeOption("Ges", 2, 2, 6));
		options.add(new DistributeOption("Init", 2, 2, 6));
		options.add(new DistributeOption("Bew", 2, 2, 6));
		options.add(new DistributeOption("Gl�ck", 2, 2, 6));

		base = new DistributeQuestion(questionBundle.getString("baseQuest"), options, 25);

		StringFormatter format = new StringFormatter("%d%%");

		options = new ArrayList<>();
		options.add(new DistributeOption("TP", 50, 50, 90, 5, format));
		options.add(new DistributeOption("SP", 50, 50, 90, 5, format));
		options.add(new DistributeOption("STr", 50, 50, 90, 5, format));
		options.add(new DistributeOption("Abw", 50, 50, 90, 5, format));
		options.add(new DistributeOption("Res", 50, 50, 90, 5, format));
		options.add(new DistributeOption("Trff", 50, 50, 90, 5, format));
		options.add(new DistributeOption("Ges", 50, 50, 90, 5, format));
		options.add(new DistributeOption("Init", 50, 50, 90, 5, format));
		options.add(new DistributeOption("Bew", 50, 50, 90, 5, format));
		options.add(new DistributeOption("Gl�ck", 50, 50, 90, 5, format));

		affinity = new DistributeQuestion(questionBundle.getString("affinityQuest"), options, 220);

		fight = new RadioQuestion(questionBundle.getString("fightQuest"));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt1"), 1));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt2"), 2));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt3"), 3));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt4"), 4));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt5"), 5));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt6"), 6));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt7"), 7));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt8"), 8));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt9"), 9));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt10"), 10));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt11"), 11));
		fight.add(new Option<Integer>(questionBundle.getString("fightOpt12"), 12));

		weapon = new RadioQuestion<>(questionBundle.getString("weaponQuest"));
		weapon.add(new Option<Integer>(questionBundle.getString("weaponOpt1"), 1));
		weapon.add(new Option<Integer>(questionBundle.getString("weaponOpt2"), 2));
		weapon.add(new Option<Integer>(questionBundle.getString("weaponOpt3"), 3));
		weapon.add(new Option<Integer>(questionBundle.getString("weaponOpt4"), 4));
		weapon.add(new Option<Integer>(questionBundle.getString("weaponOpt5"), 5));
		weapon.add(new Option<Integer>(questionBundle.getString("weaponOpt6"), 6));
		weapon.add(new Option<Integer>(questionBundle.getString("weaponOpt7"), 7));
		weapon.add(new Option<Integer>(questionBundle.getString("weaponOpt8"), 8));

		target = new RadioQuestion<>(questionBundle.getString("targetQuest"));
		target.add(new Option<Integer>(questionBundle.getString("targetOpt1"), 1));
		target.add(new Option<Integer>(questionBundle.getString("targetOpt2"), 2));
		target.add(new Option<Integer>(questionBundle.getString("targetOpt3"), 3));
		target.add(new Option<Integer>(questionBundle.getString("targetOpt4"), 4));
		target.add(new Option<Integer>(questionBundle.getString("targetOpt5"), 5));
		target.add(new Option<Integer>(questionBundle.getString("targetOpt6"), 6));
		target.add(new Option<Integer>(questionBundle.getString("targetOpt7"), 7));
		target.add(new Option<Integer>(questionBundle.getString("targetOpt8"), 8));
		target.add(new Option<Integer>(questionBundle.getString("targetOpt9"), 9));
		target.add(new Option<Integer>(questionBundle.getString("targetOpt10"), 10));

		character = new RadioQuestion<>(questionBundle.getString("characterQuest"));
		character.add(new Option<Integer>(questionBundle.getString("characterOpt1"), 1));
		character.add(new Option<Integer>(questionBundle.getString("characterOpt2"), 2));
		character.add(new Option<Integer>(questionBundle.getString("characterOpt3"), 3));
		character.add(new Option<Integer>(questionBundle.getString("characterOpt4"), 4));
		character.add(new Option<Integer>(questionBundle.getString("characterOpt5"), 5));
		character.add(new Option<Integer>(questionBundle.getString("characterOpt6"), 6));
		character.add(new Option<Integer>(questionBundle.getString("characterOpt7"), 7));
		character.add(new Option<Integer>(questionBundle.getString("characterOpt8"), 8));
		character.add(new Option<Integer>(questionBundle.getString("characterOpt9"), 9));
		character.add(new Option<Integer>(questionBundle.getString("characterOpt10"), 10));

		attributes = new CheckQuestion<>(questionBundle.getString("attributesQuest"), 4);

		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt1"), 1));
		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt2"), 2));
		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt3"), 3));
		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt4"), 4));
		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt5"), 5));
		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt6"), 6));
		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt7"), 7));
		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt8"), 8));
		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt9"), 9));
		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt10"), 10));
		attributes.add(new Option<Integer>(questionBundle.getString("attributesOpt11"), 11));

		classQuestion = new RadioQuestion<>(questionBundle.getString("classQuest"));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt1"), 1));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt2"), 2));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt3"), 3));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt4"), 4));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt5"), 5));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt6"), 6));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt7"), 7));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt8"), 8));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt9"), 9));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt10"), 10));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt11"), 11));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt12"), 12));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt13"), 13));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt14"), 14));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt15"), 15));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt16"), 16));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt17"), 17));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt18"), 18));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt19"), 19));
		classQuestion.add(new Option<Integer>(questionBundle.getString("classOpt20"), 20));

		questionbox.add(name.generateQuestionPanel());
		questionbox.add(player.generateQuestionPanel());
		questionbox.add(race.generateQuestionPanel());
		questionbox.add(gender.generateQuestionPanel());
		questionbox.add(base.generateQuestionPanel());
		questionbox.add(affinity.generateQuestionPanel());
		questionbox.add(fight.generateQuestionPanel());
		questionbox.add(weapon.generateQuestionPanel());
		questionbox.add(target.generateQuestionPanel());
		questionbox.add(character.generateQuestionPanel());
		questionbox.add(attributes.generateQuestionPanel());
		questionbox.add(classQuestion.generateQuestionPanel());

		questionbox.add(buttonSubmit);

		main.add(pane);

		main.pack();
		main.setVisible(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Character character = new Character();
		List<DistributeOption> options;
		int answer;

		character.setCharname(name.submitGet());
		character.setPlayername(player.submitGet());
		character.setRace(race.submitGet());
		character.setGender(gender.submitGet());

		options = base.submitGet();
		character.setHitpoints(options.get(0).value);
		character.setSpecialpoints(options.get(1).value);
		character.getAttributes().setStrength(options.get(2).value);
		character.getAttributes().setDefense(options.get(3).value);
		character.getAttributes().setIntelligence(options.get(4).value);
		character.getAttributes().setResistance(options.get(5).value);
		character.getAttributes().setHit(options.get(6).value);
		character.getAttributes().setSpeed(options.get(7).value);
		character.getAttributes().setInitiative(options.get(8).value);
		character.getAttributes().setMovement(options.get(9).value);
		character.getAttributes().setLuck(options.get(10).value);

		options = affinity.submitGet();
		character.setHitpoints(options.get(0).value);
		character.setSpecialpoints(options.get(1).value);
		character.getAffinities().setStrength(options.get(2).value);
		character.getAffinities().setDefense(options.get(3).value);
		character.getAffinities().setIntelligence(options.get(4).value);
		character.getAffinities().setResistance(options.get(5).value);
		character.getAffinities().setHit(options.get(6).value);
		character.getAffinities().setSpeed(options.get(7).value);
		character.getAffinities().setInitiative(options.get(8).value);
		character.getAffinities().setMovement(options.get(9).value);
		character.getAffinities().setLuck(options.get(10).value);

		answer = fight.submitGet().getValue();
		switch (answer) {
		case 1:
			character.getAttributes().changeAttributes(4, 1, 0, 1, 3, 2, 1, 1, 2);
			character.setHitpoints(character.getHitpoints() + 1);
			character.setSpecialpoints(character.getSpecialpoints() + 1);
			break;
		case 2:
			character.getAttributes().changeAttributes(0, 1, 3, 2, 3, 2, 1, 1, 2);
			character.setHitpoints(character.getHitpoints() + 1);
			character.setSpecialpoints(character.getSpecialpoints() + 4);
			break;
		case 3:
			character.getAttributes().changeAttributes(2, 4, 1, 3, 0, 2, 1, 1, 2);
			character.setHitpoints(character.getHitpoints()+3);
			character.setSpecialpoints(character.getSpecialpoints()+1);
			break;
		case 4:
			character.getAttributes().changeAttributes(1, 2, 3, 4, 1, 2, 2, 1, 1);
			character.setHitpoints(character.getHitpoints()+0);
			character.setSpecialpoints(character.getSpecialpoints()+3);
			break;
		case 5:
			break;
		case 6:
			break;
		case 7:
			break;
		case 8:
			break;
		case 9:
			break;
		case 10:
			break;
		case 11:
			break;
		case 12:
			break;
		}

	}

}
