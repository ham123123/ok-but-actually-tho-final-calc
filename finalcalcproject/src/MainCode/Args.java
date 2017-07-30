package MainCode;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class Args {
	private boolean operationClicked;
	private JTextField result;
	private ActionEvent event;
	private int count;
	private int operation;
	private double num;
	private String text;
	
	public Args() {
	}

	public boolean isOperationClicked() {
		return operationClicked;
	}

	public void setOperationClicked(boolean operationClicked) {
		this.operationClicked = operationClicked;
	}

	public JTextField getResult() {
		return result;
	}

	public void setResult(JTextField result) {
		this.result = result;
	}

	public ActionEvent getEvent() {
		return event;
	}

	public void setEvent(ActionEvent event) {
		this.event = event;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public double getNum() {
		return num;
	}

	public void setNum(double num) {
		this.num = num;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
}
