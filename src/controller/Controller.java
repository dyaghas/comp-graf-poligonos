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
	Point2D.Double t = new Point2D.Double(0.0, 0.0);
	double a = 0;
	private double radiusX = 1;
	private double radiusY = 1;
	
	public Controller() {
		model = new Model();
		view = new View(model.getDrawing(), this);
		
		view.addListenerSlider(new changeSlider());
	}
	
	class changeSlider implements ChangeListener{

		@SuppressWarnings("SuspiciousNameCombination")
        @Override
		public void stateChanged(ChangeEvent e) {
			int pointsQuantity = view.getValueQuantity();
			model.updatePointsQuantity(pointsQuantity);

			t = view.getValuePosition();
			a = view.getValueRotation();
			radiusX = view.getValueRadiusX() * ((double) view.getPanelHeight()/620);
			radiusY = view.getValueRadiusY() * ((double) view.getPanelWidth()/620);
			System.out.println(radiusX + " " + radiusY);

			// Verifica se o checkbox de simetria está selecionado
			if(view.getBoolSimetry()) {
                radiusY = radiusX;
			}

			Shape drawing = model.makeTransformations(t, a, radiusX, radiusY);
			
			view.update(drawing);
			
		}
		
	}

	public void updateRadius() {
		radiusX = view.getValueRadiusX() * ((double) view.getPanelHeight()/620);
		radiusY = view.getValueRadiusY() * ((double) view.getPanelWidth()/620);
		System.out.println(radiusX + " " + radiusY);
		Shape drawing = model.makeTransformations(t, a, radiusX, radiusY);
		view.update(drawing);
	}

}
