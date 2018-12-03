package view;


import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Imodel;

public class View extends Observable implements Iview, Observer {

	private Frame frame;

	public View(Imodel model) {

		this.runBoardHome(model);
		
		this.addObserver(frame.getObserver());
	}

	public void update() {
		this.setChanged();
		this.notifyObservers();
		this.clearChanged();
	}

	public void runBoardHome(Imodel model) {
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

		frame.getPan().back = 1;
		frame.getPan().repaint();
		
		frame.setTitle("PMF");
		this.deleteObservers();
		
		
		this.addObserver(frame.getObserver2());
		frame.setContentPane(frame.getPan2());
		
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		frame.setVisible(true);
		
		
		
		update();
		init();
	}

	public void init() {

		
		frame.getPan2().dessine_ligne = 1;
		
		
		int i;

		// ligne x
		for (i = 100; i <= 700; i++) {
			frame.getPan2().compteur_init_x = i;

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			update();
		}

		// ligne y
		for (i = 700; i >= 100; i--) {
			frame.getPan2().compteur_init_y = i;

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			update();
		}

		frame.getPan2().dessine_ligne = 0;
		frame.getPan2().dessine_point = 1;

		// point x
		for (i = 100; i <= 700; i += 100) {
			frame.getPan2().compteur_point_x = i;
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			update();
		}

		// point y temp
		for (i = 700; i >= 100; i -= 100) {

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			frame.getPan2().compteur_point_y = i;
			update();
		}
		
		
		// point y hum
		for (i = 700; i >= -150; i -= 150) {

			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			frame.getPan2().compteur_point_y_hum = i;
			update();
		}

		frame.getPan2().temperature_max.setForeground(Color.WHITE);
		frame.getPan2().humidite_max.setForeground(Color.WHITE);
		frame.getPan2().temps_temp_max.setForeground(Color.white);
		frame.getPan2().temps_hum_max.setForeground(Color.white);
		frame.getPan2().dessine_point = 0;
		frame.getPan2().setDessine_donnees(1);

		update();
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
