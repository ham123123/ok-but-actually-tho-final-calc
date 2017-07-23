package ButtonClicked;

import javax.swing.JTextField;

public class Subtraction implements ButtonClicked {
	private boolean operationClicked;
	private int count;
	private int operation;
	private JTextField result;
	private double num;

	public Subtraction (boolean opClicked, int count, int operation, JTextField result, double num) {
		this.operationClicked = opClicked;
		this.count = count;
		this.operation = operation;
		this.result = result;
		this.num = num;
		
	}

	public void execute() {
		operationClicked = true;
		String text = result.getText();
		if (storedOperationIsAddition()) {
			add(text);
			operation = 2;
		} else if (storedOperationIsDivision()) {
			divide(text);
			operation = 2;
		} else if (storedOperationIsMultiplication()) {
			multiply(text);
			operation = 2;
		} else if (storedOperationIsEquality()) {
			count = 0;
			subtract(text);
		} else {                                      // if there is repetitive subtraction
			subtract(text);
		}
	}
	
	private void multiply(String text) {
		if (count == 0) {                                 // to store the first number
			num = Double.parseDouble(text);
			count = 1;
		} else if (count != 0) {                          // to store second number and multiply
			double newNum = Double.parseDouble(text);
			num = num * newNum;
			result.setText("" + num);
		}
		operation = 4;                         // storing given multiplication value to perform function at next button
	}

	/* This method divides two consecutively inserted numbers 
	 * after the division button is clicked
	 */
	
	private void divide(String text) {
		if (count == 0) {
			num = Double.parseDouble(text);
			count = 1;
		} else if (count != 0) {                          // to store second number and multiply
			double newNum = Double.parseDouble(text);
			num = num / newNum;
			result.setText("" + num);
		}
		operation = 3;                             // storing given division value to perform function at next button
	}

	/* This method adds two consecutively inserted numbers after the addition
	 * button is clicked
	 */
	
	private void add(String text) {
		if (count == 0) {
			num = Double.parseDouble(text);
			count = 1;
		} else if (count != 0) {                         // to store second number and add
			double newNum = Double.parseDouble(text);
			num = num + newNum;
			result.setText("" + num);
		}
		operation = 1;                           // storing given addition value to perform function at next button
	}
	
	/* This method subtracts two consecutively inserted numbers after the subtraction
	 * button is clicked
	 */
	
	private void subtract(String text) {
		if (count == 0) {
			num = Double.parseDouble(text);
			count = 1;
		} else if (count != 0) {                         // to store second number and subtract
			double newNum = Double.parseDouble(text);
			num = num - newNum;
			result.setText("" + num);
		}
		operation = 2;                          // storing given subtraction value to perform function at next button
	}
	
	private boolean storedOperationIsMultiplication() {
		return operation == 4;
	}

	// This method returns whether the operation is division, presented by the value of 3

	private boolean storedOperationIsDivision() {
		return operation == 3;
	}

	// This method returns whether the operation is addition, presented by the value of 1

	private boolean storedOperationIsAddition() {
		return operation == 1;
	}
	
	private boolean storedOperationIsEquality() {
		return operation == 0;
	}
	
	@Override
	public int getOperation() {
		// TODO Auto-generated method stub
		return operation;
	}

	@Override
	public double getNum() {
		// TODO Auto-generated method stub
		return num;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public JTextField getResultText() {
		// TODO Auto-generated method stub
		return result;
	}

	@Override
	public boolean getOperationClicked() {
		// TODO Auto-generated method stub
		return operationClicked;
	}


}
