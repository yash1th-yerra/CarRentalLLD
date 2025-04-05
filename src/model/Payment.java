package model;
import payment.PaymentMethod;
import pricing.PricingStrategy;

public class Payment {

    private PaymentMethod paymentMethod;
    private PricingStrategy pricingStrategy;
    

    public Payment(PaymentMethod paymentMethod, PricingStrategy pricingStrategy){
        this.paymentMethod = paymentMethod;
        this.pricingStrategy = pricingStrategy;

    }
    public void payBill(Bill bill){
        // do payment processing and update the bill status
        paymentMethod.makePayment(pricingStrategy.calculatePrice(bill.getReservation()));


    }
}
