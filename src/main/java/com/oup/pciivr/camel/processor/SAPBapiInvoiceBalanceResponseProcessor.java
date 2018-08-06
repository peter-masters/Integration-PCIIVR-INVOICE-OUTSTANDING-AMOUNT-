package com.oup.pciivr.camel.processor;

import java.math.BigDecimal;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

import com.oup.pciivr.camel.exception.NoReordFoundException;
import com.oup.pciivr.camel.pojo.SuccessResponse;

@Component("springManagedSAPBapiInvoiceBalanceResponseProcessor")
public class SAPBapiInvoiceBalanceResponseProcessor implements Processor {
	Logger logger = org.slf4j.LoggerFactory.getLogger(this.getClass());

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		Structure response = exchange.getIn().getBody(Structure.class);
		BigDecimal outstandingBalanceAmount = response.get("E_WRBTR", BigDecimal.class);
		String outstandingBalanceCurrency = response.get("E_WAERS", String.class);
		String documentType = response.get("E_BLART", String.class);
		logger.info("Outstanding amount is::" + outstandingBalanceAmount + " " + outstandingBalanceCurrency);
		if (outstandingBalanceCurrency == null || outstandingBalanceCurrency.isEmpty()) {

			throw new NoReordFoundException(
					"No data found for invoice number " + exchange.getProperty("INVOICE_NUM", String.class));

		}
		SuccessResponse successResponse = new SuccessResponse();
		successResponse.setCurrencyCode(outstandingBalanceCurrency);
		successResponse.setBalance(outstandingBalanceAmount.doubleValue());
		successResponse.setDocumentType(documentType);
		successResponse.setInvoiceNumber(exchange.getProperty("INVOICE_NUM", String.class));		
		exchange.getOut().setBody(successResponse);

	}

}
