package ThreadJFram;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

public class Main {

	public static void main(String[] args) {
		
		Piste piste = new Piste("Formula 1", 520, 400);
		piste.setLayout(new GridLayout(4, 1));

		Voiture[] voitures = new Voiture[4];
		Thread[] thVoitures = new Thread[4];

		voitures[0] = new Voiture(Color.BLUE, "Ayoub", 0, 370);
		voitures[1] = new Voiture(Color.YELLOW, "Zayd", 0, 370);
		voitures[2] = new Voiture(Color.RED, "Mouad", 0, 370);
		voitures[3] = new Voiture(Color.BLACK, "Mohamed", 0, 370);

		for (int i = 0; i < voitures.length; i++) {
			thVoitures[i] = new Thread(voitures[i]);
			piste.add(voitures[i]);
		}

		for (int i = 0; i < thVoitures.length; i++) {
			thVoitures[i].start();
		}

	}

}
