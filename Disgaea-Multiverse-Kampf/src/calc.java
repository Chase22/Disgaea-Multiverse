import org.disgea.data.character.Attributes;
import org.disgea.data.character.Character;

public class calc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Kampfrelevante Werte beider Seiten
		//Werte des Angreifers
		Character angreifer = new Character();
		Character verteidiger = new Character();
		
		angreifer.setCharname("Sarius"); //Name als Lückenfüller
		angreifer.setLevel(0); // Level
		
		angreifer.getAttributes().setIntelligence(5); // Intelligenz 
		angreifer.getAttributes().setHit(11); // Treffer
		angreifer.getAttributes().setLuck(6); // Glück
		

		double a_bodystrength = 12; // Körperkraft
		int a_wisdom = 5; // Weisheit
		double a_skill = 15; // Geschicklichkeit
		double a_attack = 14; // Stärke
		int a_rank = 0; // Wichtig für die Beförderung im Laufe des Spiels.
		int a_critstrike = 5; // Zusatz-Chance für einen kritischen Treffer
		double a_mindam = 0; // Mindestschaden, der verursacht wird.
		double a_maxdam = 0; // Maxschaden, der verursacht wird.
		double a_bonusdamage = 1.40;
		
		//Werte des Verteidigers
		String b_name = "Nesani"; //Name als Lückenfüller
		int b_lv = 0; // Level
		double b_bodystrength = 11; // Körperkraft
		int b_wisdom = 8; // Weisheit
		double b_skill = 16; // Geschicklichkeit
		double b_defence = 7; // Abwehr
		int b_resistance = 11; // Resistenz
		double b_dodge = 15; // Geschwindigkeit
		double b_luck = 6; // Glück
		double b_element_res = 0.2; // Resistenz zu dem jeweiligen Waffentyp oder Zauberelement
		int b_rank = 0; // Wichtig für die Beförderung im Laufe des Spiels.
		int b_critguard = 5; // Zusatz-Chance für eine kritische Verteidigung
		double b_damage = 1.00; //Anteil des Gesamtschadens, der ignoriert wird.
		double b_mindef = 0; // Mindestschaden, der verursacht wird.
		double b_maxdef = 0; // Maxschaden, der verursacht wird.
		
		// Variablen für die Verhältnisse
		double bodystrength_factor;
		double wisdom_factor;
		double skill_factor;
		
		// Variablen für Trefferchance und Würfel.
		double hit_chance;
		double dice_100;
		
		// Luck-Faktor
		double luck_factor_a;
		double luck_factor_b;
		double crit_strike_chance;
		double crit_defence_chance;
	
		// Schaden
		double mindamage;
		double maxdamage;
		int totaldamage = 0;
		
		System.out.println(angreifer.getCharname() + " greift " + b_name + " an!!!");
		
		// Phase 1: Körperwerte vergleichen.
		// Körperkraft-Verhältnis
		bodystrength_factor = (b_bodystrength / a_bodystrength);
		if(b_bodystrength < a_bodystrength){
			System.out.println(angreifer.getCharname() + " verfügt über eine höhere Körperkraft als " + b_name + ". Dadurch reduziert sich " + b_name + "s Abwehr um " + Math.round((1 - bodystrength_factor)*10000)/100 + "%");
		}
		if(bodystrength_factor > 1.00)bodystrength_factor = 1.00;
		b_defence = b_defence * bodystrength_factor;
		
		
		// Weisheit-Verhältnis
		// FOLGT NOCH
		
		
		// Geschicklichkeit-Verhältnis
		skill_factor = (a_skill / b_skill);
		if(a_skill < b_skill){
			System.out.println(b_name + " verfügt über eine höhere Geschicklichkeit als " + angreifer.getCharname() + ". Dadurch reduziert sich " + a_name + "s Treffer um " + Math.round((1 - skill_factor)*10000)/100 + "%");
		}
		if(skill_factor > 1.00)skill_factor = 1.00;
		angreifer.getAttributes().setHit(angreifer.getAttributes().getHit()*skill_factor);
			
		// Phase 2: Trefferchance auswerten
		hit_chance = ((a_hit*1.5) + (a_luck*0.1) + a_lv) / ((b_dodge) + (b_luck*0.1) + b_lv*2)*100;
		if(hit_chance > 100)hit_chance = 100;
		System.out.println(a_name + " hat eine Trefferchance von " + Math.round(hit_chance) + "%");
		
		// Auswertung, ob der Angriff auch trifft
		dice_100 = Math.random()*100+1;
		
		// Wenn der Angreifer trifft 
		if(dice_100 <= hit_chance){
			System.out.println(a_name + " hat " + b_name + " getroffen.");
			
			// Glücksfaktor bestimmen für Schadensschwankung und Chance auf Crits 
			luck_factor_a = (b_luck / a_luck);
			luck_factor_b = (a_luck / b_luck);
			
			// Signalisierung für die Spieler, ob sie oder der Gegner mehr Glück hat.
			if(a_luck > b_luck){
				System.out.println("Das Glück ist mehr auf " + a_name + "s Seite");
			} else if (b_luck > a_luck){
				System.out.println("Das Glück ist mehr auf " + b_name + "s Seite");
			} else {
				System.out.println("Das Glück ist sehr ausgewogen.");
			}
			
			// Bestimmung der kritischen Verteidigungschance des Verteidigers
			crit_defence_chance = (5 + b_rank) + (b_critguard * luck_factor_a);
			System.out.println(b_name + " hat eine Chance von " + Math.round(crit_defence_chance*100)/100 + "%, eine kritische Verteidigung zu triggern.");
			dice_100 = Math.random()*100;
			// Abfrage, ob der Crit gelingt
			if(dice_100 <= crit_defence_chance){
				System.out.println(b_name + " gelingt eine KRITISCHE VERTEIDIGUNG!!!");
				b_defence = b_defence*(1 + (0.25 + (0.05 * b_rank)));
				b_damage = b_damage - ((0.25 + (0.05 * b_rank)));
			}
			
			// Bestimmung der kritischen Trefferchance des Angreifers
			crit_strike_chance = (5 + a_rank) + (a_critstrike * luck_factor_b);
			System.out.println(a_name + " hat eine Chance von " + Math.round(crit_strike_chance*100)/100 + "%, einen kritischen Treffer zu landen.");
			dice_100 = Math.random()*100;
			if(dice_100 <= crit_strike_chance){
				System.out.println(b_name + " landet einen KRITISCHEN TREFFER!!!");
				a_attack = a_attack*(1 + (0.25 + (0.05 * a_rank)));
				b_defence = b_defence * (1-(0.25 + (0.05 * a_rank)));
			}
			
			//
			a_mindam = (a_attack + a_lv) * (1 - (luck_factor_a*(0.01*(10 - a_rank))));
			a_maxdam = (a_attack + a_lv) * (1 + (luck_factor_b*(0.01*(5 + a_rank))));
			b_mindef = ((b_defence + b_lv*2) * (1 - (luck_factor_b*(0.01*(10 - b_rank)))))/2;
			b_maxdef = ((b_defence + b_lv*2) * (1 + (luck_factor_b*(0.01*(5 + b_rank)))))/2;
			
			mindamage = a_mindam - b_maxdef;
			if(mindamage < 0) mindamage = 0;
			maxdamage = a_maxdam - b_mindef;
			if(maxdamage < 0) maxdamage = 0;
			
			System.out.println("Der Treffer wird zwischen " + Math.round(mindamage*100)/100 + " und " + Math.round(maxdamage*100)/100 + " Schaden verursachen.");
			totaldamage = (int)Math.round((((mindamage + (Math.random()*(maxdamage-mindamage))))*(1 - b_element_res)*a_bonusdamage)*b_damage);
			System.out.println("Schadensmultiplikator durch aktuellen Waffen-/Zauber-Typ: " + (1.0 - b_element_res));
			System.out.println("Schadensbonus: " + (int)(- 100 + (a_bonusdamage * 100)) + "%");
			System.out.println("Schadensreduzierung: " + (int)(100 - (b_damage * 100)) + "%");
			System.out.println(b_name + " erleidet " + totaldamage + " Schaden.");
			
		} 
		// Wenn der Angreifer nicht trifft... 
		else{
			System.out.println(a_name + " hat " + b_name + " verfehlt.");
		}

	}

}
