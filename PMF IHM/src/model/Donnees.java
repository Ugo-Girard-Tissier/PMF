package model;

public class Donnees {

	
	public float temperature [] = new float [400];
	public int humidite [] = new int [400];
	public float rosee;

	
	
	public float temperature_inst;
	public int humidite_inst;
	
	
	
	public float[] getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature[]) {
		this.temperature = temperature;
	}

	public int[] getHumidite() {
		return humidite;
	}

	public void setHumidite(int humidite[]) {
		this.humidite = humidite;
	}

	public float getRosee() {
		return rosee;
	}

	public void setRosee(float rosee) {
		this.rosee = rosee;
	}
	
	
	
	
}