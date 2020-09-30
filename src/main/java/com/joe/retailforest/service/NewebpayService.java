package com.joe.retailforest.service;


import com.joe.retailforest.item.RequestTradeInfo;
import com.joe.retailforest.item.ResponseTradeInfo;

public interface NewebpayService {
	
	
	String sendApproveTradeInfo(RequestTradeInfo requestTradeInfo);
	
	String sendApproveTradeSHA(String approveTradeInfo);
	
	ResponseTradeInfo getApproveTradeInfo(String tradeInfo);
	

}
