package model;

public abstract class Vehicle {
	private int ID;
	private String title;
	private String vehicleCode;
	private float price;
	private int quantity;
	private Fuel fuel;
	private static int counter = 0;
	
	public long getID() {
		return ID;
	}
	public void setID() {
		this.ID = counter;
		counter++;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		if(title != null  && title.matches("[A-Za-z ]{3,20}"))
			this.title = title;
		else
			this.title = "Undefinied";
	}
	public String getVehicleCode() {
		return vehicleCode;
	}
	public void setVehicleCode() {
		this.vehicleCode = ID + "_" + title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		if(price > 0 && price < 999999) 
			this.price = price;
		else
			this.price = 10000;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		if(quantity > 0 && quantity < 1000)
			this.quantity = quantity;
		else
			this.quantity = 1;
	}
	public Fuel getFuel() {
		return fuel;
	}
	public void setFuel(Fuel fuel) {
		if(fuel != null)
			this.fuel = fuel;
		else
			this.fuel = Fuel.not_specified;
	}
	//Constructors
		public Vehicle() {
			setID();
			setTitle("Title");
			setVehicleCode();
			setPrice(99);
			setQuantity(1);
			setFuel(Fuel.other);
		}
		
		public Vehicle(String title, float price, int quantity, Fuel fuel) {
			setID();
			setTitle(title);
			setVehicleCode();
			setPrice(price);
			setQuantity(quantity);
			setFuel(fuel);
		}
		// toString
			public String toString()
			{
				return ID + ": " + title + " (" + vehicleCode + ")" + " - " + price + "$ " + " (" + quantity + ")";
			}
}
