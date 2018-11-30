package view;

import java.util.Observer;

import model.Model;

public interface Iview {
	
    public void runBoardHome (Model model);
	public void sleepHome ();
	public void update();
	
	public Observer getObserver();

	public Frame getFrame();
	public void setFrame(Frame frame_p);
}
