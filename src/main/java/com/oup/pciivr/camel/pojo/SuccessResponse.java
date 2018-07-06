package com.oup.pciivr.camel.pojo;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "invoiceNumber", "balance", "currencyCode" })
public class SuccessResponse {

	/**
	 * Invoice Number
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("invoiceNumber")
	private String invoiceNumber = "";
	/**
	 * Outstanding Balance
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("balance")
	private Double balance;
	/**
	 * Currency Code
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("currencyCode")
	private String currencyCode = "";
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Invoice Number
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("invoiceNumber")
	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	/**
	 * Invoice Number
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("invoiceNumber")
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	/**
	 * Outstanding Balance
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("balance")
	public Double getBalance() {
		return balance;
	}

	/**
	 * Outstanding Balance
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("balance")
	public void setBalance(Double balance) {
		this.balance = balance;
	}

	/**
	 * Currency Code
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("currencyCode")
	public String getCurrencyCode() {
		return currencyCode;
	}

	/**
	 * Currency Code
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("currencyCode")
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@Override
	public String toString() {
		return new ToStringBuilder(this).append("invoiceNumber", invoiceNumber).append("balance", balance)
				.append("currencyCode", currencyCode).append("additionalProperties", additionalProperties).toString();
	}

}