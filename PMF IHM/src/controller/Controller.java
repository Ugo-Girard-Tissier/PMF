package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Imodel;
import view.Iview;

public class Controller implements Icontroller {

	private final Iview view;
	private final Imodel model;

	public Controller(final Iview view, final Imodel model) {
		this.view = view;
		this.model = model;
	}

	public void start() {

		model.getArduino().initialize();

		view.getFrame().getLoadPanel().go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setBlock(1);
				model.getThreadArduino().envoi = 2;
			}
		});

		view.getFrame().getIhmPanel().send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.getThreadArduino().envoi = (byte) (Integer.parseInt(view.getFrame().getIhmPanel().orderText.getText()) + 100);
				
			}
		});
		
		
		view.getFrame().getIhmPanel().start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.getThreadArduino().envoi = 2;
				
			}
		});
		
		
		view.getFrame().getIhmPanel().stop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.getThreadArduino().envoi = 1;
				
				for (int i= 0; i < 10; i ++) {
					model.getArduino().temperature = 10000;
					model.getArduino().humidite = 10000;
					model.getArduino().rosee = 1000;
					
					
					try {
						Thread.sleep(200);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				
			}
		});

		
		view.sleepHome();
		model.getThreadArduino().start();
		System.out.println("System run");
	}

	public Iview getView() {
		return view;
	}

	public Imodel getModel() {
		return model;
	}
}
