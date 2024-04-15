package view;

import controller.Controller;

import java.awt.Shape;
import java.awt.geom.Point2D;

import javax.swing.event.ChangeListener;

public class View {
	
	Window window;
	Controller controller;

	
	public View(Shape drawing, Controller controller) {
		this.controller = controller;
		window = new Window(drawing, controller);
	}
	
	public void update(Shape drawing) {
		window.update(drawing);
	}
	
	public void addListenerSlider(ChangeListener cl) {
		window.addListenerSlider(cl);
	}
	
	public Point2D.Double getValuePosition() {
		return window.getValueSliderPosition();
	}

	public int getValueRadiusX() {
		return window.getValueSliderRadiusX();
	}

	public int getValueRadiusY() {
		return window.getValueSliderRadiusY();
	}

	public int getValueQuantity() {
		return window.getValueSliderQuantity();
	}

	public double getValueRotation() {
		return window.getValueSliderRotation();
	}

	public boolean getBoolSimetry() {
		return window.getBoolAxisSymetry();
	}

	public int getPanelHeight() {
		return window.getPanelHeight();
	}

	public int getPanelWidth() {
		return window.getPanelWidth();
	}

}
