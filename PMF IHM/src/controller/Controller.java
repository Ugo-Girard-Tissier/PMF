package controller;

import model.Imodel;
import view.Iview;

public class Controller implements Icontroller {

	
	 private final Iview  view;
	 private final Imodel model;
	 
	 
	 
	 public Controller (final Iview view, final Imodel model) {
	 super();
     this.view = view;
     this.model = model;
	 }
	
	 
	 public void start()  {
		 
		System.out.println("System run");
		
	    //attent que l'utilisateur est cliqué sur "start"	
		view.sleepHome();
		
		
		//lance la communication avec l'arduino
		model.start();
		
	 }


	 
	 
	public Iview getView() {
		return view;
	}


	public Imodel getModel() {
		return model;
	}
}
