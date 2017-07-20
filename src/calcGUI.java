/* This program creates a calculator GUI equipped with an 
 * addition, multiplication, division, and subtraction option.
 */


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class calcGUI implements ActionListener {
	
	private JTextField result;              // private field to hold result and inserted numbers
	private boolean operationClicked;       // private field to show if operand was clicked
	private double num;                     // private field to hold initial number
	private int operation;     // private field to assign values to different operands(= 0 + 1 - 2 / 3 x 4)
	private int count;
	//JFrame frame;
	//JPanel pane;
	
	public static void main (String[] args) {
		new calcGUI().init();
	}
	
	/* This method initiates the GUI, it includes creating 
	 * the JFrame of the GUI, adding the text field
	 * and the buttons, and placing them.
	 */
	
	public void init() {
		count = 0;
		num = 0.0;
		operation = 0;
		JFrame frame = new JFrame ("Calculator");
		frame.setSize(250, 400);
		JPanel pane = new JPanel (new GridLayout(4, 4));
		addResultFieldAndClearButton(frame);
		addButtons(pane);
		frame.add(pane, "Center");
		frame.setVisible(true);
	}
		
	private void addResultFieldAndClearButton(JFrame frame) {
		result = new JTextField(16);
		frame.add(result, "North");
		JButton clear = new JButton ("Clear");
		clear.addActionListener(this);
		frame.add(clear,"South");
	}

	// This method adds all the buttons found on the calculator
	
	private void addButtons(JPanel pane) {
		addNumberButtons(pane, 1, 4);
		addButton(pane,  "+");
		addNumberButtons(pane, 4, 7);
		addButton(pane,  "-");
		addNumberButtons(pane, 7, 10);
		addButton(pane,  "x");
		addButton(pane,  "0");
		addButton(pane, ".");
		addButton(pane,  "=");
		addButton(pane,  "/");
	}

	private void addNumberButtons(JPanel pane, int startIndex, int endIndex) {
		for (int i = startIndex; i < endIndex; i ++)
			addButton(pane,  ""+i);
	}

	/* This method waits and responds to an
	 * action to be performed (a button to be pressed)
	 */

	private void addButton(JPanel pane, String label) {
		JButton button = new JButton (label);
		button.addActionListener(this);
		pane.add(button);
	}

	public void actionPerformed(ActionEvent event) {
		RespondToButtonClicks click = new RespondToButtonClicks(event, operationClicked, result);
		DoOperations operations = new DoOperations(num, count, result, operation);
		if (isNumber(event)) {                 // when number is clicked
			click.treatAsNumber();
			operationClicked = click.getOperationStatus();
		} else if (isDecimal(event)) {         // when decimal point is clicked
			click.treatAsDecimal();
			operationClicked = click.getOperationStatus();
		} else if (isAddition(event)) {        // when addition button is clicked
			operationClicked = true;
			operations.doStoredOperationIfAnyThenAdd();
			operation = operations.getOperation();
			num = operations.getNum();
			count = operations.getCount();
			result.setText(operations.getResultText());
		} else if (isSubtraction(event)) {     // when subtraction is clicked
			operationClicked = true;
			operations.doStoredOperationIfAnyThenSubtract();
			operation = operations.getOperation();
			num = operations.getNum();
			count = operations.getCount();
			result.setText(operations.getResultText());
		} else if (isDivision(event)) {        // when division is clicked
			operationClicked = true;
			operations.doStoredOperationIfAnyThenDivide();
			operation = operations.getOperation();
			num = operations.getNum();
			count = operations.getCount();
			result.setText(operations.getResultText());
		} else if (isMultiplication(event)) {  // when multiplication is clicked
			operationClicked = true;
			operations.doStoredOperationIfAnyThenMultiply();
			operation = operations.getOperation();
			num = operations.getNum();
			count = operations.getCount();
			result.setText(operations.getResultText());
		} else if (isEquation(event)) {        // when equals sign is clicked
			operations.doStoredOperationAndFindResult();
			operation = operations.getOperation();
			num = operations.getNum();
			count = operations.getCount();
			result.setText(operations.getResultText());
		} else if (isClear(event)) {
			result.setText("");
			operation = 0;                                         // reset at value of equals
			count = 0;
			operationClicked = true;
		}
		
	}

	// This method returns whether a button is division
	
	private boolean isDivision(ActionEvent ev) {
		return ev.getActionCommand().contains("/");
	}
	
	// This method returns whether a button is multiplication
	
	private boolean isMultiplication(ActionEvent ev) {
		return ev.getActionCommand().contains("x");
	}
	
	// This method returns whether a button is subtraction
	
	private boolean isSubtraction(ActionEvent ev) {
		return ev.getActionCommand().contains("-");
	}

	// This method returns whether a button is addition
	
	private boolean isAddition(ActionEvent ev) {
		return ev.getActionCommand().contains("+");
	}

	// This method returns whether a button is a decimal button
	
	private boolean isDecimal(ActionEvent ev) {
		return ev.getActionCommand().contains(".");
	}
	
	// This method returns whether a button is equals button
	
	private boolean isEquation(ActionEvent ev) {
		return ev.getActionCommand().contains("=");
	}
	
	// This method returns whether a button is the clear button

	private boolean isClear(ActionEvent ev) {
		return ev.getActionCommand().contains("Clear");
	}

	// This method returns whether a button is a number button
	
	public boolean isNumber(ActionEvent ev) {
		List<String> operations = Arrays.asList(
				"+", "-", "x", "/", "=", "Clear", "." );
		return operations.stream()
				.noneMatch(op -> ev.getActionCommand().contains(op));
	}
}

