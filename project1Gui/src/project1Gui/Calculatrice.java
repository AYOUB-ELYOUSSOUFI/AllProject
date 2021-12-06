package project1Gui;
import java.awt.*;

public class Calculatrice extends Frame{
	
	private Label lblNombre1,lblNombre2, lblResultat;
	private TextField txtNombre1, txtNombre2, txtresultat;
	private Button btnCalculer;
	
	public Calculatrice() {
		super("Calculatrice");
		lblNombre1 = new Label("Nombre 1 :");
		lblNombre2 = new Label("Nombre 2 :");
		lblResultat = new Label("Resultalt est :");
		
		txtNombre1 = new TextField("",10);
		txtNombre2 = new TextField("",10);
		txtresultat = new TextField("",10);
		
		btnCalculer = new Button("Calculer");
		
		this.setSize(500, 300);
		this.setLayout(new FlowLayout());
		
		this.add(lblNombre1); this.add(txtNombre1);
		this.add(lblNombre2); this.add(txtNombre2);
		this.add(btnCalculer);
		this.add(lblResultat); this.add(txtresultat);
		
		this.setVisible(true);
		
		
	}
	
} 
