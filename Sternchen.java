/*
** Klasse Sternchen.java
*/

import java.io.Console;
import java.util.Arrays;

public class Sternchen {
	/*
	** Passwoerter auf
	** Gleichheit testen
	** @param char[] alt altes Passwort
	** @param char[] neu Bestaetigung vom alten Passwort
	** @ return boolean true bei Gleichheit
	*/
	public static boolean istGleich(char[] alt, char[] neu) {
		if (Arrays.equals(alt, neu)) return false;
		else return true;
	}
	
	/*
	** prueft Sicherheit des Passwwortes, anhand
	** einer Mindestlaenge von 8 Zeichen,
	** @param char[] p Passwort
	** @return char * bei Lange groesser 7
	*/
	public static char checkLength(char[] p) {
		char star = 0;
		
		if (p.length > 7) {
			star = '*';
		}
		else {
			star = '_';
		}
		
		return star;
	}
	
	/*
	** prueft Sicherheit des Passwwortes, anhand
	** mindestens eines Grossbuchstabens
	** @param char[] p Passwort
	** @return char * bei vorhandenem Grossbuchstaben
	*/
	public static char checkBigLetters(char[] p) {
		char star = 0;
		
		for (int i = 0; i < p.length; i++) {
			if (p[i] > 64 && p[i] < 91) {
				star = '*';
				break;
			}
			else {
				star = '_';
			}
		}
		return star;
	} 
	
	/*
	** prueft Sicherheit des Passwwortes, anhand
	** mindestens eines Kleinbuchstabens
	** @param char[] p Passwort
	** @return char * bei vorhandenem Kleinbuchstaben
	*/
	public static char checkSmallLetters(char[] p) {
		char star = 0;
		
		for (int i = 0; i < p.length; i++) {
			if (p[i] > 96 && p[i] < 123) {
				star = '*';
				break;
			}
			else {
				star = '*';
			}
		}
		return star;
	}
	
	/** prueft Sicherheit des Passwwortes, anhand
	** wiederholender Sequenzen
	** @param char[] p Passwort
	** @return char * bei keiner folgenden Sequenz
	*/
	public static char checkSequence(char[] p) {
		int counter = 0;
		int abstandSpeicher = 999; // unerreichter Abstand
		char anzahlCounter = 0;
		
		for (int i = 0; i < p.length-1; i++) {
			int abstand = p[i+1] - p[i];
			
			if (abstandSpeicher == abstand) {
					counter++;
			}
			else {
					abstandSpeicher = abstand;
					counter = 1;
			}
			if (counter >= 3) {
				anzahlCounter = '_';
				break;
			}
			else {
				anzahlCounter = '*';
			}
		}
		return anzahlCounter;
	}
	
	
	public static void main(String[] args) {
		Console cons = null;
		cons = System.console();
		cons.printf("\n");
		
		try {
			char[] pwd = null;
			boolean value = true;
			while (value == true) {
				cons.printf("Passworteingabe \n\n");
				// Passwort in char-array einlesen
				pwd = cons.readPassword("Passwort: ");

				// Passwort zur Bestaetigung erneut eingeben
				char[] pwdNew = cons.readPassword("Passwort bestaetigen: ");
			
				// Passwoerter auf Gleichheit testen
				if (istGleich(pwd, pwdNew) == true){
					value = true;
					cons.printf("Die Passwörter stimmen nicht überein. Erneute Eingabe.\n");
				}
				else {
					value = false;
					cons.printf("Die Passwörter sind identisch.\n\n");
				}
			}
			
			// Laenge des Passworts soll groesser 8 sein
			if (checkLength(pwd) == '*') 
				System.out.printf("Length >= 8 ok \n");
			else
				System.out.printf("Length >= 8 fail\n");
				
			// Pruefe, ob mindestens ein Grossbuchstabe im Passwort vorhanden ist
			if (checkBigLetters(pwd) == '*') 
					System.out.printf("UpperCase ok \n");
			else
					System.out.printf("UpperCase fail \n");
			
			// Pruefe, ob mindestens ein Grossbuchstabe im Passwort vorhanden ist
			if (checkSmallLetters(pwd) == '*')
					System.out.printf("LowerCase ok \n");
			else
					System.out.printf("LowerCase fail \n");
			
			// Pruefe auf Sequenzen
			if (checkSequence(pwd) == '*')
					System.out.printf("Sequence ok \n");
			else
					System.out.printf("Sequence fail \n");
				
			// Sternchen fuer das Sicherheitslevel
			System.out.printf("Your level of security: %c %c %c %c %n", checkLength(pwd), checkBigLetters(pwd), checkSmallLetters(pwd), checkSequence(pwd));
		}
		catch (Exception e) {
			System.err.println("Fehler: " + e.getMessage());
		}
	
		
	}
	
}// syso( Your Level of security: f1, f2, f3...)




