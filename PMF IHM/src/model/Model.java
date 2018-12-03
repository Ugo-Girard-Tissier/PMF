package model;


import java.util.Observable;


public class Model extends Observable implements Imodel {

	
	private Arduino arduino;
	private Data data;
	private ThreadArduino threadArduino; 
	
	private int mask = 0;
	
	
	public Model () {
		
		setArduino(new Arduino ());
		setData(new Data());
		setThreadArduino(new ThreadArduino ("thread_arduino", this));
		
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
	    
	   
	    threadArduino.run();
	    
	   
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



	public Data getData() {
		return data;
	}



	public void setData(Data donnees) {
		this.data = donnees;
	}
	
	
	public int getMask() {
		return mask;
	}



	public void setMask(int mask) {
		this.mask = mask;
	}

	public ThreadArduino getThreadArduino() {
		return threadArduino;
	}

	public void setThreadArduino(ThreadArduino threadArduino) {
		this.threadArduino = threadArduino;
	}
	
	
}
