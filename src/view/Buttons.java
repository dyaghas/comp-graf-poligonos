package view;
import java.awt.Label;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class Buttons extends JPanel {
	
	JSlider sliderX = new JSlider(-300, 300, 0);
	JSlider sliderY = new JSlider(-300, 600, 0);
	JSlider sliderRadius = new JSlider(1, 200, 100);
	JSlider sliderPoints = new JSlider(3, 50, 3);
	
	double rotationFactor = 1000;
	JSlider sliderRot = new JSlider(0, (int)(2*Math.PI* rotationFactor), 0);
	
	public Buttons() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		add(new Label("Posição X"));
		add(sliderX);
		add(new Label("Posição Y"));
		add(sliderY);
		add(new Label("Raio"));
		add(sliderRadius);
		add(new Label("Pontos na figura"));
		add(sliderPoints);
		add(new Label("Rotação"));
		add(sliderRot);
	}
	
	public int getValueSliderX() {
		return sliderX.getValue();
	}
	
	public int getValueSliderY() {
		return sliderY.getValue();
	}

	public int getValueSliderRadius() {
		return sliderRadius.getValue();
	}

	public int getValueSliderPoints() {
		return sliderPoints.getValue();
	}
	
	public double getValueSliderRot() {
		return (double) sliderRot.getValue()/(double) rotationFactor;
	}
	
	public void addListenerSlider(ChangeListener cl) {
		sliderX.addChangeListener(cl);
		sliderY.addChangeListener(cl);
		sliderRadius.addChangeListener(cl);
		sliderPoints.addChangeListener(cl);
		sliderRot.addChangeListener(cl);
	}
	
	
	

}
