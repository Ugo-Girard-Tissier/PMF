package main;

import controller.Controller;
import model.Model;
import view.View;

public abstract class Main {

	public static void main(String[] args) {
		
		 
		
	
		final Model model = new Model();
		
		
		final View view = new View(model);
		
		model.addObserver(view.getObserver());
		
		
		final Controller controller = new Controller(view, model);
		 
		 
		 controller.start();

	}

}
