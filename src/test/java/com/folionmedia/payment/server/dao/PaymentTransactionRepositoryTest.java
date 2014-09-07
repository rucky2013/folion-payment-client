package com.folionmedia.payment.server.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.folionmedia.payment.server.api.PaymentException;
import com.folionmedia.payment.server.boot.ApplicationTests;
import com.folionmedia.payment.server.domain.PaymentTransaction;

public class PaymentTransactionRepositoryTest extends ApplicationTests {
	
	protected final Logger logger = LoggerFactory.getLogger(PaymentTransactionRepositoryTest.class);

	@Autowired
	private PaymentTransactionRepository paymentTransactionRepository;
	
	@Test
	public void requestHostedEndpoint() throws PaymentException {
		logger.info("test paymentTransactionRepository.findByVendorTxId()");

		String vendorTxId = "";
		PaymentTransaction paymentTransaction = paymentTransactionRepository.findByVendorTxId(vendorTxId);
		
		assertNotNull(paymentTransaction);
		assertEquals(paymentTransaction.getVendorTxId(), vendorTxId);
	}
}
