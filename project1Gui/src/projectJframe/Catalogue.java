package projectJframe;

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

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		try {
			charger();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Afficher(0);
	}

	/*
	 * public void charger() throws IOException { BufferedReader reader = new
	 * BufferedReader(new FileReader("Catalogue.txt")); String line;
	 * while((line=reader.readLine()) != null) { Produit p = new Produit(); String[]
	 * split = line.split("-"); p.setCode(Integer.parseInt(split[0]));
	 * p.setDesignation(split[1]); p.setPrix(Double.parseDouble(split[3]));
	 * p.setQuantite(Integer.parseInt(split[3])); produits.add(p); } reader.close();
	 * System.out.println(produits); }
	 */

	public void charger() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader("Catalogue.txt"));
		String line;
		while ((line = reader.readLine()) != null) {
			Produit p = new Produit();
			StringTokenizer st = new StringTokenizer(line, "-");
			p.setCode(Integer.parseInt(st.nextToken()));
			p.setDesignation(st.nextToken());
			p.setPrix(Double.parseDouble(st.nextToken()));
			p.setQuantite(Integer.parseInt(st.nextToken()));
			produits.add(p);
		}
		reader.close();
	}

	public void Afficher(int index) {
		txtCode.setText(Integer.toString(produits.get(index).getCode()));
		txtDesignation.setText(produits.get(index).getDesignation());
		txtPrix.setText(Double.toString(produits.get(index).getPrix()));
		txtQuantite.setText(Integer.toString(produits.get(index).getQuantite()));

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
			Produit p = new Produit();
			p.setCode(Integer.parseInt(txtCode.getText()));
			p.setDesignation(txtDesignation.getText());
			p.setPrix(Double.parseDouble(txtPrix.getText()));
			p.setQuantite(Integer.parseInt(txtQuantite.getText()));
			produits.add(p);
		} else if (clicked == btnSupprimer) {
			int rep = JOptionPane.showConfirmDialog(this, "Etes-vous sur de vouloir supprimer ce Produit ?",
					"Confirmation de suppression", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			if (rep == JOptionPane.YES_OPTION) {
				for(int i=0;i<produits.size();i++) {
					if(produits.get(i).getCode() == Integer.parseInt(txtCode.getText())) {
						produits.remove(i);
					}
				}
			}
		} else if (clicked == btnValider) {
			activated(true);
			Produit p = new Produit();
			p.setCode(Integer.parseInt(txtCode.getText()));
			p.setDesignation(txtDesignation.getText());
			p.setPrix(Double.parseDouble(txtPrix.getText()));
			p.setQuantite(Integer.parseInt(txtQuantite.getText()));
			produits.add(p);
		} else if (clicked == btnFirst) {
			Afficher(0);
		} else if (clicked == btnNext) {
			
		} else if (clicked == btnPrevious) {
			
		} else if (clicked == btnLast) {
			Afficher(produits.size()-1);
		}

	}
}
