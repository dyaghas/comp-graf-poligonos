package model;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import entity.Drawing;

public class Model {
	
	Drawing drawing = new Drawing(3, 100);
	
	public Model() {
	}
	
	public void updatePointsQuantity(int pointsQuantity) {
		drawing.updatePointsQuantity(pointsQuantity);
	}
	
	public Shape makeTransformations(
			Point2D.Double t,  // valor da transformação de translação
			double angle,  // valor do angulo de rotação
			int radius
			) {
		
		Point2D.Double centralPoint = drawing.getCentralPoint();
		
		AffineTransform transformation = new AffineTransform();
		
		// Transformação de rotação
		transformation.preConcatenate(AffineTransform.getTranslateInstance(-centralPoint.x, -centralPoint.y));
		transformation.preConcatenate(AffineTransform.getRotateInstance(angle));
		transformation.preConcatenate(AffineTransform.getTranslateInstance(centralPoint.x, centralPoint.y));

		double scaleX = 1.1;  // Suponha que originalRadius seja o raio original do desenho
		double scaleY = 1.1;
		transformation.preConcatenate(AffineTransform.getScaleInstance(scaleX, scaleY));

		// Transformação de Translação
		transformation.preConcatenate(AffineTransform.getTranslateInstance(t.x, t.y));
		
		Shape transformedShape = transformation.createTransformedShape(drawing);

		return transformedShape;
		
		
	}
	
	public Drawing getDrawing() {
		return drawing;
	}
	
	
	

}
