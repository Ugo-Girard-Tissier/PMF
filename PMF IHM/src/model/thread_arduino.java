package model;

import model.Imodel;
public class thread_arduino extends Thread {

	Imodel model;
	
	/** this constructor define a thread (his name) */
	public thread_arduino(String name, Imodel model_p) {
		super(name);
		this.model = model_p;
	}

	public void run() {

		int i = 0;
		
		
		while (true) {

			model.getDonnees().temperature[i] = model.getArduino().temperature;
			model.getDonnees().humidite[i] = model.getArduino().humidite;
			
			
			model.getDonnees().temperature_inst= model.getArduino().temperature;
			model.getDonnees().humidite_inst = model.getArduino().humidite;
			
			System.out.println("temperature" + " "+ model.getDonnees().temperature_inst);
			
			model.update();
			
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			
			if (i == 400) {
				i = 0;
			}
			
			i++;
			
		}
	}

}
