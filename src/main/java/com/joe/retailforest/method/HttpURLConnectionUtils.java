package com.joe.retailforest.method;


import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

@Component
public class HttpURLConnectionUtils {

    private static final Logger LOGGER = Logger.getLogger(HttpURLConnectionUtils.class);

    public HttpURLConnectionUtils() {
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
    public String sendMerchantCallback(final String merchantCallbackUrl,
                                       final Map<String, String> params) {
        String resultContent = null;
        HttpURLConnection conn = null;
        try {
            final URL url = new URL(merchantCallbackUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (conn instanceof HttpsURLConnection) {
                final SSLContext ctx = javax.net.ssl.SSLContext.getInstance("SSL");
                ctx.init(null, new TrustManager[]{dummyTrustManager}, new SecureRandom());

                final HttpsURLConnection sslConn = (HttpsURLConnection) conn;
                sslConn.setSSLSocketFactory(ctx.getSocketFactory());
                sslConn.setHostnameVerifier(dummyHostnameVerifier);
            }

            final byte[] postDataBytes = createPostData(params);

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            conn.setRequestProperty("Content-Length", String.valueOf(postDataBytes.length));
            conn.setDoOutput(true);
            conn.getOutputStream().write(postDataBytes);

            LOGGER.debug("send Response code:" + conn.getResponseCode());
            LOGGER.debug("response message:" + conn.getResponseMessage());

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
            LOGGER.error("Sending merchant callback failed", e);
        } finally {
            if (conn != null) {
                conn.disconnect();
            }
            return resultContent;
        }
    }

    protected byte[] createPostData(final Map<String, String> params)
            throws UnsupportedEncodingException {
        final StringBuilder postData = new StringBuilder();
        for (final Map.Entry<String, String> param : params.entrySet()) {
            if (postData.length() != 0) {
                postData.append('&');
            }
            postData.append(URLEncoder.encode(param.getKey(), "UTF-8"));
            postData.append('=');
            postData.append(URLEncoder.encode(param.getValue(), "UTF-8"));
        }
        System.out.println("[postData]" + postData);
        return postData.toString().getBytes("UTF-8");
    }
}
