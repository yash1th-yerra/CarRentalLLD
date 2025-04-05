package pricing;

import model.Reservation;

public class HourlyPricing extends PricingStrategy {
    private double hourlyRate;

    public HourlyPricing(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculatePrice(Reservation reservation) {
        if (reservation.getBookedFrom() == null || reservation.getBookedTo() == null) {
            throw new IllegalArgumentException("Booked from and to times are required for hourly pricing");
        }

        long hours = java.time.Duration.between(reservation.getBookedFrom(), reservation.getBookedTo()).toHours();
        return hours * hourlyRate;
    }
}