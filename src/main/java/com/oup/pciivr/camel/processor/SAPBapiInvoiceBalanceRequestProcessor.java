package com.oup.pciivr.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang.StringUtils;
import org.fusesource.camel.component.sap.SapSynchronousRfcDestinationEndpoint;
import org.fusesource.camel.component.sap.model.rfc.Structure;
import org.springframework.stereotype.Component;

@Component("springManagedSAPBapiInvoiceBalanceRequestProcessor")
public class SAPBapiInvoiceBalanceRequestProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		// TODO Auto-generated method stub
		SapSynchronousRfcDestinationEndpoint endpoint = exchange.getContext().getEndpoint(
				"sap-srfc-destination:sapRFCDest:ZPCI_INVOICE_BALANCE", SapSynchronousRfcDestinationEndpoint.class);
		Structure request = endpoint.createRequest();
		request.put("I_BELNR", StringUtils.leftPad(exchange.getProperty("INVOICE_NUM", String.class), 10, "0"));
		exchange.getIn().setBody(request);
	}

}
