package projet;

import java.io.DataInputStream;
import java.net.Socket;

public class ServeurThread extends Thread{
	
	private Socket socket;
	private Serveur serveur;
	
	public ServeurThread(Socket socket, Serveur serveur) {
		super();
		this.socket = socket;
		this.serveur = serveur;
	}
	
	public void run() {
		try {
			DataInputStream dn = new DataInputStream(socket.getInputStream());
			while(true) {
				String msg = dn.readUTF();
				serveur.sendToAll(msg);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			serveur.deleteConnection(socket);
		}
	}
	
	
	
}
