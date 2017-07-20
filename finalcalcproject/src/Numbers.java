
public class Numbers {
	private double number1;
	private double number2;
	private String operation;
	
	public Numbers (double num, double newNum, String newOperation) {
		number1 = num;
		number2 = newNum;
		operation = newOperation;
	}
	
	public double getNumber1() { return number1; }
	public double getNumber2() { return number2; }
	public String getOperation() { return operation; }

}
