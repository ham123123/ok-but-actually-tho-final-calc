package ActualOperation;

import MainCode.Args;

public class Subtracting implements ActualOperation {

	
    private Args variables;
	
	public Subtracting (Args variables) {
		this.variables = variables;
	}

	public void operate() {
		if (variables.getCount() == 0) {
			variables.setNum(Double.parseDouble(variables.getText()));
			variables.setCount(1);
		} else {                         // to store second number and add
			double newNum = Double.parseDouble(variables.getText());
			variables.setNum(variables.getNum() - newNum); 
			variables.getResult().setText("" + variables.getNum());
		}		
	}
}