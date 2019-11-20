package application;

/**
 * Calculates the formula wheel
 * @author Carlo Schmid, Matthias Stierlin
 * @version 08.11.2019
 */
public class Calculator {
	private double power; //P Watt
	private double voltage; //U Spannung
	private double current; //I Stromstaerke
	private double resistance; //R Widerstand
	private boolean tooManyValues = false;
	
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

	public boolean getTooManyValues() {
		return tooManyValues;
	}

	@Override
	public String toString() {
		return "Calculator [power=" + power +
				", voltage=" + voltage +
				", current=" + current +
				", restistance="	+ resistance + "]";
	}

	public void calculate() {
		int setVariablesCount = 0;
		if(power != 0) setVariablesCount++;
		if(voltage != 0) setVariablesCount++;
		if(current != 0) setVariablesCount++;
		if(resistance != 0) setVariablesCount++;
		if(setVariablesCount > 2) {
			tooManyValues = true;
			return;
		}
		if(power + voltage == 0) {
			power = PFromRAndI();
			voltage = UFromRAndI();
		}
		else if(power + current == 0) {
			power = PFromUAndR();
			current = IFromUAndR();
		}
		else if(power + resistance == 0) {
			power = PFromUAndI();
			resistance = RFromUAndI();
		}
		else if(voltage + current == 0) {
			voltage = UFromPAndR();
			current = IFromPAndR();
		}
		else if(voltage + resistance == 0) {
			voltage = UFromPAndI();
			resistance = RFromPAndI();
		}
		else if(current + resistance == 0) {
			current = IFromPAndU();
			resistance = RFromPAndU();
		}
	}

	private double PFromUAndI() {
		System.out.println("The power will be calculated from voltage(u) and current(i).");
		return voltage * current;
	}

	private double PFromRAndI() {
		System.out.println("The wattage will be calculated from resistance(r) and current(i).");
		return resistance * Math.pow(current, 2);
	}
	
	private double PFromUAndR() {
		System.out.println("The wattage will be calculated from the voltage(u) and resistance(r).");
		return Math.pow(voltage, 2) / resistance;
	}

	private double UFromRAndI() {
		System.out.println("The voltage will be calculated from the resistance(r) and current(i).");
		return resistance * current;
	}

	private double UFromPAndI() {
		System.out.println("The voltage will be calculated from the power(p) and current(i).");
		return power / current;
	}

	private double UFromPAndR() {
		System.out.println("The voltage will be calculated from the power(p) and resistance(r).");
		return Math.sqrt(power * resistance);
	}

	private double RFromUAndI() {
		System.out.println("The resistance will be calculated from the voltage(u) and current(i).");
		return voltage / current;
	}

	private double RFromPAndI() {
		System.out.println("The resistance will be calculated from the power(p) and current(i).");
		return power / Math.pow(current, 2);
	}

	private double RFromPAndU() {
		System.out.println("The resistance will be calculated from the power(p) and voltage(u).");
		return Math.pow(voltage, 2) / power;
	}

	private double IFromUAndR() {
		System.out.println("The current will be calculated from the power(u) and voltage(r).");
		return voltage * resistance;
	}

	private double IFromPAndU() {
		System.out.println("The current will be calculated from the power(p) and voltage(u).");
		return power / voltage;
	}
	
	private double IFromPAndR() {
		System.out.println("The current will be calculated from the power(p) and resistance(r).");
		return Math.sqrt(power / resistance);
	}
}
