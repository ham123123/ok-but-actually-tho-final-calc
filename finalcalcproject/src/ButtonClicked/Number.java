package ButtonClicked;



import MainCode.Args;

public class Number implements ButtonClicked {
	
	private Args variables;


	public Number (Args variables) {
		this.variables = variables;
	}

	@Override
	public void execute() {
		String number = variables.getEvent().getActionCommand();
		if (!variables.isOperationClicked()) {                       // to have the option of big numbers
			String text = variables.getText();
			text += number;
			variables.getResult().setText(text);
		} else {                                       // to replace numbers present
			variables.getResult().setText(number);
			variables.setOperationClicked(false);                // to restart the process
		}		
	}
}