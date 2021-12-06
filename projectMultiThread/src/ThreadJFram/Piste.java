package ThreadJFram;

import javax.swing.JFrame;

public class Piste extends JFrame {

	public Piste(String title, int largeur, int hauteur) {
		super(title);
		setSize(largeur, hauteur);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

}
