package com.KrystalMovies.FoodMobsAPI.Response;

public class ReportResponse {
	private StatusType status;
	private byte[] response;
	
	public StatusType getStatus() {
		return this.status;
	}
	public void setStatus(final StatusType status) {
		this.status = status;
	}
	public byte[] getResponse() {
		return this.response;
	}
	public void setResponse(final byte[] response) {
		this.response = response;
	}
	public ReportResponse(byte[] response, StatusType st) {
		this.status=st;
		this.response=response;
	}
}
