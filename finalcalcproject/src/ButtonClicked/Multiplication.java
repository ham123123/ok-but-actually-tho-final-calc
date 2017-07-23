package ButtonClicked;

import java.util.HashMap;

import javax.swing.JTextField;

import ActualOperation.ActualOperation;
import ActualOperation.Adding;
import ActualOperation.Dividing;
import ActualOperation.Multiplying;
import ActualOperation.Subtracting;

public class Multiplication implements ButtonClicked {
	private boolean operationClicked;
	private int count;
	private int operation;
	private JTextField result;
	private double num;
	private HashMap<Integer, ActualOperation> operationDictionary;

	public Multiplication (boolean opClicked, int count, int operation, JTextField result, double num) {
		this.operationClicked = opClicked;
		this.count = count;
		this.operation = operation;
		this.result = result;
		this.num = num;
		
	}

	public void execute() {
		operationClicked = true;
		String text = result.getText();
		operationDictionary = new HashMap<Integer, ActualOperation>();
		fillOperationDictionary(text);
		if (operation == 0) {
			operation = 4;
		}
		operationDictionary.get(operation).operate();
		getInfoFromOperationDictionary();
		operation = 4;
	}
	
	private void getInfoFromOperationDictionary() {
		count = operationDictionary.get(operation).getCount();
		num = operationDictionary.get(operation).getNum();
		result = operationDictionary.get(operation).getResult();
	}

	private void fillOperationDictionary(String text) {
		operationDictionary.put(1, new Adding (count, text, num, result));
		operationDictionary.put(2, new Subtracting (count, text, num, result));
		operationDictionary.put(3, new Dividing (count, text, num, result));
		operationDictionary.put(4, new Multiplying (count, text, num, result));
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
