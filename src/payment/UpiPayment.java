package payment;

import model.PaymentDetails;
import model.PaymentMode;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class UpiPayment extends PaymentMethod {
    private String upiId;
    private PaymentDetails paymentDetails;
    public UpiPayment(String upiId) {
        this.upiId = upiId;
        this.paymentDetails = new PaymentDetails();
    }

    @Override
    public void makePayment(double amount) {
        // Simulate PayPal payment processing
        System.out.println("Transferring $" + amount + " to UPI account " + upiId);
        paymentDetails.setPaymentId(UUID.randomUUID().hashCode());
        paymentDetails.setDayOfPayment(Date.from(Instant.now()));
        paymentDetails.setPaymentMode(PaymentMode.UPI);
        paymentDetails.setAmountPaid(amount);
        paymentDetails.setRefundable(false);
        paymentDetails.toString();
    }
}