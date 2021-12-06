package projet;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements Runnable {

	private String nom;
	private Socket s;
	private DataInputStream din;
	private DataOutputStream dout;
	private JTextField txtfield;
	private JTextArea txtArea;

	public Client(String nom, String host, int port) {
		super(nom);
		txtfield = new JTextField();
		txtArea = new JTextArea();
		this.add(txtfield, BorderLayout.NORTH);
		this.add(txtArea, BorderLayout.CENTER);
		txtfield.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dout.writeUTF(nom + " dit : " + txtfield.getText()+"\n");
					txtfield.setText("");
				} catch (Exception ex) {
					System.out.println("Erreur dans actionListnner \n" + ex.getMessage());
				}
			}
		});
		try {
			s = new Socket(host, port);
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
		} catch (Exception ex) {
			System.out.println("Erreur lors de la connexion de client \n" + ex.getMessage());
		}
		setVisible(true);
		setSize(400, 200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		new Thread(this).start();
	}

	public void run() {
		try {
			while (true) {
				String msg = din.readUTF();
				txtArea.append(msg);
			}
		} catch (Exception ex) {
			System.out.println("Erreur Dans la boucle de client : \n" + ex.getMessage());
		}
	}
}
