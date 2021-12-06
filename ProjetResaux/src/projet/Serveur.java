package projet;

import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Serveur {

	HashMap<Socket, DataOutputStream> clients = new HashMap<>();

	public Serveur(int port) {
		ecouter(port);
	}

	private void ecouter(int port) {
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("En ecoute sur : " + ss);
			while (true) {
				Socket s = ss.accept();
				System.out.println("Connexion de : " + s);
				DataOutputStream dout = new DataOutputStream(s.getOutputStream());
				clients.put(s, dout);
				new ServeurThread(s, this).start();
			}
		} catch (Exception ex) {
			System.out.println("Erreur dans la boucle d'ecoute du serveur\n" + ex);
		}
	}

	public void sendToAll(String msg) {
		try {
			synchronized (clients) {
				for (Map.Entry<Socket, DataOutputStream> clts : clients.entrySet()) {
					DataOutputStream dos = clts.getValue();
					dos.writeUTF(msg);
				}
				System.out.println("Diffusion de  : " + msg);
			}
		} catch (Exception ex) {
			System.out.println("Send to all faild");
		}
	}

	public void deleteConnection(Socket s) {
		try {
			synchronized (clients) {
				System.out.println("Deconnection de : "+s);
				clients.remove(s);
			}
		} catch (Exception ex) {
			ex.getMessage();
		}
	}
	
	public static void main(String[] args) {
		new Serveur(9999);
	}
}
