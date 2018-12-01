package view;

import java.awt.Color;
import java.awt.FlowLayout;
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

	private BoutonAction button_home;

	private Image img;


	/** This constructor create a button into the panel and load an image into it */
	public Panel(Model model_p) {

		this.setModel(model_p);
		this.setLayout(null);

		this.button_home = new BoutonAction("Démarrer", 1000, 450);

		try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/main_menu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		;

		button_home.setFocusPainted(false);
		this.add(button_home);
	}

	public final void update(final Observable observable, final Object object) {
		this.repaint();
	}

	/**
	 * paint the Panel create (set the size) and add the button create previously
	 */
	public void paintComponent(Graphics g) {

		g.drawImage(this.img, 0, 0, this.getWidth(), this.getHeight(), this);

	}

	
	public BoutonAction getButton_choice_1_home() {
		return button_home;
	}

	public void setButton_choice_1_home(BoutonAction button_choice_1_home) {
		this.button_home = button_choice_1_home;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}
}
