package view;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Imodel;

public class IHMPanel extends JPanel implements Observer {

	private static final long serialVersionUID = 1L;

	private Imodel model;

	public int drawLigne = 0;
	public int change_back = 0;
	public int drawData = 0;
	public int drawPoints = 0;
	public int draw_back = 1;
	public int initEnd = 0;

	public int counterInitX = 100;
	public int counterInitY = 700;

	public int counterPointX = -700;
	public int conterPointYTemp = 700;
	public int counterPointYHum = 700;

	public Label order;
	public Label temperature;
	public Label humidity;
	public Label rosee;

	public Label temperatureMax;
	public Label humidityMax;
	public Label tempTimeMax;
	public Label tempHumMax;

	public final JTextField orderText;
	public Button send;

	/**
	 * This constructor create a button into the panel and load an image into it
	 */
	public IHMPanel(Imodel model) {

		this.setLayout(null);

		this.setModel(model);

		temperature = new Label("Température :");
		humidity = new Label("Humidité :");
		rosee = new Label("Pas de condensation :");
		temperatureMax = new Label("30°C");
		humidityMax = new Label("100 %");
		tempTimeMax = new Label("60 s");
		tempHumMax = new Label("60 s");
		order = new Label("Consigne :");

		orderText = new JTextField(2);
		send = new Button("Envoyer");

		order.setBounds(100, 800, 100, 50);
		order.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		order.setBackground(Color.cyan);
		order.setAlignment(Label.CENTER);

		temperature.setBounds(350, 20, 150, 50);
		temperature.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		temperature.setBackground(Color.yellow);
		temperature.setAlignment(Label.CENTER);

		humidity.setBounds(1150, 20, 150, 50);
		humidity.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		humidity.setBackground(Color.yellow);
		humidity.setAlignment(Label.CENTER);
		
		rosee.setBounds(900, 800, 200, 50);
		rosee.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		rosee.setBackground(Color.yellow);
		rosee.setAlignment(Label.CENTER);

		temperatureMax.setBounds(80, 50, 50, 50);
		temperatureMax.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		temperatureMax.setBackground(Color.black);
		temperatureMax.setAlignment(Label.CENTER);
		temperatureMax.setForeground(Color.black);

		humidityMax.setBounds(880, 50, 50, 50);
		humidityMax.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		humidityMax.setBackground(Color.black);
		humidityMax.setAlignment(Label.CENTER);
		humidityMax.setForeground(Color.black);

		tempTimeMax.setBounds(715, 675, 50, 50);
		tempTimeMax.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		tempTimeMax.setBackground(Color.black);
		tempTimeMax.setAlignment(Label.CENTER);
		tempTimeMax.setForeground(Color.black);

		tempHumMax.setBounds(1515, 675, 50, 50);
		tempHumMax.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		tempHumMax.setBackground(Color.black);
		tempHumMax.setAlignment(Label.CENTER);
		tempHumMax.setForeground(Color.black);

		orderText.setText("17");
		orderText.setBounds(210, 800, 100, 50);
		orderText.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		orderText.setBackground(Color.cyan);
		orderText.setHorizontalAlignment(JTextField.CENTER);
		orderText.setBorder(null);

		send.setBounds(340, 800, 100, 50);
		send.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		send.setBackground(Color.cyan);

		add(order);
		add(orderText);
		add(send);
		add(temperature);
		add(humidity);
		add(rosee);
		add(temperatureMax);
		add(humidityMax);
		add(tempTimeMax);
		add(tempHumMax);
	}

	public final void update(final Observable observable, final Object object) {
		this.repaint();
	}


	public void paintComponent(Graphics g) {

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 150, 50);

		if (draw_back == 1) {

			g.setColor(Color.BLACK);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			draw_back = 0;
		}

		if (drawLigne == 1) {
			g.setColor(Color.white);

			g.drawLine(100, 700, counterInitX, 700);
			g.drawLine(100, 700, 100, counterInitY);

			g.drawLine(900, 700, 800 + counterInitX, 700);
			g.drawLine(900, 700, 900, counterInitY);
		}

		if (drawPoints == 1) {

			g.setColor(Color.white);
			g.fillRect(counterPointX, 698, 5, 5);
			g.fillRect(800 + counterPointX, 698, 5, 5);

			g.fillRect(98, conterPointYTemp, 5, 5);
			g.fillRect(898, counterPointYHum, 5, 5);

		}

		if (drawData == 1) {

			g.setColor(Color.red);
			g.fillRect(model.getData().getTemps() * 10 + 100, 700 - echelleTemp(model.getData().getTemperature_inst()),
					5, 5);

			g.fillRect(model.getData().getTemps() * 10 + 900, 700 - echelleHum(model.getData().getHumidite_inst()), 5,
					5);
			
			
			if (model.getData().getTemperature_inst() <= model.getData().getRosee() )
				g.setColor(Color.red);
			else 
				g.setColor(Color.GREEN);
			
			
			g.fillOval(1150, 785, 80, 80);

		}

		if (model.getMask() == 1) {

			g.setColor(Color.black);
			g.fillRect(105, 95, 705, 595);
			g.fillRect(905, 95, 1200, 595);

			model.setMask(0);
		}

		if (initEnd == 1) {

			g.setColor(Color.white);
			g.drawLine(100, 700, 700, 700);
			g.drawLine(100, 700, 100, 100);
			g.drawLine(900, 700, 1500, 700);
			g.drawLine(900, 700, 900, 100);

			g.fillRect(200, 698, 5, 5);
			g.fillRect(300, 698, 5, 5);
			g.fillRect(400, 698, 5, 5);
			g.fillRect(500, 698, 5, 5);
			g.fillRect(600, 698, 5, 5);
			g.fillRect(700, 698, 5, 5);

			g.fillRect(1000, 698, 5, 5);
			g.fillRect(1100, 698, 5, 5);
			g.fillRect(1200, 698, 5, 5);
			g.fillRect(1300, 698, 5, 5);
			g.fillRect(1400, 698, 5, 5);
			g.fillRect(1500, 698, 5, 5);

			g.fillRect(98, 100, 5, 5);
			g.fillRect(98, 200, 5, 5);
			g.fillRect(98, 300, 5, 5);
			g.fillRect(98, 400, 5, 5);
			g.fillRect(98, 500, 5, 5);
			g.fillRect(98, 600, 5, 5);

			g.fillRect(898, 100, 5, 5);
			g.fillRect(898, 250, 5, 5);
			g.fillRect(898, 400, 5, 5);
			g.fillRect(898, 550, 5, 5);
			g.fillRect(898, 700, 5, 5);

		}

	}

	public int echelleTemp(float temp) {

		float resultat_float = temp * 10 * 2;

		int resultat_int = Math.round(resultat_float);

		return resultat_int;
	}

	public int echelleHum(int hum) {

		float modificateur = (float) 6 / 10;

		float resultat_float = hum * 10 * modificateur;

		int resultat_int = Math.round(resultat_float);

		return resultat_int;
	}

	public Imodel getModel() {
		return model;
	}

	public void setModel(Imodel model2) {
		this.model = model2;
	}

}
