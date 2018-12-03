package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Imodel;

public class Panel2 extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private Imodel model;

	public int dessine_ligne = 0;
	public int change_back = 0;
	private int dessine_donnees = 0;
	public int dessine_point = 0;
	public int draw_back = 1;

	public int compteur_init_x = 100;
	public int compteur_init_y = 700;

	public int compteur_point_x = -700;
	public int compteur_point_y = 700;
	public int compteur_point_y_hum = 700;

	public Label consigne;
	public Label temperature;
	public Label humidite;

	public Label temperature_max;
	public Label humidite_max;
	public Label temps_temp_max;
	public Label temps_hum_max;

	public final JTextField consigneTexte;
	public Button envoyer;

	/** This constructor create a button into the panel and load an image into it */
	public Panel2(Imodel model) {

		this.setLayout(null);

		this.setModel(model);

		temperature = new Label("Temperature :");
		humidite = new Label("Humidté :");
		temperature_max = new Label("60°");
		humidite_max = new Label("100 %");
		temps_temp_max = new Label("60 s");
		temps_hum_max = new Label("60 s");
		consigne = new Label("Consigne :");
		
		consigneTexte = new JTextField(2);
		envoyer = new Button("Envoyer");

		consigne.setBounds(100, 800, 100, 50);
		consigne.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		consigne.setBackground(Color.cyan);
		consigne.setAlignment(Label.CENTER);

		temperature.setBounds(350, 20, 150, 50);
		temperature.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		temperature.setBackground(Color.yellow);
		temperature.setAlignment(Label.CENTER);

		humidite.setBounds(1150, 20, 150, 50);
		humidite.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		humidite.setBackground(Color.yellow);
		humidite.setAlignment(Label.CENTER);

		temperature_max.setBounds(80, 50, 50, 50);
		temperature_max.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		temperature_max.setBackground(Color.black);
		temperature_max.setAlignment(Label.CENTER);
		temperature_max.setForeground(Color.black);

		humidite_max.setBounds(880, 50, 50, 50);
		humidite_max.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		humidite_max.setBackground(Color.black);
		humidite_max.setAlignment(Label.CENTER);
		humidite_max.setForeground(Color.black);
		
		temps_temp_max.setBounds(715, 675, 50, 50);
		temps_temp_max.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		temps_temp_max.setBackground(Color.black);
		temps_temp_max.setAlignment(Label.CENTER);
		temps_temp_max.setForeground(Color.black);
		
		
		temps_hum_max.setBounds(1515, 675, 50, 50);
		temps_hum_max.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		temps_hum_max.setBackground(Color.black);
		temps_hum_max.setAlignment(Label.CENTER);
		temps_hum_max.setForeground(Color.black);
		

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
		add(temperature);
		add(humidite);
		add(temperature_max);
		add(humidite_max);
		add(temps_temp_max);
		add(temps_hum_max);
	}

	public final void update(final Observable observable, final Object object) {
		this.repaint();
	}

	/**
	 * paint the Panel create (set the size) and add the button create previously
	 */
	public void paintComponent(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 150, 50);
		
		if (draw_back == 1) {

			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			draw_back = 0;
		}

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
			g.fillRect(898, compteur_point_y_hum, 5, 5);

		}

		if (dessine_donnees == 1) {

			g.setColor(Color.red);
			g.fillRect(model.getDonnees().temps * 10 + 100, 700 - echelle(model.getDonnees().temperature_inst), 5, 5);

			if (model.getDonnees().humidite_inst != 10000) {
				g.fillRect(model.getDonnees().temps * 10 + 900, 700 - echelle_hum(model.getDonnees().humidite_inst), 5,
						5);
			}
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

	public int echelle_hum(int hum) {

		float modificateur = (float) 6 / 10;

		float resultat_float = hum * 10 * modificateur;

		int resultat_int = Math.round(resultat_float);

		return resultat_int;
	}

	public Imodel getModel() {
		return model;
	}

	public void setModel(Imodel model2) {
		this.model = model2;
	}

	public int getDessine_donnees() {
		return dessine_donnees;
	}

	public void setDessine_donnees(int dessine_donnees) {
		this.dessine_donnees = dessine_donnees;
	}
}
