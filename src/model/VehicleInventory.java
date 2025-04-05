package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class VehicleInventory {
    private int inventoryId;
    private List<Vehicle> vehicleList;

    public VehicleInventory(List<Vehicle> vehicles){

        vehicleList = new ArrayList<>();
        vehicleList.addAll(vehicles);
    }

    public void addVehicle(Vehicle vehicle){
        vehicleList.add(vehicle);

    }

    public void removeVehicle(Vehicle vehicle){
        vehicleList.remove(vehicle);

    }

    public List<Vehicle> getAllVehicles(){
        return vehicleList;
    }

}
