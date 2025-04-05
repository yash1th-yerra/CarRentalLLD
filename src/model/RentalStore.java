package model;

import java.util.ArrayList;
import java.util.List;

public class RentalStore {
    private int storeId;
    private VehicleInventory vehicleInventory;
    private Location storeLocation;
    private List<Reservation> reservationList;

    public RentalStore(int storeId, VehicleInventory vehicleInventory, Location storeLocation, List<Reservation> reservationList) {
        this.storeId = storeId;
        this.vehicleInventory = vehicleInventory;
        this.storeLocation = storeLocation;
        this.reservationList = reservationList;
    }

    public RentalStore() {
        this.reservationList=new ArrayList<>();
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public VehicleInventory getVehicleInventory() {
        return vehicleInventory;
    }

    public void setVehicleInventory(List<Vehicle> vehicles) {
        this.vehicleInventory = new VehicleInventory(vehicles);
    }

    public Location getStoreLocation() {
        return storeLocation;
    }

    public void setStoreLocation(Location storeLocation) {
        this.storeLocation = storeLocation;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }


    public List<Vehicle> getVehicles(){
        return vehicleInventory.getAllVehicles();
    }

    public Reservation createReservation(Vehicle vehicle, User user){
        Reservation reservation = new Reservation();
        reservation.createReserve(vehicle,user);
        reservationList.add(reservation);
        return reservation;

    }

    public boolean completeReservation(int reservationId){
        return true;
    }



}
