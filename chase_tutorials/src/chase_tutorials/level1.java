package chase_tutorials;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class level1 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	// Chasetorial 1 Ein- und Ausgabe:
	// Name: Martin Durmich aka Truncatus
		//blubb
		InputStreamReader leser = new InputStreamReader(System.in); //inputs werden in Datenfetzen gewandelt
	    BufferedReader wandler = new BufferedReader(leser); // Buffer wandelt Datenfetzen in Wörter um.
	    String a_name = ""; // Variable für den Namen
	    String a_alter = ""; // Variable für das Alter
	    String a_ort = ""; // Name für den Wohnort
		try { // Mittels Try/Catch werden potentielle Fehler verhindert und als Fehler-Meldung zurückgeschickt.
			System.out.print("Bitte gebe deinen Namen ein: ");
			a_name = wandler.readLine(); // Einschreiben des Namens
			System.out.print("Bitte gebe dein Alter ein: ");
			a_alter = wandler.readLine(); // Einschreiben des Alters
			System.out.print("Bitte gebe deinen Wohnort ein: ");
			a_ort = wandler.readLine(); // Einschreiben des Wohnortes
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    System.out.println("Hallo, Welt. Ich heiße " + a_name + ", bin " + a_alter + " Jahre alt und wohne in " + a_ort + ".");
		/* Kennst du GOptionPane? es ist eine Texteingabeformatierung, 
		 * welche wir früher in der Ausbildung gelernt haben.
		 * */
	}

}
