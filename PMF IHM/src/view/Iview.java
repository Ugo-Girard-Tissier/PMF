package view;

import java.util.Observer;

public interface Iview {

	public void sleepHome();

	public void initialization();

	public void update();

	public Observer getObserver();

	public Frame getFrame();

	public void setFrame(Frame frame_p);

	public int getBlock();

	public void setBlock(int block);
}
