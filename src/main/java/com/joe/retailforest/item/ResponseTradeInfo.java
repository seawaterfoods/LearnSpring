package com.joe.retailforest.item;



public class ResponseTradeInfo {
	
	
	private String status;
	
	private String message;
	
	private Result Result;



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Result getResult() {
		return Result;
	}

	public void setResult(Result result) {
		Result = result;
	}


	@Override
	public String toString() {
		return "ResponseTradeInfo{" +
				"status='" + status + '\'' +
				", message='" + message + '\'' +
				", Result=" + Result +
				'}';
	}
}
