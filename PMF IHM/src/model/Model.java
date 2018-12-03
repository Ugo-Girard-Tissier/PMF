package model;


import java.util.Observable;


public class Model extends Observable implements Imodel {

	
	private Arduino arduino;
	private Donnees donnees;
	private thread_arduino thread_arduino = new thread_arduino ("thread_arduino", this) ;
	
	private int masque = 0;
	
	
	public Model () {
		
		setArduino(new Arduino ());
		setDonnees(new Donnees());
		update();
	}
	
	public void start () {
		
	
	    arduino.initialize();
	    
	    
	    for (int i = 0; i < 10; i ++) {
	    	
	    	
	    	arduino.writeData(17);
	    	
	    	try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    }
	    System.out.println("good");
	    
	   
	    thread_arduino.run();
	    
	   
	}
	
	
	
	public void update()
	{
		this.setChanged();
        this.notifyObservers();
        this.clearChanged();
	}
	
	
	
	
	public Arduino getArduino() {
		return arduino;
	}


	public void setArduino(Arduino arduino) {
		this.arduino = arduino;
	}



	public Donnees getDonnees() {
		return donnees;
	}



	public void setDonnees(Donnees donnees) {
		this.donnees = donnees;
	}
	
	
	public int getMasque() {
		return masque;
	}



	public void setMasque(int masque) {
		this.masque = masque;
	}
	
	
}
