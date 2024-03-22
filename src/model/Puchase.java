package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Puchase {
	private String userCardNr;
	private ArrayList<Vehicle> shoppingList = new ArrayList<Vehicle>();
	private LocalDateTime dateTime;
	
	public String getUserCardNr() {
		return userCardNr;
	}
	public void setUserCardNr(String userCardNr) {
		if(userCardNr != null  && userCardNr.matches("[0-9]{1,20}"))
			this.userCardNr = userCardNr;
		else
			this.userCardNr = "Undefinied";;
	}
	public ArrayList<Vehicle> getShoppingList() {
		return shoppingList;
	}
	
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime() {
		this.dateTime = LocalDateTime.now();
	}
	// Constructors
	
	// toString
	

}
