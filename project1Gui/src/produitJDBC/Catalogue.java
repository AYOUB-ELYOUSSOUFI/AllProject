package produitJDBC;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project1Gui.Produit;

public class Catalogue extends JFrame implements ActionListener {

	private JPanel panelAction, panelLabel, panelNavigation, panelText;
	private JButton btnAjouter, btnModifier, btnSupprimer, btnValider, btnFirst, btnNext, btnPrevious, btnLast;
	private JLabel lblCode, lblDesignation, lblPrix, lblQuantite;
	private JTextField txtCode, txtDesignation, txtPrix, txtQuantite;

	String mode = "Ajout";
	ArrayList<Produit> produits = new ArrayList<>();
	Connection connection;
	ResultSet rs;
	Statement st;

	public Catalogue() {
		super("Catalogue");

		// Labels
		lblCode = new JLabel("Code : ");
		lblDesignation = new JLabel("Designation : ");
		lblPrix = new JLabel("Prix : ");
		lblQuantite = new JLabel("Quantite : ");

		// TextFields
		txtCode = new JTextField("", 10);
		txtDesignation = new JTextField("", 10);
		txtPrix = new JTextField("", 10);
		txtQuantite = new JTextField("", 10);

		// Buttons
		btnAjouter = new JButton("Ajouter");
		btnModifier = new JButton("Modifier");
		btnSupprimer = new JButton("Supprimer");
		btnValider = new JButton("Valider");
		btnFirst = new JButton("<");
		btnNext = new JButton(">>");
		btnPrevious = new JButton("<<");
		btnLast = new JButton(">");

		panelAction = new JPanel(new GridLayout(1, 4));

		panelAction.add(btnAjouter);
		panelAction.add(btnModifier);
		panelAction.add(btnSupprimer);
		panelAction.add(btnValider);
		this.add(panelAction, BorderLayout.NORTH);

		panelNavigation = new JPanel(new GridLayout(1, 4));

		panelNavigation.add(btnFirst);
		panelNavigation.add(btnPrevious);
		panelNavigation.add(btnNext);
		panelNavigation.add(btnLast);
		this.add(panelNavigation, BorderLayout.SOUTH);

		panelLabel = new JPanel(new GridLayout(4, 1));

		panelLabel.add(lblCode);
		panelLabel.add(lblDesignation);
		panelLabel.add(lblPrix);
		panelLabel.add(lblQuantite);
		this.add(panelLabel, BorderLayout.WEST);

		panelText = new JPanel(new GridLayout(4, 1));

		panelText.add(txtCode);
		panelText.add(txtDesignation);
		panelText.add(txtPrix);
		panelText.add(txtQuantite);

		this.add(panelText, BorderLayout.CENTER);
		this.setSize(600, 200);
		this.setVisible(true);
		activated(true);

		Component[] components = this.getContentPane().getComponents();
		for (Component container : components) {
			if (container instanceof JPanel) {
				JPanel panel = (JPanel) container;
				for (Component component : panel.getComponents()) {
					if (component instanceof JButton) {
						JButton button = (JButton) component;
						button.addActionListener(this);
					}
				}
			}
		}
		getConnectionjdbc();
		try {
			Afficher();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	/*
	 * public void charger() throws IOException { 
	 * BufferedReader reader = new BufferedReader(new FileReader("Catalogue.txt")); 
	 * String line;
	 * while((line=reader.readLine()) != null) { 
	 * Produit p = new Produit(); 
	 * String[] split = line.split("-");
	 * p.setCode(Integer.parseInt(split[0]));
	 * p.setDesignation(split[1]); p.setPrix(Double.parseDouble(split[3]));
	 * p.setQuantite(Integer.parseInt(split[3])); produits.add(p); } reader.close();
	 * System.out.println(produits); }
	 */

	private void getConnectionjdbc() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/catalogue", "root", "");
			st = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			rs = st.executeQuery("SELECT * FROM PRODUIT");
			rs.next();

		} catch (ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void Afficher() throws SQLException {
		txtCode.setText(Integer.toString(rs.getInt(1)));
		txtDesignation.setText(rs.getString(2));
		txtPrix.setText(Double.toString(rs.getDouble(3)));
		txtQuantite.setText(Integer.toString(rs.getInt(4)));
	}

	private void activated(boolean v) {
		// Buttons
		btnAjouter.setEnabled(v);
		btnModifier.setEnabled(v);
		btnSupprimer.setEnabled(v);
		btnValider.setEnabled(!v);
		// TextFields
		txtCode.setEditable(!v);
		txtDesignation.setEditable(!v);
		txtPrix.setEditable(!v);
		txtQuantite.setEditable(!v);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clicked = (JButton) e.getSource();
		if (clicked == btnAjouter) {
			mode = "Ajout";
			activated(false);
			txtCode.setText("");
			txtDesignation.setText("");
			txtPrix.setText("");
			txtQuantite.setText("");
			txtCode.requestFocus();
		} else if (clicked == btnModifier) {
			mode = "Modifier";
			activated(false);
			txtCode.requestFocus();
		} else if (clicked == btnSupprimer) {
			int rep = JOptionPane.showConfirmDialog(this, "Etes-vous sur de vouloir supprimer ce Produit ?",
					"Confirmation de suppression", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (rep == JOptionPane.YES_OPTION) {
				try {
					st = connection.createStatement();
					int sup = st.executeUpdate("delete from produit where code =" + Integer.parseInt(txtCode.getText()));
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (clicked == btnValider) {
			activated(true);
			try {
				if (mode.equals("Ajout")) {
					st = connection.createStatement();
					int rep = st.executeUpdate("insert into produit values (" + Integer.parseInt(txtCode.getText())
							+ ",'" + txtDesignation.getText() + "'," + Double.parseDouble(txtPrix.getText()) + ","
							+ Integer.parseInt(txtQuantite.getText()) + ")");
				} else if (mode.equals("Modifier")) {
					st = connection.createStatement();
					int update = st.executeUpdate(
							"UPDATE PRODUIT SET designation='"
									+ txtDesignation.getText() + "',prix=" + Double.parseDouble(txtPrix.getText())
									+ ",quantite=" + Integer.parseInt(txtQuantite.getText())+" WHERE code=" + Integer.parseInt(txtCode.getText())+";");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		} else if (clicked == btnFirst) {
			try {
				rs.first();
				Afficher();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (clicked == btnNext) {
			try {
				rs.next();
				if(rs.isAfterLast()) {
					rs.first();					
				}
				Afficher();
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (clicked == btnPrevious) {
			try {
				rs.previous();
				if(rs.isBeforeFirst())
					rs.last();
				Afficher();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (clicked == btnLast) {
			try {
				rs.last();
				Afficher();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

	}
}
