package com.aldo.javatest.payments;

public class PaymentResponse {
    enum paymentStatus{
        OK,ERROR
    }

    private paymentStatus status;

    public PaymentResponse(paymentStatus status) {
        this.status = status;
    }

    public paymentStatus getStatus() {
        return status;
    }
}
