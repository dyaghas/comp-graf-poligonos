package view;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JPanel;

public class Panel extends JPanel {
	
	Shape drawing;
	
	public Panel(Shape drawing) {
		this.drawing = drawing;
	}
	
	public void update(Shape drawing) {
		this.drawing = drawing;
		repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;
		
		this.setBackground(new Color(230, 230, 230));
		
		g2d.setStroke(new BasicStroke(100));
		
		g2d.fill(drawing);
		
	}

}
