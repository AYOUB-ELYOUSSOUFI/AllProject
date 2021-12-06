package projectMultiThread;

class Ballon extends Thread {
	private String marque;

	public Ballon() {
	}

	public Ballon(String marque) {
		super();
		this.marque = marque;
	}

	public synchronized void recevoir_lache(Joueur j) {
		System.out.println(j + " reçoit le ballon.");
		try {
			Thread.sleep(1200);
		} catch (Exception ex) {
		}
		System.out.println(j + " lache le ballon");
	}
}

class Joueur extends Thread {
	private String nom;
	private Ballon ballon;

	public Joueur(String nom, Ballon ballon) {
		super();
		this.nom = nom;
		this.ballon = ballon;
	}

	public void run() {
		while (true) {
			ballon.recevoir_lache(this);
		}
	}

	@Override
	public String toString() {
		return "Joueur nom=" + nom;
	}

}

public class Main {

	public static void main(String[] args) {
		Ballon b = new Ballon();

		Joueur[] joueurs = new Joueur[5];

		joueurs[0] = new Joueur("ayoub", b);
		joueurs[1] = new Joueur("zayd", b);
		joueurs[2] = new Joueur("mohamed", b);
		joueurs[3] = new Joueur("anass", b);
		joueurs[4] = new Joueur("mouad", b);

		for (int i = 0; i < joueurs.length; i++) {
			joueurs[i].start();
		}

	}

}
