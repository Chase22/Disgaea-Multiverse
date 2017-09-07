

import java.util.ArrayList;
import java.util.List;

public class init {

	static class player {
		String name;
		double init;
		double move;
		int cur_init;
		int cur_move;

		@Override
		public String toString() {
			return name + ": " + init + " Initiative, " + move + " Bewegung, " + cur_init + " Glück";
		}
	}

	static class randomPlayerResult {
		player[] playerArray;
		int maxMove;
		int maxInit;
	}

	public static randomPlayerResult generatePlayer(int count) {
		List<player> resultList = new ArrayList<>();
		// Der aktuell verarbeitete Spieler ist voll der Penner
		player current;
		int maxMove = 0;
		int maxInit = 0;

		while (resultList.size() < count + 1) {
			current = new player();
			current.name = "Player " + (resultList.size() + 1);
			current.init = Math.round(50 + (100 * Math.random()));
			current.move = Math.round(50 + (100 * Math.random()));
			current.cur_init = (int) (Math.round(10 + (40 * Math.random())));
			current.cur_move = current.cur_init;
			System.out.println(current.toString());

			maxMove = (int) Math.max(maxMove, current.move);
			maxInit = (int) Math.max(maxInit, current.init);
			resultList.add(current);
		}

		randomPlayerResult result = new randomPlayerResult();
		result.playerArray = resultList.toArray(new player[count]);
		result.maxInit = maxInit;
		result.maxMove = maxMove;
		return result;
	}

	public static void main(String[] args) {

		// Anzahl der zu berechnenden Spieler
		int anzahl = 25;

		player[] characters;
		List<player> doMove = new ArrayList<>();
		List<player> doInit = new ArrayList<>();

		String[] doit = new String[2];
		doit[0] = " kann eine Aktion ausführen.";
		doit[1] = " kann ziehen.";
		int runde = 0;
		int modus = 1;

		if (modus == 1) {
			int grenzwert = 0;

			randomPlayerResult result = generatePlayer(anzahl);
			characters = result.playerArray;

			grenzwert = Math.max(result.maxInit, result.maxMove) * 3;

			System.out.println("\nGrenzwert der Initiative " + grenzwert);
			while (runde <= 10) {
				doInit.clear();
				doMove.clear();

				for (player p : characters) {
					p.cur_init += p.init;
					p.cur_move += p.move;

					if (p.cur_init >= grenzwert) {
						p.cur_init -= grenzwert;
						doInit.add(p);
					}

					if (p.cur_move >= grenzwert) {
						p.cur_move -= grenzwert;
						doMove.add(p);
					}
				}

				if (!(doMove.isEmpty() && doInit.isEmpty())) {
					System.out.println("Runde " + runde + "\n");

					for (player p : doInit) {
						System.out.println(p.name + doit[0]);
					}

					for (player p : doMove) {
						System.out.println(p.name + doit[1]);
					}

					System.out.println();

					runde++;
				}
			}
		}

	}
}
