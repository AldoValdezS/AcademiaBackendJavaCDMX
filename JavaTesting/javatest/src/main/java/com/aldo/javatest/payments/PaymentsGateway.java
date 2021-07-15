package com.aldo.javatest.payments;

public interface PaymentsGateway {
    PaymentResponse requestPayment(PaymentRequest request);
}
