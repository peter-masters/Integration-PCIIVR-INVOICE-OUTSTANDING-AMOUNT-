package com.oup.pciivr.camel.controller;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.ExchangeBuilder;
import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.oup.pciivr.camel.exception.ValidationException;
import com.oup.pciivr.camel.pojo.FailureResponse;
import com.oup.pciivr.camel.pojo.SuccessResponse;

@Controller
public class InvoiceBalanceController {

	@Autowired
	private ProducerTemplate producer;

	@Autowired
	private CamelContext camelContext;

	@GetMapping(value = "/outstandingbalance/{invoicenum}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> getOutstandingBalanceForInvoice(@PathVariable("invoicenum") String invoiceNumber) {
		try {
			if (invoiceNumber == null || invoiceNumber.isEmpty()||invoiceNumber.trim().length()>10)
				throw new ValidationException("Invoice Number cannot be empty or more than 10 charecters");
			final Exchange requestExchange = ExchangeBuilder.anExchange(camelContext)
					.withProperty("INVOICE_NUM", invoiceNumber).build();
			final Exchange responseExchange = producer.send("direct:RouteToFetchOutstandingBalance", requestExchange);
			if (!responseExchange.getOut().isFault()) {
				final SuccessResponse responseBody = responseExchange.getOut().getBody(SuccessResponse.class);
				return new ResponseEntity<SuccessResponse>(responseBody, HttpStatus.OK);
			} else {

				throw responseExchange.getOut().getBody(Exception.class);
			}

		}

		catch (Exception ex) {
			FailureResponse failureResponse = new FailureResponse();
			if (ex.getClass() == com.oup.pciivr.camel.exception.ValidationException.class) {
				failureResponse.setErrorMessage(ex.getMessage());
				return new ResponseEntity<FailureResponse>(failureResponse, HttpStatus.BAD_REQUEST);
			} else if (ex.getClass() == com.oup.pciivr.camel.exception.NoReordFoundException.class) {
				failureResponse.setErrorMessage(ex.getMessage());
				return new ResponseEntity<FailureResponse>(failureResponse, HttpStatus.NOT_FOUND);
			} else {
				failureResponse.setErrorMessage(ex.getMessage());
				failureResponse.setErrorDetails(ExceptionUtils.getFullStackTrace(ex));
				return new ResponseEntity<FailureResponse>(failureResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}

		}

	}

}
