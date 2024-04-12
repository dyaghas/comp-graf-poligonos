package view;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.text.DecimalFormat;

public class Buttons extends JPanel {

	//Definição dos sliders e labels de alteração do polígono
	JSlider sliderX = new JSlider(-300, 300, 0);
	JSlider sliderY = new JSlider(-300, 300, 0);
	JSlider sliderRadiusX = new JSlider(1, 30, 1);
	JSlider sliderRadiusY = new JSlider(1, 30, 1);
	JSlider sliderPoints = new JSlider(3, 50, 3);
	double rotationFactor = 1000; //Nível de precisão da rotação do polígono em pi/rad
	JSlider sliderRot = new JSlider(0, (int) (2 * Math.PI * rotationFactor), 0);
	JLabel labelX = new JLabel("Posição X: 0");
	JLabel labelY = new JLabel("Posição Y: 0");
	JLabel labelRadiusX = new JLabel("Raio coordenada X: 1");
	JLabel labelRadiusY = new JLabel("Raio coordenada Y: 1");
	JLabel labelPoints = new JLabel("Pontos na figura: 3");
	JLabel labelRot = new JLabel("Rotação: 0");
	
	public Buttons() {
		setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		addVerticalStrut();
		addLabel(labelX);
		addSlider(sliderX);
		addVerticalStrut();

		addLabel(labelY);
		addSlider(sliderY);
		addVerticalStrut();

		addLabel(labelRadiusX);
		addSlider(sliderRadiusX);
		addVerticalStrut();

		addLabel(labelRadiusY);
		addSlider(sliderRadiusY);
		addVerticalStrut();

		addLabel(labelPoints);
		addSlider(sliderPoints);
		addVerticalStrut();

		addLabel(labelRot);
		addSlider(sliderRot);
		addVerticalStrut();

		addListenerSlider(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				updateLabels();
			}
		});
	}
	
	public int getValueSliderX() {
		return sliderX.getValue();
	}

	public int getValueSliderY() {
		return sliderY.getValue();
	}

	public int getValueSliderRadiusX() {
		return sliderRadiusX.getValue();
	}

	public int getValueSliderRadiusY() {
		return sliderRadiusY.getValue();
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
		sliderRadiusX.addChangeListener(cl);
		sliderRadiusY.addChangeListener(cl);
		sliderPoints.addChangeListener(cl);
		sliderRot.addChangeListener(cl);
	}

	//Atualiza os labels toda vez que uma alteração é feita no polígono
	private void updateLabels() {
		labelX.setText("Posição X: " + sliderX.getValue());
		labelY.setText("Posição Y: " + sliderY.getValue());
		labelRadiusX.setText("Raio coordenada X: " + sliderRadiusX.getValue());
		labelRadiusY.setText("Raio coordenada Y: " + sliderRadiusY.getValue());
		labelPoints.setText("Pontos na figura: " + sliderPoints.getValue());
		labelRot.setText("Rotação: " + twoDigitFormat(getValueSliderRot() * 180/Math.PI));
	}

	// Define o layout de todos os labels
	private void addLabel(JLabel label) {
		label.setAlignmentX(Component.LEFT_ALIGNMENT);
		add(label);
	}

	//Define o layout de todos os sliders
	private void addSlider(JSlider slider) {
		slider.setAlignmentX(Component.CENTER_ALIGNMENT);
		add(slider);
	}

	//Espaçamento vertical entre sliders e labels
	private void addVerticalStrut() {
		add(Box.createVerticalStrut(30));
	}

	private String twoDigitFormat(double value) {
		DecimalFormat decimalFormat = new DecimalFormat("0.00");
		String formattedValue = decimalFormat.format(value);
		return formattedValue;
	}

}
