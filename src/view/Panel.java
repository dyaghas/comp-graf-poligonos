package view;
import java.awt.*;
import java.awt.geom.AffineTransform;

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

	public void updateWindowSize(Dimension newSize) {
		// Atualiza as dimensões da janela
		this.setPreferredSize(newSize);
		revalidate();
		repaint(); // Reflete as mudanças na janela
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		this.setBackground(new Color(230, 230, 230));

		double scaleX = (double) getWidth() / 620; // 620 é a largura inicial
		double scaleY = (double) getHeight() / 620; // 620 é a altura inicial
		AffineTransform transform = AffineTransform.getScaleInstance(scaleX, scaleY);
		g2d.transform(transform);
		
		g2d.setStroke(new BasicStroke(100));
		
		g2d.fill(drawing);
		
	}

}
