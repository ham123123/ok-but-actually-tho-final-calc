package ButtonClicked;

import javax.swing.JTextField;

public class Clear implements ButtonClicked {

	private boolean operationClicked;
	private JTextField result;
	private int count;
	private int operation;
	private double num;
	
	
	public Clear (boolean opClicked, JTextField result, int count, int operation, double num) {
		this.operationClicked = opClicked;
		this.result = result;
		this.count = count;
		this.operation = operation;
		this.num = num;
	}
	@Override
	public void execute() {
		result.setText("");
		operation = 0; // reset at value of equals
		count = 0;
		operationClicked = true;		
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
