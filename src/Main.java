import model.*;
import payment.CreditCardPayment;
import payment.PaymentMethod;
import pricing.HourlyPricing;
import pricing.PricingStrategy;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        VehicleRentalSystem vehicleRentalSystem = new VehicleRentalSystem();

        // Create users
        User user1 = new User();
        user1.setUserId(1);
        user1.setUserName("John Doe");
        user1.setContactNo("1234567890");
        user1.setDrivingLicense("DL123456");

        User user2 = new User();
        user2.setUserId(2);
        user2.setUserName("Jane Doe");
        user2.setContactNo("9876543210");
        user2.setDrivingLicense("DL987654");

        // Add users to the vehicle rental system
        vehicleRentalSystem.addUser(user1);
        vehicleRentalSystem.addUser(user2);

        // Create rental stores
        RentalStore store1 = new RentalStore();
        store1.setStoreId(1);
        store1.setStoreLocation(new Location(12345, "New York", "NY", "USA"));

        RentalStore store2 = new RentalStore();
        store2.setStoreId(2);
        store2.setStoreLocation(new Location(67890, "Los Angeles", "CA", "USA"));

        // Add rental stores to the vehicle rental system
        vehicleRentalSystem.addRentalStore(store1);
        vehicleRentalSystem.addRentalStore(store2);

        // Create vehicles
        Vehicle sedan = new Sedan();
        sedan.setVehicleId(1);
        sedan.setVehicleNo("SEDAN123");
        sedan.setMake("Toyota");
        sedan.setModel("Camry");
        sedan.setYear(2020);
        sedan.setKmDriven(10000);
        sedan.setColor("Black");
        sedan.setAverage(20);
        sedan.setCc(2000);
        sedan.setDailyRentalCost(50);
        sedan.setHourlyRentalCost(10);
        sedan.setNoOfSeats(5);
        sedan.setStatus(VehicleStatus.AVAILABLE);

        Vehicle suv = new Suv();
        suv.setVehicleId(2);
        suv.setVehicleNo("SUV456");
        suv.setMake("Honda");
        suv.setModel("CR-V");
        suv.setYear(2019);
        suv.setKmDriven(5000);
        suv.setColor("White");
        suv.setAverage(25);
        suv.setCc(2500);
        suv.setDailyRentalCost(60);
        suv.setHourlyRentalCost(12);
        suv.setNoOfSeats(7);
        suv.setStatus(VehicleStatus.AVAILABLE);

        // Add vehicles to the rental stores
        List<Vehicle> vehicles1 = new ArrayList<>();
        vehicles1.add(sedan);
        store1.setVehicleInventory(vehicles1);

        List<Vehicle> vehicles2 = new ArrayList<>();
        vehicles2.add(suv);
        store2.setVehicleInventory(vehicles2);

        // Create a reservation
        Reservation reservation = store1.createReservation(sedan, user1);
        reservation.setBookedFrom(LocalDateTime.now());
        reservation.setBookedTo(LocalDateTime.now().plusHours(2));

        // Create a payment
        PricingStrategy pricingStrategy = new HourlyPricing(10);
        PaymentMethod paymentMethod = new CreditCardPayment("1234567890123456", "12/2025", "123");
        Payment payment = new Payment(paymentMethod, pricingStrategy);
        Bill bill = new Bill();
        bill.setReservation(reservation);
        payment.payBill(bill);
        reservation.getVehicle().setStatus(VehicleStatus.UNAVAILABLE);

        // Print the reservation details
        System.out.println("Reservation ID: " + reservation.getReservationId());
        System.out.println("Vehicle ID: " + reservation.getVehicle().getVehicleId());
        System.out.println("User ID: " + reservation.getUser().getUserId());
        System.out.println("Booked From: " + reservation.getBookedFrom());
        System.out.println("Booked To: " + reservation.getBookedTo());
    }
}