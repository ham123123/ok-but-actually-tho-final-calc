import java.awt.event.ActionEvent;
import javax.swing.JTextField;


public class RespondToButtonClicks {
	
	private ActionEvent event;
	private boolean OperationClicked;
	private JTextField result;
	
	public RespondToButtonClicks (ActionEvent ev, boolean op, JTextField rs) {
		event = ev;
		OperationClicked = op;
		result = rs;
	}
	
	public void treatAsNumber() {
		String number = event.getActionCommand();
		if (!OperationClicked) {                       // to have the option of big numbers
			String text = result.getText();
			text += number;
			result.setText(text);
		} else {                                       // to replace numbers present
			result.setText(number);
			OperationClicked = false;                  // to restart the process
		}	
	}
	
	public void treatAsDecimal() {
		String text = result.getText();
		if (!text.contains(".") && !OperationClicked) {
			text += ".";
			result.setText(text);
		} else if (text.contains(".") && OperationClicked) {
			result.setText(".");
			OperationClicked = false;
		}
	}
	
	public boolean getOperationStatus() {
		return OperationClicked;
	}
}
