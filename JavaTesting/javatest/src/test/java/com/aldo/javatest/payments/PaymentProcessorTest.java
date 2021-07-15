package com.aldo.javatest.payments;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class PaymentProcessorTest {
    private  PaymentsGateway paymentsGateway;
    private  PaymentProcessor paymentProcessor;
    //con before indica que antes de cada test se ejecuta este metodo
    @Before
    public void setup(){
        paymentsGateway = Mockito.mock(PaymentsGateway.class);
        paymentProcessor = new PaymentProcessor(paymentsGateway);

    }

    @Test
    public void payment_is_correct() {


        Mockito.when(paymentsGateway.requestPayment(Mockito.any()))
            .thenReturn(new PaymentResponse(PaymentResponse.paymentStatus.OK));

        assertTrue(paymentProcessor.makePayment(1000));

    }
    @Test
    public void payment_is_wrong() {
        Mockito.when(paymentsGateway.requestPayment(Mockito.any()))
        .thenReturn(new PaymentResponse(PaymentResponse.paymentStatus.ERROR));

        assertFalse(paymentProcessor.makePayment(1000));

    }
}