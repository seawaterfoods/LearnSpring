package com.joe.retailforest.test;

import com.joe.retailforest.method.HttpGetWithEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

public class LmsGetTest {

    public static String doGetRequest(String url, RequestMethod method, String params) throws Exception {

        CloseableHttpClient httpClient = HttpClients.createDefault();

        final byte[] clientDataBytes ="康寧統編".toString().getBytes("UTF-8");
        final byte[] keyDataBytes = "yPz3SRnhJ399uPDigIGaV2XiJ13b9HseZUNWEysOPYs=".toString().getBytes("UTF-8");

        //解決中文亂碼問題
        StringEntity stringEntity = new StringEntity(params, "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        HttpEntityEnclosingRequestBase httpMethod;
        if(method == RequestMethod.GET) {
            httpMethod = new HttpGetWithEntity();
        }else if(method == RequestMethod.PUT){
            httpMethod = new HttpPut();
        }
        else{
            httpMethod = new HttpPost();
        }
        System.out.println(url);
        httpMethod.setURI(new URI(url));
        httpMethod.addHeader("Content-Type", "application/json;charset=UTF-8");
        httpMethod.addHeader("LMS_API_CLIENT",  String.valueOf(clientDataBytes));
        httpMethod.addHeader("LMS_API_KEY", String.valueOf(keyDataBytes));

        //httpGet.addHeader("X-HTTP-Method-Override",method.toString());
        httpMethod.setEntity(stringEntity);
        HttpResponse httpResponse = httpClient.execute(httpMethod);
        String responseString = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");

        httpClient.close();
        return responseString;
    }

}
