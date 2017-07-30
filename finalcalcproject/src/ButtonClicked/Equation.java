package ButtonClicked;

import java.util.HashMap;


import ActualOperation.ActualOperation;
import ActualOperation.Adding;
import ActualOperation.Dividing;
import ActualOperation.Multiplying;
import ActualOperation.Subtracting;
import MainCode.Args;

public class Equation implements ButtonClicked {
	private HashMap<Integer, ActualOperation> operationDictionary;
	private Args variables;

	public Equation (Args variables) {
		this.variables = variables;
	}

	public void execute() {
		variables.setOperationClicked(true);
		operationDictionary = new HashMap<Integer, ActualOperation>();
		variables.setText(variables.getResult().getText());
		fillOperationDictionary();
		operationDictionary.get(variables.getOperation()).operate();
		variables.setOperation(0);
		variables.setCount(0);
	}

	private void fillOperationDictionary() {
		operationDictionary.put(1, new Adding (variables));
		operationDictionary.put(2, new Subtracting (variables));
		operationDictionary.put(3, new Dividing (variables));
		operationDictionary.put(4, new Multiplying (variables));
	}
}