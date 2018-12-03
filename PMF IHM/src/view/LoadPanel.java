package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import model.Imodel;

public class LoadPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private Imodel model;
	private Image img;
	public Button go;


	/** This constructor create a button into the panel and load an image into it */
	public LoadPanel(Imodel model) {

		this.setModel(model);
		this.setLayout(null);

		//this.button_home = new ActionButton("Démarrer", 1000, 450);

		try {
			this.img = ImageIO.read(getClass().getResourceAsStream("/main_menu.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		;
		
		go = new Button("Démarrer");
		
		go.setBounds(1000, 450, 250, 80);
		go.setFont(new Font("Serif", Font.PLAIN, 54));
		go.setBackground(Color.cyan);


		this.add(go);
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

	public Imodel getModel() {
		return model;
	}

	public void setModel(Imodel model2) {
		this.model = model2;
	}
}
