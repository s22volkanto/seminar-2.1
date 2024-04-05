package service;

import java.util.ArrayList;
import java.util.Arrays;

import model.Bus;
import model.Fuel;
import model.Tractor;
import model.Vehicle;


public class mainService {
	public static ArrayList<Vehicle> allVehicles = new ArrayList<Vehicle>();
	public static void main(String[] arhs) {
		
	Bus bus1 = new Bus("Mercedes", 10000, 2, Fuel.diesel, 60, true);
	Bus bus2 = new Bus("Scania", 20000, 3, Fuel.electric, 40, false);
	
	Tractor tractor1 = new Tractor("RAM", 54321, 2, Fuel.petrol, "None", false);
	Tractor tractor2 = new Tractor("Belarus", 656542, 12, Fuel.gas, "None", true);
	allVehicles.addAll(Arrays.asList(bus1, bus2, tractor1, tractor2));
	for(Vehicle tempV : allVehicles) {
		System.out.println(tempV.getClass().getName() + " -> " + tempV);
		}
	}	
	
	public static Bus getBusById(int id) {
	        for (Vehicle vehicle : allVehicles) {
	            if (vehicle instanceof Bus && ((Bus) vehicle).getID() == id) {
	                return (Bus) vehicle;
	            }
	        }
	        return null;
	}
	
    public static Bus getBusByVehicleCode(String vehicleCode) {
        for (Vehicle vehicle : allVehicles) {
            if (vehicle instanceof Bus && vehicle.getVehicleCode().equals(vehicleCode)) {
                return (Bus) vehicle;
            }
        }
        return null;
    }
	
    public static void createNewBus(Bus newBus) {
        if (!allVehicles.contains(newBus)) {
            allVehicles.add(newBus);
            System.out.println("New bus added: " + newBus);
        } else {
            System.out.println("Bus already exists.");
        }
    }
    
    public static ArrayList<Bus> getAllBuses() {
        ArrayList<Bus> buses = new ArrayList<>();
        for (Vehicle vehicle : allVehicles) {
            if (vehicle instanceof Bus) {
                buses.add((Bus) vehicle);
            }
        }
        return buses;
    }
    
    public static void deleteBusById(int id) {
        for (int i = 0; i < allVehicles.size(); i++) {
            Vehicle vehicle = allVehicles.get(i);
            if (vehicle instanceof Bus && ((Bus) vehicle).getID() == id) {
                allVehicles.remove(i);
                System.out.println("Bus deleted: " + vehicle);
                return;
            }
        }
        System.out.println("Bus not found.");
    }
    
    public static void updateBusById(int id, Bus updatedBus) {
        for (int i = 0; i < allVehicles.size(); i++) {
            Vehicle vehicle = allVehicles.get(i);
            if (vehicle instanceof Bus && ((Bus) vehicle).getID() == id) {
                allVehicles.set(i, updatedBus);
                System.out.println("Bus updated: " + updatedBus);
                return;
            }
        }
        System.out.println("Bus not found.");
    }
}