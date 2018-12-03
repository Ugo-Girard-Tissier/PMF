package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Imodel;

public class Panel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private Imodel model;

	private BoutonAction button_home;

	private Image img;

	public int back = 0;

	/** This constructor create a button into the panel and load an image into it */
	public Panel(Imodel model) {

		this.setModel(model);
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
		
		if (back == 1) {
			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
		}

	}

	
	public BoutonAction getButton_choice_1_home() {
		return button_home;
	}

	public void setButton_choice_1_home(BoutonAction button_choice_1_home) {
		this.button_home = button_choice_1_home;
	}

	public Imodel getModel() {
		return model;
	}

	public void setModel(Imodel model2) {
		this.model = model2;
	}
}
