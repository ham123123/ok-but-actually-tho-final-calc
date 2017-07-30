package ButtonClicked;


import MainCode.Args;

public class Clear implements ButtonClicked {

	private Args variables;
	
	
	public Clear (Args variables) {
		this.variables = variables;
	}
	
	@Override
	public void execute() {
		variables.getResult().setText("");
		variables.setOperation(0);
		variables.setCount(0);		
		variables.setOperationClicked(true);		
	}
}