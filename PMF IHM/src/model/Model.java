package model;


import java.util.Observable;


public class Model extends Observable implements Imodel {

	
	private Arduino arduino;
	private Donnees donnees;
	private thread_arduino thread_arduino = new thread_arduino ("thread_arduino", this) ;
	
	public Model () {
		
		setArduino(new Arduino ());
		setDonnees(new Donnees());
		update();
		
	}

	
	
	public void start () {
		
		String hello = "hello";
		
		
	    arduino.initialize();
	    
	    
	    String start_p = "startOk";
	    
	    while (arduino.start.equals(start_p) != true) {
	    	arduino.send(hello.getBytes()); //start
	    	System.out.println(arduino.start);
	    }
	    System.out.println("hello");
	    
	    thread_arduino.run();
	    
	   
	}
	
	
	
	public void update()
	{
		this.setChanged();
        this.notifyObservers();
	}
	
	
	
	public void sendArduino (byte[] msg) {
		arduino.send(msg);
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
	
	
	
}
