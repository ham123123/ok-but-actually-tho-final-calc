package ButtonClicked;

import javax.swing.JTextField;

public interface ButtonClicked {
	
	public void execute();
	
	public int getOperation();

	public double getNum();

	public int getCount();

	public JTextField getResultText();
	
	public boolean getOperationClicked();
}
