package view;

import java.awt.Button;
import java.awt.Label;
import java.awt.TextField;
import java.util.Observable;
import java.util.Observer;

import model.Model;

public class View extends Observable implements Iview, Observer {

	private Frame frame;

	public View(Model model_p) {

		this.runBoardHome(model_p);
		this.addObserver(frame.getObserver());
	}

	public void update() {
		this.setChanged();
		this.notifyObservers();
	}

	public void runBoardHome(Model model) {
		this.setFrame(new Frame(model));
	}

	public void sleepHome() {

		while ((frame.getPan().getButton_choice_1_home().getChoice() == 0)) {

			try {
				Thread.sleep(0);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		frame.setTitle("PMF");
		frame.getPan().remove(this.frame.getPan().getButton_choice_1_home());
		frame.getPan().change_back = 1;

		init();

		this.update();
	}

	public void init() {

		Label passwordLabel = new Label("Password: ", Label.CENTER);
		final TextField passwordText = new TextField(6);

		Button loginButton = new Button("Login");

		/*
		 * loginButton.addActionListener(new ActionListener() { public void
		 * actionPerformed(ActionEvent e) { String data = "Username: " +
		 * userText.getText(); data += ", Password: " + passwordText.getText();
		 * statusLabel.setText(data); } });
		 */

		frame.getPan().add(passwordLabel);
		frame.getPan().add(passwordText);
		frame.getPan().add(loginButton);
		// mainFrame.setVisible(true);

		frame.getPan().updateUI();

		int i;

		//ligne x
		for (i = 100; i != 700; i++) {
			frame.getPan().compteur_init_x = i;
			update();

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		i = 0;
		

		// ligne y
		for (i = 700; i != 100; i--) {
			frame.getPan().compteur_init_y = i;
			update();

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			frame.getPan().setDessine_donnees(1);
		}

		
		frame.getPan().dessine_point = 1;
		
		// point x
		for (i = 200; i != 800; i = i + 100) {
			frame.getPan().compteur_point_x = i;
			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			update();
		}
		
		//point y
		for (i = 600; i != 0; i = i - 100) {


			try {
				Thread.sleep(30);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			frame.getPan().compteur_point_y = i;
			update();
		}

		frame.getPan().dessine_point = 0;
		frame.getPan().setDessine_donnees(1);
		
		
		
	}

	
	
	public final Observer getObserver() {
		return this;
	}

	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame_p) {
		frame = frame_p;
	}

	@Override
	public void update(Observable o, Object arg) {
		update();
	}

}
