package application;

public class Seated extends PizzaOrder {
	private double serviceCharge;
	private int numberOfPeople;
	
	//constructors ( default and non default ) :-
	public Seated() {
		
	}
	
	public Seated(String customerName,int size, int numberOfToppings, double toppingPrice ,double serviceCharge ,int numberOfPeople) {
		super(customerName,size,numberOfToppings,toppingPrice);
		this.serviceCharge=serviceCharge;
		this.numberOfPeople=numberOfPeople;
	}
	
	//setter and getter methods  :-
	public double getServiceCharge() {
		return serviceCharge;
	}

	public void setServiceCharge(double serviceCharge) {
		this.serviceCharge = serviceCharge;
	}

	public int getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	@Override    //overrides the method in PizzaOrder  :-
	public String toString() {
		return "serviceCharge "+serviceCharge+" numberOfPeople "+numberOfPeople+" "+super.toString();
	}
	
	@Override    //overrides the method in PizzaOrder  :-
	public double calculateOrderPrice() {
		return (serviceCharge * numberOfPeople)+super.calculateOrderPrice() ;
	}
	

}
