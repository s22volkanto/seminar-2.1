package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Bus;
import model.Fuel;
import model.Purchase;
import model.Tractor;
import model.Vehicle;

public class mainService {

	public static ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	private static ArrayList<Purchase> allPurchases = new ArrayList<Purchase>();
	
	public static void main(String[] args) {
		
				
		Bus bus1 = new Bus("Mercedes", 10000,  2,Fuel.diesel, 60, true);
		Bus bus2 = new Bus("BWM", 20000,  3, Fuel.electric, 20, false);
		
		Tractor tractor1 = new Tractor("RAM", 567532, 12, Fuel.gas, "None", true);
		Tractor tractor2 = new Tractor("Ferrari", 54321, 2, Fuel.petrol, "None", false);
		
		allVehicles.addAll(Arrays.asList(bus1, bus2, tractor1, tractor2));
		
		
		for(Vehicle tempV : allVehicles) {
			System.out.println(tempV.getClass().getName() + "->" + tempV);
		}
		
		
		Purchase p1 = new Purchase("12345int id67890", new ArrayList<Vehicle>(Arrays.asList(bus1)), null);
		Purchase p2 = new Purchase("1234567899", new ArrayList<Vehicle>(Arrays.asList(bus1, bus2, tractor1)), null);
		
		allPurchases.addAll(Arrays.asList(p1, p2));
		
		for(Purchase tempP: allPurchases) {
			System.out.println(tempP);
		}
		System.out.println("----------------------------");
		try {
			System.out.println("GetById: " + getBusById(1));
			System.out.println("GetByCode: " + getBusByVehicleCode("1_BWM"));
			
			
			createNewBus("Audi", 24234324, 3, Fuel.electric, 40, false);
			
			createNewBus("Mercedes", 10000,  10, Fuel.diesel, 60, true);//2+10 = 12
			
			for(Vehicle tempV : allVehicles) {
				System.out.println(tempV.getClass().getName() + "->" + tempV);
			}
			System.out.println("---------------AFTER UPDATE-----------");
			updateBusById(0, 10001 , 3, Fuel.diesel, 60);
			
			for(Vehicle tempV : allVehicles) {
				System.out.println(tempV.getClass().getName() + "->" + tempV);
			}
			
			System.out.println("---------------AFTER DELETE-----------");
			deleteBusById(1);
			
			for(Vehicle tempV : allVehicles) {
				System.out.println(tempV.getClass().getName() + "->" + tempV);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		

	}
	
	public static Bus getBusById(int id) throws Exception{
		if(id < 0 ) throw new Exception("Id should be positive");
		
		for(Vehicle tempV: allVehicles) {
			if(tempV instanceof Bus && tempV.getID() == id)
			{
				return (Bus)tempV;
			}
		}
		
		throw new Exception("There is no bus with this id");
		
	}
	
	public static Bus getBusByVehicleCode(String code) throws Exception{
		if(code == null ) throw new Exception("Problems with arguments");
		
		for(Vehicle tempV: allVehicles) {
			if(tempV instanceof Bus && tempV.getVehicleCode().equals(code))
			{
				return (Bus)tempV;
			}
		}
		
		throw new Exception("There is no bus with this code");
		
	}
	
	
	public static void createNewBus(String title, float price, int quantity, Fuel type, int numberOfSeats, boolean hasBaggageDivision) throws Exception
	{
		//TODO verify all input params
		
		for(Vehicle tempV: allVehicles) {
			if(tempV instanceof Bus && (tempV.getTitle().equals(title) && tempV.getFuel().equals(type)
					&& ((Bus)tempV).getNumberOfSeats() == numberOfSeats ))
			{
				tempV.setQuantity(tempV.getQuantity()+quantity);
				
				System.out.println("This bus is already in the system. The quantity will be increased");
				return;
			}
		}
		
		Bus newBus = new Bus(title, price, quantity, type, numberOfSeats, hasBaggageDivision);
		allVehicles.add(newBus);

	}
	public static void updateBusById(int id, float price, int quantity, Fuel type, int numberOfSeats)throws Exception {
		//TODO do validations of input params
		
		for(Vehicle tempV: allVehicles) {
			if(tempV.getID() == id && tempV instanceof Bus)
			{
					Bus tempBus = (Bus)tempV;
					tempBus.setPrice(price);
					tempBus.setQuantity(quantity);
					tempBus.setFuel(type);
					tempBus.setNumberOfSeats(numberOfSeats);
					return;
				}
		}
		throw new Exception("There is no Bus with " + id + " id" );	
	}
	
	public static void deleteBusById(int id) throws Exception{
		if(id < 0) throw new Exception("I should be positive");
		
		for(int i = 0; i < allVehicles.size(); i++) {
			if(allVehicles.get(i).getID() == id && allVehicles.get(i) instanceof Bus)
			{
				allVehicles.remove(i);
				return;
			}
		}
		throw new Exception("There is no Bus with " + id + " id" );
	}
	
	
	
	

}