package model;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import gnu.io.SerialPortEvent;
import gnu.io.SerialPortEventListener;
import java.util.Enumeration;

public class Arduino implements SerialPortEventListener {

	// public String start = "";
	public float temperature = -10000;
	public int humidite = -10000;
	public float rosee;

	SerialPort serialPort;
	/** The port we’re normally going to use. */
	private static final String PORT_NAMES[] = { "COM7", // Windows };
	};

	private BufferedReader input;
	private OutputStream output;
	private static final int TIME_OUT = 2000;
	private static final int DATA_RATE = 19200;

	public void initialize() {
		System.setProperty("gnu.io.rxtx.SerialPorts", "COM7");
		CommPortIdentifier portId = null;
		Enumeration<?> portEnum = CommPortIdentifier.getPortIdentifiers();

		while (portEnum.hasMoreElements()) {
			CommPortIdentifier currPortId = (CommPortIdentifier) portEnum.nextElement();

			for (String portName : PORT_NAMES) {
				if (currPortId.getName().equals(portName)) {
					portId = currPortId;
					break;
				}
			}
		}

		if (portId == null) {
			System.out.println("Could not find COM7 port. ");
			return;
		}

		try {
			serialPort = (SerialPort) portId.open(this.getClass().getName(), TIME_OUT);

			serialPort.disableReceiveTimeout();
			serialPort.enableReceiveThreshold(1);
			serialPort.setSerialPortParams(DATA_RATE, SerialPort.DATABITS_8, SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);

			input = new BufferedReader(new InputStreamReader(serialPort.getInputStream()));
			setOutput(serialPort.getOutputStream());

			serialPort.addEventListener(this);
			serialPort.notifyOnDataAvailable(true);

			System.out.println("connecté arduino");

		} catch (Exception e) {
			System.err.println(e.toString());
		}
	}

	public synchronized void close() {

		if (serialPort != null) {
			serialPort.removeEventListener();
			serialPort.close();
		}
	}

	public void writeData(int data) {
		try {
			output.write(data);
			output.flush();

		} catch (Exception e) {
			System.out.println("pas envoyé");
		}
	}

	public synchronized void serialEvent(SerialPortEvent oEvent) {

		if (oEvent.getEventType() == SerialPortEvent.DATA_AVAILABLE) {
			try {
				String inputLine = null;

				if (input.ready()) {
					inputLine = input.readLine();
					// System.out.println(inputLine);
					protocol(inputLine);

				}

			} catch (Exception e) {
				System.err.println(e.toString());
			}
		}
		// Ignore all the other eventTypes, but you should consider the other ones.
	}

	private void protocol(String inputLine) {

		String temp = "T";
		String hum = "H";
		String rosee = "R";

		if (inputLine.substring(0, 1).equals(temp) == true) {
			this.temperature = Float.parseFloat(inputLine.substring(1, 5));
		} else if (inputLine.substring(0, 1).equals(hum) == true) {
			this.humidite = Integer.parseInt(inputLine.substring(1, 3));
		} else if (inputLine.substring(0, 1).equals(rosee) == true) {

			this.rosee = Float.parseFloat(inputLine.substring(1, 5));
		}

	}

	public void setOutput(OutputStream output) {
		this.output = output;
	}

}
