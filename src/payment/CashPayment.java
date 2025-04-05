package payment;

import model.PaymentDetails;
import model.PaymentMode;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

public class CashPayment extends PaymentMethod {
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    private PaymentDetails paymentDetails;


    public CashPayment(){
        this.paymentDetails = new PaymentDetails();
    }


    @Override
    public void makePayment(double amount) {
        // Simulate credit card payment processing

        System.out.println("Charging $" + amount + " through cash mode ");
        paymentDetails.setPaymentId(UUID.randomUUID().hashCode());
        paymentDetails.setDayOfPayment(Date.from(Instant.now()));
        paymentDetails.setPaymentMode(PaymentMode.CASH);
        paymentDetails.setAmountPaid(amount);
        paymentDetails.setRefundable(false);
        paymentDetails.toString();



    }
}