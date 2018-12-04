package view;

import java.awt.Color;
import java.util.Observer;

import javax.swing.JFrame;

import model.Imodel;

public class Frame extends JFrame {

	private static final long serialVersionUID = 1L;

	private LoadPanel loadPanel;
	private IHMPanel ihmPanel;

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

		this.loadPanel = new LoadPanel(model);

		this.ihmPanel = new IHMPanel(model);

		this.setContentPane(this.loadPanel);
		this.requestFocus();

		this.setVisible(true);
	}

	public final Observer getObserverIhm() {
		return this.getIhmPanel();
	}

	public LoadPanel getLoadPanel() {
		return loadPanel;
	}

	public void setLoadPanel(LoadPanel pan) {
		loadPanel = pan;
	}

	public IHMPanel getIhmPanel() {
		return ihmPanel;
	}

	public void setIhmPanel(IHMPanel pan2) {
		ihmPanel = pan2;
	}

}
