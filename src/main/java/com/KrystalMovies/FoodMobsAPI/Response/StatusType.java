package com.KrystalMovies.FoodMobsAPI.Response;

import java.util.List;

public class StatusType {
	
	private String responseStatus;
	private List<Error> errors;
	private String identifier;
	
	public StatusType(final String responseStatus, final List<Error> error) {
		super();
		this.responseStatus = responseStatus;
		this.errors = error;
	}
	public StatusType(final String responseStatus) {
		super();
		this.responseStatus = responseStatus;
		errors=null;
		identifier=null;
	}
	public StatusType(final String responseStatus, final String identifier, final List<Error> error) {
		super();
		this.responseStatus =  responseStatus;
		this.errors = error;
		this.identifier = identifier;
	}
	public String getResponseStatus() {
		return this.responseStatus;
	}
	public void setResponseStatus(final String responseStatus) {
		this.responseStatus = responseStatus;
	}
	public List<Error> getErrors() {
		return this.errors;
	}
	public void setErrors(final List<Error> error) {
		this.errors = error;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
}
