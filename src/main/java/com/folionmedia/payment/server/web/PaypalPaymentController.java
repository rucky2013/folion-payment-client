package com.folionmedia.payment.server.web;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.folionmedia.payment.server.api.PaymentException;
import com.folionmedia.payment.server.api.PaymentRequest;
import com.folionmedia.payment.server.api.PaymentResponse;
import com.folionmedia.payment.server.api.PaymentService;

@Controller
@RequestMapping("/paypal-express")
public class PaypalPaymentController {

	@Autowired
	@Qualifier("paymentService")
	private PaymentService paymentService;
	
	//Get http://localhost:8080/paypal-express/checkout
    @RequestMapping(value = "/checkout", method = RequestMethod.GET)
    public String checkout(HttpServletRequest request)  throws PaymentException {
    	PaymentRequest paymentRequest = new PaymentRequest();
    	
    	paymentRequest.setUid(UUID.randomUUID().toString());
    	paymentRequest.setProductId(UUID.randomUUID().toString());
    	paymentRequest.setProductName("Product Name");
    	paymentRequest.setProductDescription("Product Description");
    	paymentRequest.setProductQuantity(10);
    	paymentRequest.setProductUnitPrice("2");
    	paymentRequest.setProductTotalAmount("20");
    	
		paymentRequest.setTotalAmount("20");
		paymentRequest.setCurrencyCode("USD");
		paymentRequest.setCompleteCheckoutOnCallback(true);
    	PaymentResponse paymentResponse = paymentService.requestHostedEndpoint(paymentRequest);
    	return "redirect:" + paymentResponse.responseMap("REDIRECTURL"); 
    }
}
