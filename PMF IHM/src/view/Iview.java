package view;

import java.util.Observer;

import model.Imodel;

public interface Iview {
	
    public void runBoardHome (Imodel model);
	public void sleepHome ();
	
	public Observer getObserver();

	public Frame getFrame();
	public void setFrame(Frame frame_p);
}
