package ButtonClicked;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class Number implements ButtonClicked {
	
	private boolean operationClicked;
	private JTextField result;
	private ActionEvent event;
	private int count;
	private int operation;
	private double num;

	public Number (boolean opClicked, JTextField result, ActionEvent ev, int operation, int count, double num) {
		this.operationClicked = opClicked;
		this.result = result;
		this.event = ev;
		this.count = count;
		this.operation = operation;
		this.num = num;
	}

	@Override
	public void execute() {
		String number = event.getActionCommand();
		if (!operationClicked) {                       // to have the option of big numbers
			String text = result.getText();
			text += number;
			result.setText(text);
		} else {                                       // to replace numbers present
			result.setText(number);
			operationClicked = false;                  // to restart the process
		}		
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
