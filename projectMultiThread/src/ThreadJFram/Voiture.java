package ThreadJFram;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Voiture extends Canvas implements Runnable {

	private Color couleur;
	private String pilote;
	private int vitesse;
	private int position;
	private int depart;
	private int arrivee;

	public Voiture(Color couleur, String pilote, int depart, int arrivee) {
		super();
		this.couleur = couleur;
		this.pilote = pilote;
		this.depart = depart;
		this.arrivee = arrivee;
		position = depart;
		vitesse = (int) Math.floor(Math.random() * 1000);
		setSize(120, 50);
	}

	public void avancer(int p) {
		position += p;
		repaint();
	}

	public void reculer(int r) {
		position -= r;
		repaint();
	}

	public void paint(Graphics g) {
		g.setColor(couleur);
		g.fillRoundRect(position, 10, 120, 30, 10, 10);
		g.fillOval(position + 10, 32, 30, 30);
		g.fillOval(position + 75, 32, 30, 30);
		g.setColor(Color.white);
		g.drawString(pilote, position + 10, 30);
	}

	@Override
	public void run() {
		while (position <= arrivee) {
			avancer(1);
			try {
				Thread.sleep(vitesse);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
		}

	}

}
