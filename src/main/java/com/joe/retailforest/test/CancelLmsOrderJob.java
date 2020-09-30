package com.joe.retailforest.test;

import com.alibaba.fastjson.JSON;
import com.joe.retailforest.item.RequestLmsCancelInfo;
import com.joe.retailforest.item.ResponseLmsCancelInfo;
import com.joe.retailforest.method.HttpURLJsonConnectionUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

public class CancelLmsOrderJob {

    private static HttpURLJsonConnectionUtils httpURLJsonConnectionUtils = new HttpURLJsonConnectionUtils();

    private List<String> successList = new ArrayList<>();
    private List<String> failList = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        System.out.println("perform");
//		List<OrderModel> lmsPandingCancelOrders = getCancelAuthorizationService().getAllLmsPendingCancelOrder();
        sendLmsCancelOrder();
    }


    /**
     * 20200922-Joe add
     * 將所有待取消的Order包裝成Lms取消API所需的POST資料後寄出，判斷流程是否全部正常後回傳boolean。
     *
     * @return boolean
     */
    private static boolean sendLmsCancelOrder() throws Exception {
        boolean allSuccess = true;
        boolean requestSuccess = true;
        String param = "";

        param = sendLmsCallback();
        System.out.println("param: " + param);
        ResponseLmsCancelInfo responseLmsCancelInfo = JSON.parseObject(param, ResponseLmsCancelInfo.class);

        System.out.println("responseLmsCancelInfo:"+responseLmsCancelInfo);
//				requestSuccess = saveResponseInfo(responseLmsCancelInfo, lmsPandingCancelOrder);

        return allSuccess;
    }

    /**
     * 20200922-Joe add 將所有待取消的Order包裝成藍新取消API所需的PUT資料後寄出。
     *
     * @return String
     */
    private static String sendLmsCallback() throws Exception {
        String lmsCallbackUrl = "http://211.76.134.188/HybrisAPI/hybrisAPI/order";
//        String lmsCallbackUrl = "http://211.76.134.188/HybrisAPI/hybrisAPI/orders";
//        String lmsCallbackUrl = "http://211.76.134.188/HybrisAPI/hybrisAPI/abnormalOrders";

        String jsonData = getRequestLmsCancelInfo();

        return LmsGetTest.doGetRequest(lmsCallbackUrl,RequestMethod.PUT,jsonData);
    }

    /**
     * 20200922-Joe add 將所有需取消的Order包裝成RequestLmsCancelInfo。
     *
     * @return RequestLmsCancelInfo
     */
    private static String getRequestLmsCancelInfo() {
        System.out.println("getRequestLmsCancelInfo");
        RequestLmsCancelInfo requestTradeInfo = new RequestLmsCancelInfo();
        requestTradeInfo.setCustomer("康寧統編");
        requestTradeInfo.setCustOrdNO("訂單號碼");
        requestTradeInfo.setPlatformId("HY01");
        requestTradeInfo.setShipperNO("出貨單號");
//        requestTradeInfo.setOrderNO("訂單編號 試試是否能不填");

        System.out.println("RequestLmsCancelInfo:" + requestTradeInfo);

        return JSON.toJSONString(requestTradeInfo,true);
    }

	/*
	 * 20200921-Joe add 將responseTradeInfo加入Order中並保存，判斷是否為SUCCESS後回傳。
	 * 
	 * @param responseLmsCancelInfo
	 * @param lmsPandingCancelOrders
	 * @return boolean

	private boolean saveResponseInfo(ResponseLmsCancelInfo responseLmsCancelInfo, OrderModel lmsPandingCancelOrder) {
		lmsPandingCancelOrder.getConsignments().iterator().next().setTrackingID(responseLmsCancelInfo.getOrderStatus());
		getModelService().save(lmsPandingCancelOrder.getConsignments().iterator().next());
		if (responseLmsCancelInfo.getOrderStatus().equalsIgnoreCase("SUCCESS")) {
			return true;
		} else {
			failList.add(lmsPandingCancelOrder.getCode());
			return false;
		}
	}*/

    /**
     * 20200922-Joe add: check if have lms cancel authorization record
     */
    private void haveCancelAuthorizationRecord() {
        System.out.println("---Success size:" + successList.size() + " | Fail size:" + failList.size());
        System.out.println(successList.size() != 0 ? "---Success Record:" + successList : "There's nothing success record.");
        System.out.println(failList.size() != 0 ? "---Fail Record:" + failList : "There's nothing fail record.");
        successList = new ArrayList<>();
        failList = new ArrayList<>();
    }


    public static HttpURLJsonConnectionUtils getHttpURLJsonConnectionUtils() {
        return httpURLJsonConnectionUtils;
    }

    public static void setHttpURLJsonConnectionUtils(HttpURLJsonConnectionUtils httpURLJsonConnectionUtils) {
        CancelLmsOrderJob.httpURLJsonConnectionUtils = httpURLJsonConnectionUtils;
    }
}
