package view;
import controller.Controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.Point2D;

import javax.swing.JFrame;
import javax.swing.event.ChangeListener;

public class Window extends JFrame {
	
	Panel panel;
	Buttons buttons = new Buttons();
	Controller controller;
	
	public Window(Shape drawing, Controller controller) {
		super("Transformação de polígono");
		this.controller = controller;
		
		panel = new Panel(drawing);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		panel.setPreferredSize(new Dimension(620, 620));
		
		add(panel, BorderLayout.CENTER);
		add(buttons, BorderLayout.LINE_START);

		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				super.componentResized(e);
				// Atualiza o tamanho do painel de acordo com o redimencionamento da janela
				panel.updateWindowSize(getSize());
					controller.updateRadius();
			}
		});

		setVisible(true);
		pack();
		
	}
	
	public void addListenerSlider(ChangeListener cl) {
		buttons.addListenerSlider(cl);
	}
	
	public void update(Shape drawing) {
		panel.update(drawing);
	}
	
	public Point2D.Double getValueSliderPosition() {
		return new Point2D.Double(
				buttons.getValueSliderX(),
				buttons.getValueSliderY());
	}

	public int getValueSliderRadiusX() {
		return buttons.getValueSliderRadiusX();
	}

	public int getValueSliderRadiusY() {
		return buttons.getValueSliderRadiusY();
	}
	
	public int getValueSliderQuantity() {
		return buttons.getValueSliderPoints();
	}

	public double getValueSliderRotation() {
		return buttons.getValueSliderRot();
	}

	public boolean getBoolAxisSymetry() {
		return buttons.getBoolAxisSymetry();
	}

	public int getPanelHeight() {
		return panel.getHeight();
	}

	public int getPanelWidth() {
		return panel.getWidth();
	}
	
}
