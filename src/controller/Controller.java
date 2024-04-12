package controller;

import java.awt.Shape;
import java.awt.geom.Point2D;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import model.Model;
import view.View;

public class Controller {
	
	View view;
	Model model;
	
	public Controller() {
		model = new Model();
		view = new View(model.getDrawing());
		
		view.addListenerSlider(new changeSlider());
	}
	
	class changeSlider implements ChangeListener{

		@Override
		public void stateChanged(ChangeEvent e) {
			int pointsQuantity = view.getValueQuantity();
			model.updatePointsQuantity(pointsQuantity);

			Point2D.Double t = view.getValuePosition();
			double a = view.getValueRotation();
			int radiusX = view.getValueRadiusX();
			int radiusY = view.getValueRadiusY();
			
			Shape drawing = model.makeTransformations(t, a, radiusX, radiusY);
			
			view.update(drawing);
			
		}
		
	}
	

}
