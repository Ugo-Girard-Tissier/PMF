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

		int i;

		for (i = 50; i != 500; i++) {
			frame.getPan().compteur_init_x = i;
			update();

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		for (i = 500; i != 50; i--) {
			frame.getPan().compteur_init_y = i;
			update();

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("hehe");
		
		Label namelabel = new Label("User ID: ", Label.RIGHT);
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

		frame.getPan().add(namelabel);
		frame.getPan().add(userText);
		frame.getPan().add(passwordLabel);
		frame.getPan().add(passwordText);
		frame.getPan().add(loginButton);
		// mainFrame.setVisible(true);

		frame.getPan().updateUI();
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
