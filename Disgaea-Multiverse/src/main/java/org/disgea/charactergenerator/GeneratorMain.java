package org.disgea.charactergenerator;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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

	static JButton buttonSubmit;

	public static void main(String[] args) {
		JFrame main = new JFrame();

		Box questionbox = Box.createVerticalBox();

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
		options.add(new DistributeOption("Res", 2, 2, 6));
		options.add(new DistributeOption("Trff", 2, 2, 6));
		options.add(new DistributeOption("Ges", 2, 2, 6));
		options.add(new DistributeOption("Init", 2, 2, 6));
		options.add(new DistributeOption("Bew", 2, 2, 6));
		options.add(new DistributeOption("Glü", 2, 2, 6));

		base = new DistributeQuestion("Bitte verteilen sie ihre Werte", options, 25);

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
		options.add(new DistributeOption("Glü", 50, 50, 90, 5, format));

		affinity = new DistributeQuestion("Bitte verteilen sie ihre Werte", options, 220);

		fight = new RadioQuestion("In welcher der folgenden Kampfrollen würdest du dich am wohlsten fühlen?");
		fight.add(new Option<Integer>("Ich renne los und vermöbel ein paar Gegner", 1));
		fight.add(new Option<Integer>("Ich würde wohl mit Spezialfähigkeiten und Zaubern hantieren wollen", 2));
		fight.add(new Option<Integer>("Ich bin FETT und nur schwer umzuhauen", 3));
		fight.add(new Option<Integer>("Ich wäre bemüht, meine Freunde durch Heilmagie gesund zu halten", 4));
		fight.add(new Option<Integer>("Ich bekämpfe meine Gegner am besten aus einer sicheren Entfernung", 5));
		fight.add(new Option<Integer>("Ich würde viele Dinge in kürzester Zeit tun wollen", 6));
		fight.add(new Option<Integer>("Ich möchte regelrecht über das Schlachtfeld düsen", 7));
		fight.add(new Option<Integer>("Ich nehms, wie es kommt und verlasse mich auf mein Glück", 8));
		fight.add(new Option<Integer>("Ich LIEBE hohe Zahlen!!!", 9));
		fight.add(new Option<Integer>("Ich stelle mich als Normalo-Schwertkämpfer vor", 10));
		fight.add(new Option<Integer>("Wie eine Schlange winde ich mich an jede tödliche Schneide vorbei", 11));
		fight.add(new Option<Integer>("Ich wage es, ein Hybrid zu sein", 12));

		weapon = new RadioQuestion<>("Welcher der folgenden Waffen würde am besten zu deinem Gemüt passen?");
		weapon.add(new Option<Integer>(
				"Die Faust. Mit den bloßen Kräften des eigenen Körpers und eiserner Disziplin folge ich dem Pfad der Kampfkunst",
				1));
		weapon.add(new Option<Integer>(
				"Das Schwert. Der Klassiker unter den Waffen und es gibt keine bessere Universalsprache für einen Kampf als die geschärfte Klinge",
				2));
		weapon.add(new Option<Integer>(
				"Die Lanze. Leicht, zu beherrschen aber schwer, sie zu meistern. Nur die erfahrensten Krieger mit guter Konzentration vermögen es, ihr wahres Potential zu entfalten. Eine Waffe, die Gegner und Schaden auf Abstand hält",
				3));
		weapon.add(new Option<Integer>(
				"Die Axt. Die destruktive Kraft, Mutter Natur und Väterchen Kopf zur Fall zu bringen. Wenn du was besiegen willst, dann aber vernünftig",
				4));
		weapon.add(new Option<Integer>(
				"Der Bogen. Leise und doch so tödlich. Es bedarf nicht viel Material, um zurechtzukommen. Sehr kompakt für maximale Mobilität",
				5));
		weapon.add(new Option<Integer>(
				"Die Knarre. Denn wer will bitteschön mit nem Messer zu einer Schießerei? Ich erledige sie mit Präzision und Knappheit.",
				6));
		weapon.add(new Option<Integer>(
				"Der Stab. Die Macht ist mit dir, Max Mustermann. Zauberei ist für mich kein Fremdwort und das sollten meine Feinde auch verstehen können.",
				7));
		weapon.add(new Option<Integer>(
				"Das Buch mit Federkiel. Die Feder ist stärker als das Schwert, so sagt man. Ein gutes Denkvermögen ist ein Muss auf dem Schlachtfeld.",
				8));

		target = new RadioQuestion<>("Was erhoffst du, im Laufe deiner Reise zu finden?");
		target.add(new Option<Integer>("Wissen", 1));
		target.add(new Option<Integer>("Macht", 2));
		target.add(new Option<Integer>("Reichtum", 3));
		target.add(new Option<Integer>("Rache", 4));
		target.add(new Option<Integer>("Glückseligkeit", 5));
		target.add(new Option<Integer>("Antworten", 6));
		target.add(new Option<Integer>("Wunder", 7));
		target.add(new Option<Integer>("Veränderungen", 8));
		target.add(new Option<Integer>("Spaß", 9));
		target.add(new Option<Integer>("Eine Gottheit", 10));

		character = new RadioQuestion<>("Mit welchem der folgenden Charaktere könnte sich dein Charakter am besten identifizieren?");
		character.add(new Option<Integer>("Riou(Suikoden)", 1));
		character.add(new Option<Integer>("Natsu(Fairy Tail)", 2));
		character.add(new Option<Integer>("Sora(Kindom Hearts)", 3));
		character.add(new Option<Integer>("Asura(Asura's Wrath)", 4));
		character.add(new Option<Integer>("Hector(Fire Emplem)", 5));
		character.add(new Option<Integer>("Deadpool(Deadpool)", 6));
		character.add(new Option<Integer>("Could(Final Fantasy)", 7));
		character.add(new Option<Integer>("Dante(Devil may Cry)", 8));
		character.add(new Option<Integer>("Link(The Legend of Zelda)", 9));
		character.add(new Option<Integer>("Gandalf(Der Herr der Ringe)", 10));
		
		attributes = new CheckQuestion<>("Welche der folgenden Attribute möchtest du besonders fördern?(Bitte wähle 4 verschiedene Attribute)", 4);
		
		attributes.add(new Option<Integer>("Trefferpunkte", 1));
		attributes.add(new Option<Integer>("Spezialpunkte", 2));
		attributes.add(new Option<Integer>("Stärke", 3));
		attributes.add(new Option<Integer>("Abwehr", 4));
		attributes.add(new Option<Integer>("Int", 5));
		attributes.add(new Option<Integer>("Resistenz", 6));
		attributes.add(new Option<Integer>("Treffer", 7));
		attributes.add(new Option<Integer>("Ges", 8));
		attributes.add(new Option<Integer>("Init", 9));
		attributes.add(new Option<Integer>("bew", 10));
		attributes.add(new Option<Integer>("Glü", 11));

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

		questionbox.add(buttonSubmit);

		main.add(pane);

		main.pack();
		main.setVisible(true);
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Character character = new Character();
		character.setCharname(name.submitGet());
		character.setPlayername(player.submitGet());
		character.setRace(race.submitGet());
		character.setGender(gender.submitGet());
	}

}
