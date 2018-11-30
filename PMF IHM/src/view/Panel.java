package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Model;

public class Panel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private Model model;

	private BoutonAction button_choice_1_home;

	private Image img;
	public int change_back = 0;
	private int dessine_donnees = 0;
	private int repaint_back = 0;
	public int dessine_point = 0;
	

	private int init = 0;
	public int compteur_init_x;
	public int compteur_init_y = 700;
	public int compteur_point_x = 200;
	public int compteur_point_y = 600;

	/** This constructor create a button into the panel and load an image into it */
	public Panel(Model model_p) {

		this.setModel(model_p);
		//this.setLayout(null);
		this.button_choice_1_home = new BoutonAction("Start", 480, 850);

		try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/HomeCar.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		;

		this.add(button_choice_1_home);
	}

	public final void update(final Observable observable, final Object object) {
		this.repaint();
	}

	/**
	 * paint the Panel create (set the size) and add the button create previously
	 */
	public void paintComponent(Graphics g) {

		if (change_back == 0)
			g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);
		else if (init == 0) {

			if (repaint_back < 3) {
				g.setColor(Color.BLACK);
				g.fillRect(0, 0, this.getWidth(), this.getHeight());
				this.repaint_back += 1 ;
			}
			

			g.setColor(Color.white);

			g.drawLine(100, 700, compteur_init_x, 700);
			g.drawLine(100, 700, 100, compteur_init_y);
			
			g.drawLine(900, 700, 800 + compteur_init_x, 700);
			g.drawLine(900, 700, 900, compteur_init_y);
			
			if (dessine_point == 1) {
				g.fillRect(compteur_point_x, 698, 5, 5);
				g.fillRect(800 + compteur_point_x , 698, 5, 5);
				
				g.fillRect(100, compteur_point_y, 5, 5);
				g.fillRect(900, compteur_point_y , 5, 5);
				
			}
			
			
			if (dessine_donnees == 0) {
				
				
				g.setColor(Color.red);
				
				
				//temperature
		
				
			}
			
			// g.drawLine(500, 500, compteur_init_x, 500);
		}

	}

	
	
	
	public void echelle () {
		
		
		
		
	}
	
	
	
	public BoutonAction getButton_choice_1_home() {
		return button_choice_1_home;
	}

	public void setButton_choice_1_home(BoutonAction button_choice_1_home) {
		this.button_choice_1_home = button_choice_1_home;
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
