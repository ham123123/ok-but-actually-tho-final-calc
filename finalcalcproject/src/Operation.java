

public interface Operation {
	public void setNextOperation (Operation nextOperation);
	public double calculate(Numbers request);
}
