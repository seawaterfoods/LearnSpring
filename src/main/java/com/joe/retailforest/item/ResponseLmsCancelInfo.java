package com.joe.retailforest.item;

public class ResponseLmsCancelInfo {

	private String custOrdNO;
	
	private String shipperNO;
	
	private String platformId;
	
	private String customer;
	
	private String orderStatus;
	
	private String statusStatement;

	public String getCustOrdNO() {
		return custOrdNO;
	}

	public void setCustOrdNO(String custOrdNO) {
		this.custOrdNO = custOrdNO;
	}

	public String getShipperNO() {
		return shipperNO;
	}

	public void setShipperNO(String shipperNO) {
		this.shipperNO = shipperNO;
	}

	public String getPlatformId() {
		return platformId;
	}

	public void setPlatformId(String platformId) {
		this.platformId = platformId;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStatusStatement() {
		return statusStatement;
	}

	public void setStatusStatement(String statusStatement) {
		this.statusStatement = statusStatement;
	}

	@Override
	public String toString() {
		return "ResponseLmsCancelInfo{" +
				"custOrdNO='" + custOrdNO + '\'' +
				", shipperNO='" + shipperNO + '\'' +
				", platformId='" + platformId + '\'' +
				", customer='" + customer + '\'' +
				", orderStatus='" + orderStatus + '\'' +
				", statusStatement='" + statusStatement + '\'' +
				'}';
	}
}
