package model;

public interface Imodel {

	public Arduino getArduino();

	public void setArduino(Arduino arduino);

	public void update();

	public Data getData();

	public void setData(Data data);

	public int getMask();

	public void setMask(int mask);

	public ThreadArduino getThreadArduino();

	public void setThreadArduino(ThreadArduino threadArduino);

}
