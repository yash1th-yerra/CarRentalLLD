package payment;

import model.PaymentDetails;
import model.PaymentMode;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class DebitCardPayment extends PaymentMethod {
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private PaymentDetails paymentDetails;

    public DebitCardPayment(String cardNumber, String expirationDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.paymentDetails = new PaymentDetails();
    }

    @Override
    public void makePayment(double amount) {
        // Simulate credit card payment processing
        System.out.println("Charging $" + amount + " to debit card " + cardNumber);
        paymentDetails.setPaymentId(UUID.randomUUID().hashCode());
        paymentDetails.setDayOfPayment(Date.from(Instant.now()));
        paymentDetails.setPaymentMode(PaymentMode.CREDIT);
        paymentDetails.setAmountPaid(amount);
        paymentDetails.setRefundable(false);
        paymentDetails.toString();
    }
}