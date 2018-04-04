/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.uniwallet.utils;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

/**
 *
 * @author Philip
 */
public class MyOkHttpClient {

    public static javax.net.ssl.SSLSocketFactory getSslSocketFactory() {
        SSLContext sslContext = null;
        try {
            // Create an SSLContext that uses our TrustManager
            sslContext = SSLContext.getInstance("TLS");
            TrustManager[] trustManagers = {new MyTrustManager()};
            sslContext.init(null, trustManagers, null);
            sslContext.getSocketFactory();
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
        if (sslContext != null) {
            return sslContext.getSocketFactory();
        }
        return null;
    }

    public static com.squareup.okhttp.OkHttpClient getHttpClient(String url) {
        com.squareup.okhttp.OkHttpClient okHttpClient = new com.squareup.okhttp.OkHttpClient();
        okHttpClient.setSslSocketFactory(getSslSocketFactory());
        okHttpClient.setHostnameVerifier(new NullHostNameVerifier());
        return okHttpClient;
    }

    private static class MyTrustManager implements X509TrustManager {

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
        }

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }
    }

    public static class NullHostNameVerifier implements HostnameVerifier {

        @Override
        public boolean verify(String hostname, SSLSession session) {
            return true;
        }

    }
}
