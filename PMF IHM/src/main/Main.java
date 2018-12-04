package main;

import java.util.Observable;

import controller.Controller;
import controller.Icontroller;
import model.Imodel;
import model.Model;
import view.Iview;
import view.View;

public abstract class Main {

	public static void main(String[] args) {

		final Imodel model = new Model();

		final Iview view = new View(model);

		((Observable) model).addObserver(view.getObserver());

		final Icontroller controller = new Controller(view, model);

		controller.start();

	}

}
