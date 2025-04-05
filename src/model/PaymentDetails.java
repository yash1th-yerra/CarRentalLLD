package model;

import java.util.Date;

public class PaymentDetails {
    private int paymentId;
    private double amountPaid;
    private Date dayOfPayment;
    private boolean isRefundable;
    private PaymentMode paymentMode;

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }

    public Date getDayOfPayment() {
        return dayOfPayment;
    }

    public void setDayOfPayment(Date dayOfPayment) {
        this.dayOfPayment = dayOfPayment;
    }

    public boolean isRefundable() {
        return isRefundable;
    }

    public void setRefundable(boolean refundable) {
        isRefundable = refundable;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "paymentId=" + paymentId +
                ", amountPaid=" + amountPaid +
                ", dayOfPayment=" + dayOfPayment +
                ", isRefundable=" + isRefundable +
                ", paymentMode=" + paymentMode +
                '}';
    }
}
