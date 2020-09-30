package com.joe.retailforest.test;

import com.alibaba.fastjson.JSON;
import com.joe.retailforest.item.RequestTradeInfo;
import com.joe.retailforest.item.ResponseTradeInfo;
import com.joe.retailforest.method.HttpURLConnectionUtils;
import com.joe.retailforest.service.AESService;
import com.joe.retailforest.service.NewebpayService;
import com.joe.retailforest.service.impl.AESServiceImpl;
import com.joe.retailforest.service.impl.CancelOrderNewebpayServiceImpl;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.Instant;
import java.util.*;

public class PendingCancelCronJob {

    @Autowired
    private static NewebpayService newebpayService = new CancelOrderNewebpayServiceImpl();

    @Autowired
    private static AESService aesService = new AESServiceImpl();

    private static final Logger LOG = Logger.getLogger(PendingCancelCronJob.class);
    @Autowired
    private static HttpURLConnectionUtils httpURLConnectionUtils = new HttpURLConnectionUtils();

    public static void main(String[] args) {
        // TODO 將OrderCancelRecordModel撈取出來，將其裝到對應藍新要求格式(String)先打印出來。
//        取消API需要傳此網址
        String merchantCallbackUrl = new String("https://ccore.newebpay.com/API/CreditCard/Cancel");

//        設置傳遞交易訊息的Item
        RequestTradeInfo requestTradeInfo = new RequestTradeInfo();

//        設置傳至API的POST資料
        Map<String, String> resultContent = new HashMap<>();

//        撈取Unix時間戳
        Instant instant = Instant.now();

        String MerchantID_ = "MS313044003";//商店代號
        String PostData_;//加密資料

//        要求API要回傳信息
        String RespondType = "JSON";

        String Version = "1.2";

//        交易數量
        String Amt = "1";

//         商店訂單編號與TradeNo藍新金流交易序號二擇一
        String MerchantOrderNo = "00032004";
//        藍新金流交易序號與MerchantOrderNo商店訂單編號二擇一
//		String TradeNo="20080710085592872";

//        商店訂單編號=1,藍新金流交易序號=2;
        String IndexType = "1";

//        將時間戳轉成字串
        String TimeStamp = instant.getEpochSecond() + "";


//        將API所需CancelOrder的屬性塞入傳遞交易訊息的Item晚點要加密成PostData_
        requestTradeInfo.setRespondType(RespondType);
        requestTradeInfo.setVersion(Version);
        requestTradeInfo.setAmt(Amt);
        requestTradeInfo.setMerchantOrderNo(MerchantOrderNo);
        requestTradeInfo.setTimeStamp(TimeStamp);
        requestTradeInfo.setIndexType(IndexType);

//        調用加密
        PostData_ = newebpayService.sendApproveTradeInfo(requestTradeInfo);

//        塞入POST資料
        resultContent.put("PostData_", PostData_);
        resultContent.put("MerchantID_", MerchantID_);

//        調用httpURLConnectionUtils.sendMerchantCallback發送資料到CancelOrder的API中，並且取得回傳訊息
        String param = httpURLConnectionUtils.sendMerchantCallback(merchantCallbackUrl, resultContent);

        ResponseTradeInfo responseTradeInfo = JSON.parseObject(param, ResponseTradeInfo.class);

        System.out.println("responseTradeInfo" + responseTradeInfo);

    }


    public NewebpayService getNewebpayService() {
        return newebpayService;
    }

    public void setNewebpayService(NewebpayService newebpayService) {
        this.newebpayService = newebpayService;
    }

    public HttpURLConnectionUtils getHttpURLConnectionUtils() {
        return httpURLConnectionUtils;
    }

    public void setHttpURLConnectionUtils(HttpURLConnectionUtils httpURLConnectionUtils) {
        this.httpURLConnectionUtils = httpURLConnectionUtils;
    }
}
