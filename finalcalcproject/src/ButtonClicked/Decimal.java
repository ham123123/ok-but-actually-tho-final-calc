package ButtonClicked;

import java.awt.event.ActionEvent;

import javax.swing.JTextField;

public class Decimal implements ButtonClicked {

	private boolean operationClicked;
	private JTextField result;
	private int operation;
	private double num;
	private int count;

	public Decimal (boolean opClicked, JTextField result, ActionEvent ev, int operation, double num, int count) {
		this.operationClicked = opClicked;
		this.result = result;
		this.operation = operation;
		this.num = num;
		this.count = count;
	}

	@Override
	public void execute() {
		String text = result.getText();
		if (!text.contains(".") && !operationClicked) {
			text += ".";
			result.setText(text);
		} else if (text.contains(".") && operationClicked) {
			result.setText(".");
			operationClicked = false;
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
