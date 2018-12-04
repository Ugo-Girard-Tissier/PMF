package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Imodel;
import view.Iview;

public class Controller implements Icontroller {

	private final Iview view;
	private final Imodel model;

	private String order = "17";

	public Controller(final Iview view, final Imodel model) {
		this.view = view;
		this.model = model;
	}

	public void start() {

		view.getFrame().getIhmPanel().send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				order = view.getFrame().getIhmPanel().orderText.getText();

				for (int i = 0; i < 5; i++) {
					model.getArduino().writeData(Integer.parseInt(order));

					try {
						Thread.sleep(100);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						System.out.println("impossible d'envoyer");
					}
				}

			}
		});

		view.getFrame().getLoadPanel().go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				view.setBlock(1);
			}
		});

		System.out.println("System run");

		view.sleepHome();
		model.start();

	}

	public Iview getView() {
		return view;
	}

	public Imodel getModel() {
		return model;
	}
}
