package application;

import java.util.Date;
public class PizzaOrder implements Comparable <PizzaOrder>{
	private String customerName;
	private Date dateOrdered;
	private int pizzaSize;
	final static int SMALL=1;
	final static int MEDIOM=2;
	final static int LARGE=3;
	private int numberOfToppings;
	private double toppingPrice;
	
	//constructors ( default and non default ) :-
	public PizzaOrder() {
		this.dateOrdered = new Date();
	}
	
	public PizzaOrder(String customerName,int size, int numberOfToppings, double toppingPrice) {
		super();
		this.customerName = customerName;
		this.dateOrdered = new Date();
		this.pizzaSize=size;
		this.numberOfToppings = numberOfToppings;
		this.toppingPrice = toppingPrice;
	}

	//setter and getter methods  :-
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getDateOrdered() {
		return dateOrdered;
	}

	public void setDateOrdered(Date dateOrdered) {
		this.dateOrdered = dateOrdered;
	}

	public int getNumberOfToppings() {
		return numberOfToppings;
	}

	public void setNumberOfToppings(int numberOfToppings) {
		this.numberOfToppings = numberOfToppings;
	}

	public double getToppingPrice() {
		return toppingPrice;
	}

	public void setToppingPrice(double toppingPrice) {
		this.toppingPrice = toppingPrice;
	}
	
	public int getPizzaSize() {
		return pizzaSize;
	}

	@Override
	public String toString() {
		return "customerName "+customerName+" dateOrdered "+dateOrdered+" pizzaSize "+pizzaSize+" numberOfToppings "+numberOfToppings+" toppingPrice "+toppingPrice;
	}
	
	//calculates the price of the pizza order  :-
	public double calculateOrderPrice() {
		return ( numberOfToppings * toppingPrice ) * pizzaSize;
	}
	
	//Print the Customer name && price of order  :-
	public String printOrderInfo() {
		System.out.println(customerName+" 	 "+calculateOrderPrice());
		return "";
	}
	
	@Override
	public int compareTo(PizzaOrder p) {
		return Double.compare(this.calculateOrderPrice(), p.calculateOrderPrice());
	}

}
