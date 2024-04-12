package view;

import java.awt.Shape;
import java.awt.geom.Point2D;

import javax.swing.event.ChangeListener;

public class View {
	
	Window window;
	
	public View(Shape drawing) {
		window = new Window(drawing);
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

}
