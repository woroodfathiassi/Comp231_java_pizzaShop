package application;

public class ToGo extends PizzaOrder{
	
	//constructors ( default and non default ) :-
	public ToGo() {
		
	}
	
	public ToGo(String customerName,int size, int numberOfToppings, double toppingPrice) {
		super(customerName,size,numberOfToppings,toppingPrice);
	}
	
	public String toString() {
		return super.toString();
	}

}
