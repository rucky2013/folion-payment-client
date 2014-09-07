package com.folionmedia.payment.server.paypal;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.folionmedia.payment.server.api.PaymentException;
import com.folionmedia.payment.server.api.PaymentRequest;
import com.folionmedia.payment.server.api.PaymentResponse;
import com.folionmedia.payment.server.boot.ApplicationTests;

public class PaypalPaymentServiceTest extends ApplicationTests {
	
	protected final Logger logger = LoggerFactory.getLogger(PaypalPaymentServiceTest.class);

	@Autowired
	private PaypalPaymentService paypalPaymentService;
	
	@Test
	public void requestHostedEndpoint() throws PaymentException {
		logger.info("test PaypalPaymentService.requestHostedEndpoint()");
		assertNotNull(paypalPaymentService);
		
		PaymentRequest paymentRequest = mockCreatePaymentRequest();
		PaymentResponse paymentResponse = paypalPaymentService.requestHostedEndpoint(paymentRequest);
		String userRedirectUrl = paymentResponse.responseMap(PaypalConstants.REDIRECTURL);
		
		assertTrue(paymentResponse.isSuccessful());
		assertNotNull(userRedirectUrl);
	}
	
    private PaymentRequest mockCreatePaymentRequest(){
    	PaymentRequest paymentRequest = new PaymentRequest();
    	
    	paymentRequest.setProductId(UUID.randomUUID().toString());
    	paymentRequest.setProductName("Product Name");
    	paymentRequest.setProductDescription("Product Description");
    	paymentRequest.setProductQuantity(10);
    	paymentRequest.setProductUnitPrice("2");
    	paymentRequest.setProductTotalAmount("20");
    	
		paymentRequest.setTotalAmount("20");
		paymentRequest.setCurrencyCode("USD");
		paymentRequest.setCompleteCheckoutOnCallback(true);
		
		return paymentRequest;
    }
}
