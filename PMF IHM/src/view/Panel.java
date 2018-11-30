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
	private int init = 0;
	public int compteur_init_x = 0;
	public int compteur_init_y = 500;

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
		/*Label namelabel = new Label("User ID: ", Label.RIGHT);
		Label passwordLabel = new Label("Password: ", Label.CENTER);
		final TextField userText = new TextField(6);
		final TextField passwordText = new TextField(6);
		passwordText.setEchoChar('*');

		Button loginButton = new Button("Login");

		/*
		 * loginButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { String data = "Username: " +
		 * userText.getText(); data += ", Password: " + passwordText.getText();
		 * statusLabel.setText(data); } });
		 */

		/*this.add(namelabel);
		this.add(userText);
		this.add(passwordLabel);
		this.add(passwordText);
		this.add(loginButton);*/
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

			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());

			g.setColor(Color.white);

			g.drawLine(50, 500, compteur_init_x, 500);
			g.drawLine(50, 500, 50, compteur_init_y);

			g.drawLine(750, 500, 750 + compteur_init_x, 500);
			g.drawLine(750, 500, 750, compteur_init_y);
			// g.drawLine(500, 500, compteur_init_x, 500);
		}

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

}
