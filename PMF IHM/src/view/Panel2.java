package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Model;

public class Panel2 extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private Model model;

	public int dessine_ligne = 0;
	public int change_back = 0;
	private int dessine_donnees = 0;
	public int dessine_point = 0;

	public int compteur_init_x;
	public int compteur_init_y = 700;
	public int compteur_point_x = -700;
	public int compteur_point_y = -700;


	public Label consigne;
	public final JTextField consigneTexte;
	public Button envoyer;

	/** This constructor create a button into the panel and load an image into it */
	public Panel2(Model model_p) {

		this.setLayout(null);

		this.setModel(model_p);

		consigne = new Label("Consigne: ");
		consigneTexte = new JTextField(2);
		envoyer = new Button("Envoyer");

		consigne.setBounds(100, 800, 100, 50);
		consigne.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		consigne.setBackground(Color.cyan);
		consigne.setAlignment(Label.CENTER);

		consigneTexte.setText("17");
		consigneTexte.setBounds(210, 800, 100, 50);
		consigneTexte.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		consigneTexte.setBackground(Color.cyan);
		consigneTexte.setHorizontalAlignment(JTextField.CENTER);
		consigneTexte.setBorder(null);

		envoyer.setBounds(340, 800, 100, 50);
		envoyer.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		envoyer.setBackground(Color.cyan);

		add(consigne);
		add(consigneTexte);
		add(envoyer);
	}

	public final void update(final Observable observable, final Object object) {
		this.repaint();
	}

	/**
	 * paint the Panel create (set the size) and add the button create previously
	 */
	public void paintComponent(Graphics g) {

		if (dessine_ligne == 1) {
			g.setColor(Color.white);

			g.drawLine(100, 700, compteur_init_x, 700);
			g.drawLine(100, 700, 100, compteur_init_y);

			g.drawLine(900, 700, 800 + compteur_init_x, 700);
			g.drawLine(900, 700, 900, compteur_init_y);
		}

		if (dessine_point == 1) {

			g.setColor(Color.white);
			g.fillRect(compteur_point_x, 698, 5, 5);
			g.fillRect(800 + compteur_point_x, 698, 5, 5);

			g.fillRect(98, compteur_point_y, 5, 5);
			g.fillRect(898, compteur_point_y, 5, 5);

		}

		if (dessine_donnees == 1) {

			g.setColor(Color.red);
			g.fillRect(model.getDonnees().temps * 10 + 100, 700 - echelle(model.getDonnees().temperature_inst), 5, 5);

			g.fillRect(model.getDonnees().temps * 10 + 900, 700 - echelle(model.getDonnees().humidite_inst), 5, 5);

			g.setColor(Color.red);
			g.fillRect(model.getDonnees().temps * 10 + 100, 700 - echelle(model.getDonnees().temperature_inst), 5, 5);

			g.fillRect(model.getDonnees().temps * 10 + 100, 700 - echelle(model.getDonnees().humidite_inst) + 900, 5,
					5);
		}

		if (model.getMasque() == 1) {

			g.setColor(Color.black);
			g.fillRect(105, 95, 705, 595);
			g.fillRect(905, 95, 1200, 595);

			model.setMasque(0);
		}
	}

	public int echelle(float temp) {

		int resultat;

		temp = temp * 10;

		resultat = Math.round(temp);

		return resultat;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public int getDessine_donnees() {
		return dessine_donnees;
	}

	public void setDessine_donnees(int dessine_donnees) {
		this.dessine_donnees = dessine_donnees;
	}
}
