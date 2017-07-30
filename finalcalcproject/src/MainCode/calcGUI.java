package MainCode;
/* This program creates a calculator GUI equipped with an 
 * addition, multiplication, division, and subtraction option.
 */

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ButtonClicked.Addition;
import ButtonClicked.ButtonClicked;
import ButtonClicked.Clear;
import ButtonClicked.Decimal;
import ButtonClicked.Division;
import ButtonClicked.Equation;
import ButtonClicked.Multiplication;
import ButtonClicked.Number;
import ButtonClicked.Subtraction;

public class calcGUI implements ActionListener {
	private static final String OPERATION_DIVISION = "/";
	private static final String OPERATION_MULTIPLICATION = "x";
	private static final String OPERATION_SUBTRACTION = "-";
	private static final String OPERATION_ADDITION = "+";
	private static final String OPERATION_DOT = ".";
	private static final String OPERATION_EQUALS = "=";
	private static final String OPERATION_CLEAR = "Clear";
	private static final List<String> OPERATIONS = 
			Arrays.asList(OPERATION_ADDITION, 
					OPERATION_SUBTRACTION,
					OPERATION_MULTIPLICATION,
					OPERATION_DIVISION, OPERATION_EQUALS, 
					OPERATION_CLEAR, OPERATION_DOT);
	private JTextField result; 
	private HashMap <String, ButtonClicked> commandDictionary;
	private Args variables;
	
	public static void main(String[] args) {
		new calcGUI().init();
	}

	public void init() {
		variables = new Args();
		variables.setCount(0);
		variables.setNum(0.0);
		variables.setOperation(0);
		variables.setOperationClicked(false);
		JFrame frame = new JFrame("Calculator");
		frame.setSize(250, 400);
		JPanel pane = new JPanel(new GridLayout(4, 4));
		addResultFieldAndClearButton(frame);
		addButtons(pane);
		frame.add(pane, "Center");
		frame.setVisible(true);
	}

	private void addResultFieldAndClearButton(JFrame frame) {
		result = new JTextField(16);
		result.setText("");
		variables.setText(result.getText());
		variables.setResult(result);
		frame.add(result, "North");
		JButton clear = new JButton(OPERATION_CLEAR);
		clear.addActionListener(this);
		clear.setBackground(Color.black);
		clear.setForeground(Color.white);
		frame.add(clear, "South");
	}

	// This method adds all the buttons found on the calculator

	private void addButtons(JPanel pane) {
		addNumberButtons(pane, 1, 4);
		addButton(pane, OPERATION_ADDITION);
		addNumberButtons(pane, 4, 7);
		addButton(pane, OPERATION_SUBTRACTION);
		addNumberButtons(pane, 7, 10);
		addButton(pane, OPERATION_MULTIPLICATION);
		addButton(pane, "0");
		addButton(pane, OPERATION_DOT);
		addButton(pane, OPERATION_EQUALS);
		addButton(pane, OPERATION_DIVISION);
	}

	private void addNumberButtons(JPanel pane, int startIndex, int endIndex) {
		for (int i = startIndex; i < endIndex; i++)
			addButton(pane, "" + i);
	}

	private void addButton(JPanel pane, String label) {
		JButton button = new JButton(label);
		button.addActionListener(this);
		button.setBorder(BorderFactory.createEtchedBorder(Color.black, Color.DARK_GRAY));
		button.setBackground(Color.RED);
		button.setForeground(Color.white);
		pane.add(button);
	}

	public void actionPerformed(ActionEvent event) {
		variables.setEvent(event);
		commandDictionary = new HashMap <String, ButtonClicked>();
		fillCommandDictionary(event);
		String text = "";
		if (!isOperation(event)) { 
			text = "number";
		} else {
			text =  event.getActionCommand();
		}
		commandDictionary.get(text).execute();

	}

	private void fillCommandDictionary(ActionEvent ev) {
		commandDictionary.put("+", new Addition (variables));
		commandDictionary.put("-", new Subtraction (variables));
		commandDictionary.put("/", new Division (variables));
		commandDictionary.put("x", new Multiplication (variables));
		commandDictionary.put("=", new Equation (variables));
		commandDictionary.put(".", new Decimal (variables));
		commandDictionary.put("number", new Number (variables));
		commandDictionary.put("Clear", new Clear (variables));
	}


	private boolean isOperation(ActionEvent ev) {
		return OPERATIONS.stream().anyMatch(ev.getActionCommand()::contains);
	}
}
