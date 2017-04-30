public class GroceryItemOrder {
	private String name = "";
	private int quantity = 0;
	private double PricePerUnit = 0;

	public GroceryItemOrder(String inName, int inQuantity, double inPricePerUnit) {
		name = inName;
		setQuantity(inQuantity);
		PricePerUnit = inPricePerUnit;
	}

	public double getCost() {
		return quantity * PricePerUnit;

	}

	public void setQuantity(int inQuantity) {
		if (inQuantity >= 1) {
			quantity = inQuantity;
		} else {
			throw new IllegalArgumentException("Lower than 1");
		}
	}
	public String toString(){
		return " Item: " + name + " | Quantity: " + quantity + " | Cost: "  + getCost();
		
	}

}
