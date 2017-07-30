package ButtonClicked;


import MainCode.Args;

public class Decimal implements ButtonClicked {

	private Args variables;

	public Decimal (Args variables) {
		this.variables = variables;
	}

	@Override
	public void execute() {
		if (!variables.getText().contains(".") && !variables.isOperationClicked()) {
			variables.getResult().setText(variables.getText() + ".");
		} else if (variables.getText().contains(".") && variables.isOperationClicked()) {
			variables.getResult().setText(".");
			variables.setOperationClicked(false);
		}		
	}
}
