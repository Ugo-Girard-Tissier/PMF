package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Imodel;
import view.Iview;

public class Controller implements Icontroller {

	private final Iview view;
	private final Imodel model;

	public String envoiConsigne = "17";

	public Controller(final Iview view, final Imodel model) {
		super();
		this.view = view;
		this.model = model;
	}

	public void start() {


		view.getFrame().getPan2().envoyer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				envoiConsigne = view.getFrame().getPan2().consigneTexte.getText();

				for (int i = 0; i < 5; i++) {
					model.getArduino().writeData(Integer.parseInt(envoiConsigne));

					try {
						Thread.sleep(500);
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					System.out.println(envoiConsigne);
				}

			}
		});

		System.out.println("System run");

		// attent que l'utilisateur est cliqué sur "start"
		view.sleepHome();

		// lance la communication avec l'arduino
		model.start();

	}

	public Iview getView() {
		return view;
	}

	public Imodel getModel() {
		return model;
	}
}
