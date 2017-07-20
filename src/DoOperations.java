import javax.swing.JTextField;


public class DoOperations {
	
	int count;
	double num;
	JTextField result;
	int operation;
	
	public DoOperations(double nm, int cnt, JTextField rst, int op) {
		num = nm;
		count = cnt;
		result = rst;
		operation = op;
	}
	
	public void doStoredOperationAndFindResult() {
		String text = result.getText();
		if (storedOperationIsAddition()) {                    // if equation was addition
			add(text);
			operation = 0;
		} else if (storedOperationIsSubtraction()) {             // if equation was subtraction
			subtract(text);
			operation = 0;
		} else if (storedOperationIsDivision()) {             // if equation was division
			divide(text);
			operation = 0;
		} else if (storedOperationIsMultiplication()) {             // if equation was multiplication
			multiply(text);
			operation = 0;                       // reset at value of equals
		}
		count = 0;
	}
	
	public void doStoredOperationIfAnyThenMultiply() {
		String text = result.getText();
		if (storedOperationIsAddition()) {                    // if earlier stored button was addition
			add(text);
			operation = 4;
		} else if (storedOperationIsSubtraction()) {             // if earlier stored button was subtraction
			subtract(text);
			operation = 4;
		} else if (storedOperationIsDivision()) {             // if earlier stored button was division
			divide(text);
			operation = 4;                      // reset value of multiplication to store for next button
		} else if (storedOperationIsEquality()) {            // if earlier stored button was equals
			count = 0;                          // reset values after using the equals button
			multiply(text);
		} else {
			multiply(text);                     // if there is repetitive multiplication
		}
	}

	/* This method performs the earlier stored equation, 
	 * then stores a new division equation
	 */
	
	public void doStoredOperationIfAnyThenDivide() {
		String text = result.getText();
		if (storedOperationIsAddition()) {
			add(text);
			operation = 3;
		} else if (storedOperationIsSubtraction()) {
			subtract(text);
			operation = 3;
		} else if (storedOperationIsMultiplication()) {               // if earlier stored button was multiplication
			multiply(text);
			operation = 3;
		} else if (storedOperationIsEquality()) {
			count = 0;
			divide(text);
		} else {                                   // if there is repetitive division
			divide(text);
		}
	}

	/* This method performs the earlier stored equation, 
	 * then stores a new subtraction equation
	 */
	
	public void doStoredOperationIfAnyThenSubtract() {
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

	/* This method performs the earlier stored equation, 
	 * then stores a new addition equation
	 */
	
	public void doStoredOperationIfAnyThenAdd() {
		String text = result.getText();
		if (storedOperationIsSubtraction()) {
			subtract(text);
			operation = 1;
		} else if (storedOperationIsDivision()) {
			divide(text);
			operation = 1;
		} else if (storedOperationIsMultiplication()) {
			multiply(text);
			operation = 1;
		} else if (storedOperationIsEquality()) {
			count = 0;
			add(text);
		} else {                                    // if there is repetitive addition
			add(text);
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

	// This method returns whether the operation is subtraction, presented by the value of 2

	private boolean storedOperationIsSubtraction() {
		return operation == 2;
	}

	// This method returns whether the operation is addition, presented by the value of 1

	private boolean storedOperationIsAddition() {
		return operation == 1;
	}
	
	private boolean storedOperationIsEquality() {
		return operation == 0;
	}

	public int getOperation() {
		return operation;
	}

	public double getNum() {
		return num;
	}

	public int getCount() {
		return count;
	}

	public String getResultText() {
		return result.getText();
	}

}
