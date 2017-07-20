
public class MultiplyNumbers implements Operation {
	private Operation nextInChain;
	
	public void setNextOperation(Operation nextOperation) {
		this.nextInChain = nextOperation;
	}

	public double calculate(Numbers request) {
		if(request.getOperation().contains("*")) {
			return request.getNumber1() * request.getNumber2();
		} else {
			return 0;
		}
	}

}
