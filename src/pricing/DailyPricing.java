package pricing;

import model.Reservation;

public class DailyPricing extends PricingStrategy {
    private double dailyRate;

    public DailyPricing(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculatePrice(Reservation reservation) {
        if (reservation.getBookedFrom() == null || reservation.getBookedTo() == null) {
            throw new IllegalArgumentException("Booked from and to times are required for daily pricing");
        }

        long days = java.time.Duration.between(reservation.getBookedFrom(), reservation.getBookedTo()).toDays();
        return days * dailyRate;
    }
}