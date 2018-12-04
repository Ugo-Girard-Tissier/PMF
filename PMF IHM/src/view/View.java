package view;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import model.Imodel;

public class View extends Observable implements Iview, Observer {

	private Frame frame;
	private int block = 0;

	public View(Imodel model) {

		this.setFrame(new Frame(model));
	}

	public void sleepHome() {

		while (block == 0) {

			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		frame.setTitle("PMF");
		this.deleteObservers();

		this.addObserver(frame.getObserverIhm());
		frame.setContentPane(frame.getIhmPanel());

		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		frame.setVisible(true);

		update();
		initialization();
	}

	public void initialization() {

		frame.getIhmPanel().drawLigne = 1;

		int i;

		// ligne x
		for (i = 100; i <= 700; i++) {
			frame.getIhmPanel().counterInitX = i;

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
			frame.getIhmPanel().counterInitY = i;

			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			update();
		}

		frame.getIhmPanel().drawLigne = 0;
		frame.getIhmPanel().drawPoints = 1;

		// point x
		for (i = 100; i <= 700; i += 100) {
			frame.getIhmPanel().counterPointX = i;
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

			frame.getIhmPanel().conterPointYTemp = i;
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

			frame.getIhmPanel().counterPointYHum = i;
			update();
		}

		frame.getIhmPanel().temperatureMax.setForeground(Color.WHITE);
		frame.getIhmPanel().humidityMax.setForeground(Color.WHITE);
		frame.getIhmPanel().tempTimeMax.setForeground(Color.white);
		frame.getIhmPanel().tempHumMax.setForeground(Color.white);
		frame.getIhmPanel().drawPoints = 0;
		frame.getIhmPanel().drawData = 1;

		update();
		frame.getIhmPanel().initEnd = 1;
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

	public void update() {
		this.setChanged();
		this.notifyObservers();
		this.clearChanged();
	}

	public void update(Observable o, Object arg) {
		update();
	}

	public int getBlock() {
		return block;
	}

	public void setBlock(int block) {
		this.block = block;
	}
}
