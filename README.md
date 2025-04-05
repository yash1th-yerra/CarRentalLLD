# Car Rental System

## Problem Statement

Design a low-level system for a car rental platform like Zoomcar or Revv. The system should support the following core operations:

1.  Users can search for cars available at a location for a given time range.
2.  Users can book a car by selecting from the available options.
3.  System tracks vehicle inventory across multiple cities and pickup/drop locations.
4.  Pricing varies based on vehicle type, duration, and additional features (e.g., GPS, child seat).
5.  Payment is required to confirm a booking.
6.  After booking, the car becomes unavailable during that period.

## Further Constraints and Considerations

1.  The System should handle multiple rental locations.
2.  Basic concurrency since multiple users can have a chance to book the same car at the same time.

## My Clarifications

1.  We need a vehicle (made more generic for scalability in case we want to extend for bike rental as well).
2.  It should maintain location-based service (picked and dropped off at different rental locations).
3.  Multiple rental stores are needed to handle them at different locations.
4.  Pricing strategies.
5.  Payment and payment strategies.
6.  Billing should be done.
7.  Most importantly, we need user info to store their details for registration/authentication and also for history tracking if we implement.
8.  History (as of now, it is optional; we'll look into it as we go forward).
9.  Vehicle inventory management is needed to manage vehicles.
10. Each store will have a Vehicle Inventory Management (VIM).

## Entities

### Vehicle

*   vehicleId: int
*   vehicleNumber: int
*   vehicleType: VehicleType (enum)
*   companyName: String
*   modelName: String
*   kmDriven: int
*   modelYear: int
*   color: String
*   average: double
*   CC: int
*   dailyRentalCost: double
*   hourlyRentalCost: double
*   noOfSeats: int
*   status: Status (enum)

### VehicleType (enum)

*   CAR
*   BIKE (future, just use this for explanation; don't include this in the current design)

### VehicleInventory

*   List<Vehicle> vehicles
*   CRUD operations

### Location

*   address: String
*   city: String
*   state: String
*   pinCode: int

### User

*   id: int
*   username: String
*   drivingLicense: String
*   contact: String

### Reservation

*   reservationID: int
*   user: User
*   vehicle: Vehicle
*   bookingDate: date
*   bookedFrom: time
*   bookedTill: time
*   pickupLocation: Location
*   dropLocation: Location
*   fromTimeStamp: time
*   toTimeStamp: time
*   reservationType: ReservationType (enum)
*   reservationStatus: ReservationStatus (enum)

### ReservationStatus (enum)

*   SCHEDULED
*   INPROGRESS
*   CLOSED
*   CANCELLED

### RentalStore

*   storeId: int
*   vehicleInventory: VehicleInventory
*   storeLocation: Location
*   reservationList: List<Reservation>

### VehicleRentalSystem

*   users: List<User>
*   stores: List<RentalStore>
*   CRUD operations

### Bill

*   reservation: Reservation
*   flag: boolean
*   amount: double

### Payment

*   bill: Bill
*   payBill()

### PaymentStrategies (enum)

*   CASH
*   UPI
*   CREDIT
*   DEBIT

## System Design

The system will have the following components:

1.  **VehicleRentalSystem**: This will be the main class that will handle all the operations. It will have a list of users and a list of rental stores.
2.  **RentalStore**: Each rental store will have a vehicle inventory, a store location, and a list of reservations.
3.  **VehicleInventory**: This will manage the vehicles available at each rental store.
4.  **Reservation**: This will represent a reservation made by a user.
5.  **Payment**: This will handle the payment for a reservation.
6.  **Bill**: This will represent the bill for a reservation.

## Flow

1.  A user will search for available vehicles at a location for a given time range.
2.  The user will select a vehicle and make a reservation.
3.  The system will check if the vehicle is available during the selected time period.
4.  If the vehicle is available, the system will create a reservation and update the vehicle's status.
5.  The user will make a
