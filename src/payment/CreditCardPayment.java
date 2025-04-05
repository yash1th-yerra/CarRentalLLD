package payment;

import model.PaymentDetails;
import model.PaymentMode;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

public class CreditCardPayment extends PaymentMethod {
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private PaymentDetails paymentDetails;



    public CreditCardPayment(String cardNumber, String expirationDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
        this.paymentDetails = new PaymentDetails();
    }



    @Override
    public void makePayment(double amount) {
        // Simulate credit card payment processing
        System.out.println("Charging $" + amount + " to credit card " + cardNumber);
        paymentDetails.setPaymentId(UUID.randomUUID().hashCode());
        paymentDetails.setDayOfPayment(Date.from(Instant.now()));
        paymentDetails.setPaymentMode(PaymentMode.CREDIT);
        paymentDetails.setAmountPaid(amount);
        paymentDetails.setRefundable(false);
        paymentDetails.toString();
    }
}