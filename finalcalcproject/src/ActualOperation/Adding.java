package ActualOperation;

import javax.swing.JTextField;

public class Adding implements ActualOperation {

	private int count;
	private String text;
	private double num;
	private JTextField result;
	
	public Adding (int count, String text, double num, JTextField result) {
		this.count = count;
		this.text = text;
		this.num = num;
		this.result = result;
	}

	public void operate() {
		if (count == 0) {
			num = Double.parseDouble(text);
			count = 1;
		} else if (count != 0) {                         // to store second number and add
			double newNum = Double.parseDouble(text);
			num = num + newNum;
			result.setText("" + num);
		}		
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return count;
	}

	@Override
	public double getNum() {
		// TODO Auto-generated method stub
		return num;
	}

	@Override
	public JTextField getResult() {
		// TODO Auto-generated method stub
		return result;
	}

}
