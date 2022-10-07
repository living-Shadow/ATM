package banking;

public class cash {
	private int denomination;
	private int number;
	private int value;
	public cash(int denomination,int number,int value) {
		super();
		this.denomination=denomination;
		this.number=number;
		this.value=value;
		
	}
	
	public int getDenomination() {
		return denomination;
	}
	public void setDenomination(int denomination) {
		this.denomination = denomination;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "cash [denomination=" + denomination + ", number=" + number + ", value=" + value + "]";
	}
	
	
	

}
