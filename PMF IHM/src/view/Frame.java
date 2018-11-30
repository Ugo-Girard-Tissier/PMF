package view;

import java.util.Observer;

import javax.swing.JFrame;

import model.Model;


public class Frame extends JFrame  
{

	private static final long serialVersionUID = 1L;

	private Panel Pan;
	/** This constructor set the size of the home window, his color and put a panel into it*/
	public Frame (Model model) {
		
		
		this.setTitle("Home");
	    this.setSize(1600, 1000);
	    this.setLocationRelativeTo(null);
	    this.setResizable(false);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
	    
	    this.Pan = new Panel (model);
	    this.setContentPane(this.Pan);
	    
	    this.setVisible(true);
	}
	
	
	
    public final Observer getObserver() {
        return this.getPan();
    }

	public Panel getPan() {
		return Pan;
	}

	public void setPan(Panel pan) {
		Pan = pan;
	}
	
}
