package com.joe.retailforest.item;

public class Result {
	
	
	private String merchantID;
	
	private String amt;
	
	private String tradeNo;
	
	private String merchantOrderNo;
	
	private String respondType;
	
	private String iP;
	
	private String escrowBank;
	
	private String paymentType;
	
	private String respondCode;
	
	private String auth;
	
	private String card6No;
	
	private String card4No;
	
	private String exp;
	
	private String tokenUseStatus;
	
	private Integer instFirst;
	
	private Integer instEach;
	
	private Integer inst;
	
	private String eCI;
	
	private String payTime;
	
	private String paymentMethod;

	public String getMerchantID() {
		return merchantID;
	}

	public void setMerchantID(String merchantID) {
		this.merchantID = merchantID;
	}

	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getMerchantOrderNo() {
		return merchantOrderNo;
	}

	public void setMerchantOrderNo(String merchantOrderNo) {
		this.merchantOrderNo = merchantOrderNo;
	}

	public String getRespondType() {
		return respondType;
	}

	public void setRespondType(String respondType) {
		this.respondType = respondType;
	}

	public String getiP() {
		return iP;
	}

	public void setiP(String iP) {
		this.iP = iP;
	}

	public String getEscrowBank() {
		return escrowBank;
	}

	public void setEscrowBank(String escrowBank) {
		this.escrowBank = escrowBank;
	}

	public String getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	public String getRespondCode() {
		return respondCode;
	}

	public void setRespondCode(String respondCode) {
		this.respondCode = respondCode;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getCard6No() {
		return card6No;
	}

	public void setCard6No(String card6No) {
		this.card6No = card6No;
	}

	public String getCard4No() {
		return card4No;
	}

	public void setCard4No(String card4No) {
		this.card4No = card4No;
	}

	public String getExp() {
		return exp;
	}

	public void setExp(String exp) {
		this.exp = exp;
	}

	public String getTokenUseStatus() {
		return tokenUseStatus;
	}

	public void setTokenUseStatus(String tokenUseStatus) {
		this.tokenUseStatus = tokenUseStatus;
	}

	public Integer getInstFirst() {
		return instFirst;
	}

	public void setInstFirst(Integer instFirst) {
		this.instFirst = instFirst;
	}

	public Integer getInstEach() {
		return instEach;
	}

	public void setInstEach(Integer instEach) {
		this.instEach = instEach;
	}

	public Integer getInst() {
		return inst;
	}

	public void setInst(Integer inst) {
		this.inst = inst;
	}

	public String geteCI() {
		return eCI;
	}

	public void seteCI(String eCI) {
		this.eCI = eCI;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	@Override
	public String toString() {
		return "Result [merchantID=" + merchantID + ", amt=" + amt + ", tradeNo=" + tradeNo + ", merchantOrderNo="
				+ merchantOrderNo + ", respondType=" + respondType + ", iP=" + iP + ", escrowBank=" + escrowBank
				+ ", paymentType=" + paymentType + ", respondCode=" + respondCode + ", auth=" + auth + ", card6No="
				+ card6No + ", card4No=" + card4No + ", exp=" + exp + ", tokenUseStatus=" + tokenUseStatus
				+ ", instFirst=" + instFirst + ", instEach=" + instEach + ", inst=" + inst + ", eCI=" + eCI
				+ ", payTime=" + payTime + ", paymentMethod=" + paymentMethod + "]";
	}


}
