package entity;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class Drawing extends Path2D.Double {

	double radius;
	Point2D.Double center;
	int pointsQuantity;

	public Drawing(int pointsQuantity, int radius) {
		super();
		this.pointsQuantity = pointsQuantity;
		center = new Point2D.Double(310, 310);
		this.radius = radius;

		updateCircle();
	}

	public void updatePointsQuantity(int pointsQuantity) {
		this.pointsQuantity = pointsQuantity;
		updateCircle();
	}

	private void updateCircle() {
		reset();
		double minInterval = 0, maxInterval = 2*Math.PI;
		double increment = maxInterval/ pointsQuantity;

		Point2D.Double initialPoint = pointCalc(minInterval);

		moveTo(initialPoint.x, initialPoint.y);

		for(int i = 1; i< pointsQuantity; i++) {
			double t = i*increment;
			Point2D.Double p = pointCalc(t);
			lineTo(p.x, p.y);
		}

		closePath();

	}

	private Point2D.Double pointCalc(double t){
		double x = center.x + radius *Math.cos(t);
		double y = center.y + radius *Math.sin(t);
		return new Point2D.Double(x, y);
	}
	
	public Point2D.Double getCentralPoint() {
		Rectangle2D.Double rectangle = (Rectangle2D.Double)getBounds2D();

		Point2D.Double corner = new Point2D.Double(rectangle.x, rectangle.y);

		Point2D.Double centralPoint = new Point2D.Double(
				corner.x + rectangle.width/2,
				corner.y + rectangle.height/2
				);

		return centralPoint;
	}



}
