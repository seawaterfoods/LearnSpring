package com.joe.retailforest.method;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.net.ssl.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;


public class HttpURLJsonConnectionUtils {

//    private static final Logger LOGGER = Logger.getLogger(HttpURLJsonConnectionUtils.class);

    public HttpURLJsonConnectionUtils() {
        // TODO Auto-generated constructor stub
    }

    private final X509TrustManager dummyTrustManager = new X509TrustManager() {
        @Override
        public void checkClientTrusted(final X509Certificate[] chain, final String authType)
                throws CertificateException {// mock
        }// NOSONAR

        @Override
        public void checkServerTrusted(final X509Certificate[] chain, final String authType)
                throws CertificateException {// mock
        }// NOSONAR

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            // Null is returned as a result of not initialized list - caller methods may
            // treat null
            // differently than an empty collection thus fix could break existing
            // functionality
            return null; // NOSONAR
        }
    };

    private final HostnameVerifier dummyHostnameVerifier = new HostnameVerifier() {
        @Override
        public boolean verify(final String arg0, final SSLSession arg1) {
            return true;
        }
    };

    @SuppressWarnings({"finally"})
    public String sendLmsCancelCallback(final String merchantCallbackUrl,
                                        final RequestMethod requestMethod, final String jsonData) {
        System.out.println("merchantCallbackUrl:" + merchantCallbackUrl);
        System.out.println("requestMethod:" + requestMethod);
        System.out.println("jsonData:" + jsonData);
        String resultContent = null;
        HttpURLConnection conn = null;
        try {

            final URL url;
            url = new URL(merchantCallbackUrl);

            conn = (HttpURLConnection) url.openConnection();
            if (conn instanceof HttpsURLConnection) {
                final SSLContext ctx = javax.net.ssl.SSLContext.getInstance("SSL");
                ctx.init(null, new TrustManager[]{dummyTrustManager}, new SecureRandom());

                final HttpsURLConnection sslConn = (HttpsURLConnection) conn;
                sslConn.setSSLSocketFactory(ctx.getSocketFactory());
                sslConn.setHostnameVerifier(dummyHostnameVerifier);
            }

            final byte[] postDataBytes = createData(jsonData);
            final byte[] clientDataBytes = createData("康寧統編");
            final byte[] keyDataBytes = createData("yPz3SRnhJ399uPDigIGaV2XiJ13b9HseZUNWEysOPYs=");

            conn.setRequestMethod(requestMethod.toString());
            if (!requestMethod.equals(RequestMethod.GET)) {
                conn.setRequestProperty("Content-Type", "application/json");
                conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
                System.out.println("postDataBytes.length:"+String.valueOf(postDataBytes.length));
                conn.setRequestProperty("LMS_API_CLIENT", String.valueOf(clientDataBytes));
                conn.setRequestProperty("LMS_API_KEY", String.valueOf(keyDataBytes));
                conn.setDoOutput(true);
                conn.getOutputStream().write(postDataBytes);
            }

//            LOGGER.debug("send Response code:" + conn.getResponseCode());
//            LOGGER.debug("response message:" + conn.getResponseMessage());

            BufferedReader br = null;
            String strCurrentLine = null;
            if (conn.getResponseCode() == 200) {
                br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                while ((strCurrentLine = br.readLine()) != null) {
                    resultContent = strCurrentLine;
                }
            } else {
                br = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
                while ((strCurrentLine = br.readLine()) != null) {
                    resultContent = strCurrentLine;
                }
            }

        } catch (final Exception e) {
//            LOGGER.error("Sending lms callback failed", e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            return resultContent;
        }
    }

    protected byte[] createData(final String data)
            throws UnsupportedEncodingException {
        //     String putData = JSON.toJSONString(requestLmsCancelInfo,true);
        return data.toString().getBytes("UTF-8");
    }
}