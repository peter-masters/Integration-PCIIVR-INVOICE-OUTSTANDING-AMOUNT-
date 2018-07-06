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
@JsonPropertyOrder({ "errorMessage", "errorDetails" })
public class FailureResponse {

	/**
	 * Error Message
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("errorMessage")
	private String errorMessage = "";
	/**
	 * Error Details
	 * <p>
	 * 
	 * 
	 */
	@JsonProperty("errorDetails")
	private String errorDetails = "";
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * Error Message
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("errorMessage")
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * Error Message
	 * <p>
	 * 
	 * (Required)
	 * 
	 */
	@JsonProperty("errorMessage")
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	/**
	 * Error Details
	 * <p>
	 * 
	 * 
	 */
	@JsonProperty("errorDetails")
	public String getErrorDetails() {
		return errorDetails;
	}

	/**
	 * Error Details
	 * <p>
	 * 
	 * 
	 */
	@JsonProperty("errorDetails")
	public void setErrorDetails(String errorDetails) {
		this.errorDetails = errorDetails;
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
		return new ToStringBuilder(this).append("errorMessage", errorMessage).append("errorDetails", errorDetails)
				.append("additionalProperties", additionalProperties).toString();
	}

}