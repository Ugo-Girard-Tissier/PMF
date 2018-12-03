package view;

import java.awt.Color;
import java.util.Observer;

import javax.swing.JFrame;

import model.Imodel;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private Panel Pan;
	private Panel2 Pan2;

	/**
	 * This constructor set the size of the home window, his color and put a panel
	 * into it
	 */
	public Frame(Imodel model) {

		this.setTitle("Home");
		this.setSize(1600, 1000);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.BLACK);


		this.Pan = new Panel(model);
		
		this.Pan2 = new Panel2(model);
		
		this.setContentPane(this.Pan);
		this.requestFocus();

		
		this.setVisible(true);
	}
	
	


	public final Observer getObserver() {
		return this.getPan();
	}

	public final Observer getObserver2() {
		return this.getPan2();
	}
	
	public Panel getPan() {
		return Pan;
	}

	public void setPan(Panel pan) {
		Pan = pan;
	}

	public Panel2 getPan2() {
		return Pan2;
	}

	public void setPan2(Panel2 pan2) {
		Pan2 = pan2;
	}

}
