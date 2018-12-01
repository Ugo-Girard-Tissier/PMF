package model;

public interface Imodel {
	
	public Arduino getArduino();
	public void setArduino(Arduino arduino);
	public void start ();
	public void update();
	
	public Donnees getDonnees();
	public void setDonnees(Donnees donnees);
	
	public int getMasque();
	public void setMasque(int masque);
	
}
