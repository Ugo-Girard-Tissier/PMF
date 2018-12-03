package view;

import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class BoutonAction extends JButton implements MouseListener {

	private static final long serialVersionUID = 1L;
	private int choice = 0;

	/** set the size, color and message of the button */
	public BoutonAction(String str, int i, int y) {

		super(str);
		this.setFont(new Font("Serif", Font.PLAIN, 54));
		this.setBounds(i, y, 250, 80);
		//this.setBackground(Color.cyan);
		this.addMouseListener(this);

	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//this.setBackground(Color.orange);
		this.setChoice(1);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		//this.setBackground(Color.green);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//this.setBackground(Color.cyan);
	}

	public int getChoice() {
		return choice;
	}

	public void setChoice(int choice) {
		this.choice = choice;
	}

}
