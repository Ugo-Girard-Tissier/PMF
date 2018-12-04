package model;

import model.Imodel;

public class ThreadArduino extends Thread {

	private Imodel model;

	/** this constructor define a thread (his name) */
	public ThreadArduino(String name, Imodel model_p) {
		super(name);
		this.model = model_p;
	}

	public void run() {

		int i = 0;

		while (true) {

			/*model.getData().getTemperature()[i] = model.getArduino().temperature;
			model.getData().getHumidite()[i] = model.getArduino().humidite;*/

			model.getData().setTemperature_inst(model.getArduino().temperature);
			model.getData().setHumidite_inst(model.getArduino().humidite);
			model.getData().setRosee(model.getArduino().rosee);

			System.out.println("temperature" + " " + model.getData().getTemperature_inst());
			System.out.println("humidite" + " " + model.getData().getHumidite_inst());
			System.out.println("rosée" + " " + model.getData().getRosee());

			model.update();
			model.getData().setTemps(model.getData().getTemps() + 1);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (model.getData().getTemps() == 60) {
				model.getData().setTemps(0);
				model.setMask(1);
			}

			if (i == 400) {
				i = 0;
			}

			i++;

		}
	}

}
