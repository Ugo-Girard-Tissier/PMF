package model;

public class Data {

	private float temperature[] = new float[400];
	private int humidity[] = new int[400];
	private float rosee;

	private int time = 0;
	private float temperature_inst = 10000;
	private int humidity_inst = 10000;

	public float[] getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature[]) {
		this.temperature = temperature;
	}

	public int[] getHumidite() {
		return humidity;
	}

	public void setHumidite(int humidite[]) {
		this.humidity = humidite;
	}

	public float getRosee() {
		return rosee;
	}

	public void setRosee(float rosee) {
		this.rosee = rosee;
	}

	public int getTemps() {
		return time;
	}

	public void setTemps(int temps) {
		this.time = temps;
	}

	public float getTemperature_inst() {
		return temperature_inst;
	}

	public void setTemperature_inst(float temperature_inst) {
		this.temperature_inst = temperature_inst;
	}

	public int getHumidite_inst() {
		return humidity_inst;
	}

	public void setHumidite_inst(int humidite_inst) {
		this.humidity_inst = humidite_inst;
	}

}
