package pricing;

import model.Reservation;

public abstract class PricingStrategy {

    public abstract double calculatePrice(Reservation reservation);

}
