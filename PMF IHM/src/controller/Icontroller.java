package controller;

import model.Imodel;
import view.Iview;

public interface Icontroller {

	public void start();

	public Imodel getModel();

	public Iview getView();

}
