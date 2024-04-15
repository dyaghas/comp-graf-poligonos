package model;

import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;

import entity.Drawing;

public class Model {
	
	Drawing drawing = new Drawing(3, 10);
	
	public Model() {
	}
	
	public void updatePointsQuantity(int pointsQuantity) {
		drawing.updatePointsQuantity(pointsQuantity);
	}
	
	public Shape makeTransformations(
			Point2D.Double t,  // valor da transformação de translação
			double angle,  // valor do angulo de rotação
			double radiusX,
			double radiusY
			) {
		
		Point2D.Double centralPoint = drawing.getPolygonCentralPoint();

		
		AffineTransform transformation = new AffineTransform();

		transformation.preConcatenate(AffineTransform.getTranslateInstance(-centralPoint.x, -centralPoint.y));
		// Transformação de rotação
		transformation.preConcatenate(AffineTransform.getRotateInstance(angle));
		// Transformação de escala
		transformation.preConcatenate(AffineTransform.getScaleInstance(radiusX, radiusY));
		transformation.preConcatenate(AffineTransform.getTranslateInstance(centralPoint.x, centralPoint.y));
		// Transformação de Translação
		transformation.preConcatenate(AffineTransform.getTranslateInstance(t.x, t.y));

		return transformation.createTransformedShape(drawing);
		
		
	}
	
	public Drawing getDrawing() {
		return drawing;
	}

}
