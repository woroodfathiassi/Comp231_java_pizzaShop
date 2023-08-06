package application;

public class Delivery extends PizzaOrder{
	private double tripRate;
	private int zone;
	
	//constructors ( default and non default ) :-
	public Delivery() {
		
	}

	public Delivery(String customerName,int size, int numberOfToppings, double toppingPrice,double tripRate, int zone) {
		super(customerName,size,numberOfToppings,toppingPrice);
		this.tripRate = tripRate;
		this.zone = zone;
	}

	//setter and getter methods  :-
	public double getTripRate() {
		return tripRate;
	}

	public void setTripRate(double tripRate) {
		this.tripRate = tripRate;
	}

	public int getZone() {
		return zone;
	}

	public void setZone(int zone) {
		if(zone >= 1 && zone <= 4)   //Check if zone between 1-4  :-
		   this.zone = zone;
		else {
			this.zone=0;
			System.out.println("Error : The zone = 0 `must be between 1-4` ");
		}
	}
	
	
	@Override    //overrides the method in PizzaOrder  :-
	public String toString() {
		return "tripRate "+tripRate+ " zone "+zone+" "+super.toString();
	}
	
	@Override    //overrides the method in PizzaOrder  :-
	public double calculateOrderPrice() {
		return  (tripRate/100 * super.calculateOrderPrice() * zone)+super.calculateOrderPrice()  ;
	}
	
	/*
	       	Prints a report ( all properties and  order price )
	         for the second Delivery order 
	 */
    public void printSecondDeliveryOrders(PizzaOrder list) {
		
		System.out.println("Customer Name = "+list.getCustomerName()+"\nDate Ordered = today's date");
		if(list.getPizzaSize() == 1)
			System.out.println("Pizza Size = small");
		else if (list.getPizzaSize() == 2)
			System.out.println("Pizza Size = medium");
		else
			System.out.println("Pizza Size = large");
		System.out.println("Number of Topping = "+list.getNumberOfToppings()+"\nTopping Price = "+list.getToppingPrice()+"\nTrip Rate = "+getTripRate()+"\nZone = "+getZone());
		System.out.println("Order Price = "+list.calculateOrderPrice());

		
	}

	

}
