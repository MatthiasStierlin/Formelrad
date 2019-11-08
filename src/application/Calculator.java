package application;

/**
 * Calculates the formula wheel
 * @author Carlo Schmid, Matthias Stierlin
 * @version 08.11.2019
 */
public class Calculator {
	private double power; //P
	private double voltage; //U
	private double current; //I
	private double resistance; //R
	
	public Calculator(double power, double voltage, double current, double resistance) {
		super();
		this.power = power;
		this.voltage = voltage;
		this.current = current;
		this.resistance = resistance;
	}
	
	public double getPower() {
		return power;
	}
	
	public double getVoltage() {
		return voltage;
	}

	public double getCurrent() {
		return current;
	}

	public double getResistance() {
		return resistance;
	}

	@Override
	public String toString() {
		return "Calculator [power=" + power +
				", voltage=" + voltage +
				", current=" + current +
				", restistance="	+ resistance + "]";
	}

	public void calculate() {

	}
}
