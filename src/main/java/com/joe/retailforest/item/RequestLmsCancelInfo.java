package com.joe.retailforest.item;

public class RequestLmsCancelInfo {

	private String custOrdNO;
	
	private String shipperNO;
	
	private String platformId;
	
	private String customer;

	private String orderNO;

	public String getOrderNO() {
		return orderNO;
	}

	public void setOrderNO(String orderNO) {
		this.orderNO = orderNO;
	}

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

	@Override
	public String toString() {
		return "RequestLmsCancelInfo{" +
				"custOrdNO='" + custOrdNO + '\'' +
				", shipperNO='" + shipperNO + '\'' +
				", platformId='" + platformId + '\'' +
				", customer='" + customer + '\'' +
				", orderNO='" + orderNO + '\'' +
				'}';
	}
}
