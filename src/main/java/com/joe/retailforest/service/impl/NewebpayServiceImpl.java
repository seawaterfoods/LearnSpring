package com.joe.retailforest.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.joe.retailforest.item.RequestTradeInfo;
import com.joe.retailforest.item.ResponseTradeInfo;
import com.joe.retailforest.service.AESService;
import com.joe.retailforest.service.NewebpayService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

@Service
public class NewebpayServiceImpl implements NewebpayService {
	
	
	private static Logger logger = Logger.getLogger(NewebpayServiceImpl.class.getName());
	
	/**
	 * 偏移量，只有CBC模式才需要
	 */
	private final static String ivParameter = "CeazakeqPlPb1enP";

	/**
	 * AES要求密钥长度为128位或192位或256位，java默认限制AES密钥长度最多128位
	 */
	public static String sKey = "htGp7OVgAsf7j3U4aCspRn1uBuVAwylp";
	
	@Autowired
	private AESService aesService;

	/**
	 * 
	 * @param requestTradeInfo
	 * @return
	 */
	@Override
	public String sendApproveTradeInfo(RequestTradeInfo requestTradeInfo){
		aesService =new AESServiceImpl();
		return aesService.encrypt(approveTradeInfoString(requestTradeInfo, sKey, ivParameter), sKey, ivParameter);
	}
	
	/**
	 * 
	 */
	@Override
	public String sendApproveTradeSHA(String approveTradeInfo){
		
		approveTradeInfo = "HashKey=" + sKey + "&" + approveTradeInfo + "&HashIV=" + ivParameter;
		
		return getAesService().getSHA256(approveTradeInfo);
		
	}
	
	@Override
	public ResponseTradeInfo getApproveTradeInfo(String tradeInfo){
		
		String returnstring = "";
		
	    String tradeInfoJsonString =  aesService.decrypt(tradeInfo, sKey, ivParameter);
	    
	    ResponseTradeInfo tradeInfoData = JSON.parseObject(tradeInfoJsonString, new TypeReference<ResponseTradeInfo>() {});
	    
		return tradeInfoData;
	}
	
	/**
	 * 授權String
	 * @param requestTradeInfo
	 * @return
	 */
	public String approveTradeInfoString(RequestTradeInfo requestTradeInfo, String sKey, String ivParameter){
		String result = "";
		Map<String, String> keyValues = new LinkedHashMap<String, String>();
		Map<String, String> mappingMap = new LinkedHashMap<String, String>(); 
		
		try {
			List<String> sortList = new LinkedList<String>();
			sortList.add("merchantID");
			sortList.add("respondType");
			sortList.add("timeStamp");
			sortList.add("version");
			sortList.add("merchantOrderNo");
			sortList.add("amt");
			sortList.add("itemDesc");
			sortList.add("returnURL");
			sortList.add("notifyURL");
			sortList.add("customerURL");
			sortList.add("clientBackURL");
			sortList.add("email");
			sortList.add("credit");
			sortList.add("indexType");

			mappingMap.put("merchantID", "MerchantID");
			mappingMap.put("respondType", "RespondType");
			mappingMap.put("timeStamp", "TimeStamp");
			mappingMap.put("version", "Version");
			mappingMap.put("merchantOrderNo", "MerchantOrderNo");
			mappingMap.put("amt", "Amt");
			mappingMap.put("itemDesc", "ItemDesc");
			mappingMap.put("returnURL", "ReturnURL");
			mappingMap.put("notifyURL", "NotifyURL");
			mappingMap.put("customerURL", "CustomerURL");
			mappingMap.put("clientBackURL", "ClientBackURL");
			mappingMap.put("email", "Email");
			mappingMap.put("credit", "CREDIT");
			mappingMap.put("indexType", "IndexType");
			
			
			keyValues = BeanUtils.describe(requestTradeInfo);
			
			StringBuilder stringBuilder = new StringBuilder();
			
			int count = 0;
			
			for(String s : sortList){
				
				stringBuilder.append(mappingMap.get(s)).append("=").append(keyValues.get(s));
				
				
				if( count != sortList.size() - 1 ){
					stringBuilder.append("&");
				}
				System.out.println(s);
				count++;
				
			}
			
			
//			int count = 0;
//
//			for(String key : keyValues.keySet()){
//				stringBuilder.append(key).append("=").append(resultMap.get(key));
//				if( count != keyValues.size()-1 ){
//					stringBuilder.append("&");
//				}
//				count++;
//			}
			
//			result = "HashKey=" + sKey + "&" + stringBuilder.toString() + "HashIV=" + ivParameter;
			result = stringBuilder.toString();
			
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		logger.info("Result =============> " + result);
		
		return result;
		
	}
	
	public AESService getAesService() {
		return aesService;
	}

	public void setAesService(AESService aesService) {
		this.aesService = aesService;
	}

	
	
}

	
