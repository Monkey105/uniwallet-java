/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.uniwallet;

import com.phil.uniwallet.interfaces.UniWalletInterface;
import com.phil.uniwallet.models.UniWalletResponse;
import com.phil.uniwallet.utils.MyOkHttpClient;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author Philip
 */
public class UniWallet implements UniWalletInterface {

    private final Transflow transflow;
    private String urlEndpoint;
    private String port;
    private OkHttpClient client;
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");

    /**
     * Default constructor for live UNIWALLET API
     *
     * @param transflow
     */
    public UniWallet(Transflow transflow) {
        this.transflow = transflow;
        this.urlEndpoint = EndPoints.GET_LIVE_ENDPOINT;
        this.port = EndPoints.GET_LIVE_PORT;
    }

    /**
     * Add true if you want to test on the test API.
     *
     * @param transflow
     * @param isTest
     */
    public UniWallet(Transflow transflow, boolean isTest) {
        this.transflow = transflow;
        this.urlEndpoint = EndPoints.GET_TEST_ENDPOINT;
        this.port = EndPoints.GET_TEST_PORT;
    }

    public Transflow getTransflow() {
        return transflow;
    }

    public String getUrlEndpoint() {
        return urlEndpoint;
    }

    public void setUrlEndpoint(String urlEndpoint) {
        this.urlEndpoint = urlEndpoint;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    private String buildURL(String endpoint) {
        StringBuilder sb = new StringBuilder(this.urlEndpoint);
        sb.append(":").append(this.port).append("/").append(endpoint);
        return sb.toString();
    }

    @Override
    public String[] getNetworks() throws IOException {
        String url = buildURL(EndPoints.GET_NETWORKS);

        this.client = MyOkHttpClient.getHttpClient(url);
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Response response = client.newCall(request).execute();
        if (response.isSuccessful()) {
            String message = "{ resp: " + response.body().string() + "}";
            JSONObject jSONObject = new JSONObject(message);
            JSONArray jsonArray = jSONObject.getJSONArray("resp");

            String[] ret = new String[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                ret[i] = jsonArray.getString(i);
            }

            return ret;
        }

        return null;

    }

    @Override
    public UniWalletResponse creditCustomer(String referenceNumber,
            String msisdn, String amount, String network,
            String narration
    ) throws IOException {
        String url = buildURL(EndPoints.CREDIT_CUSTOMER);

        Map<String, String> map = new HashMap();

        map.put("merchantId", this.transflow.getMerchantId());
        map.put("productId", this.transflow.getProductId());
        map.put("apiKey", this.transflow.getApiKey());
        map.put("refNo", referenceNumber);
        map.put("msisdn", msisdn);
        map.put("amount", amount);
        map.put("network", network);
        map.put("voucher", "voucher");
        map.put("narration", narration);

        String requestResponse = this.post(url, this.getJsonStringFromHashMap(map));

        return new UniWalletResponse(new JSONObject(requestResponse));
    }

    @Override
    public UniWalletResponse debitCustomer(
            String referenceNumber, String msisdn, String amount,
            String network, String voucher, String narration
    ) throws IOException {
        String url = buildURL(EndPoints.DEBIT_CUSTOMER);

        Map<String, String> map = new HashMap();

        map.put("merchantId", this.transflow.getMerchantId());
        map.put("productId", this.transflow.getProductId());
        map.put("apiKey", this.transflow.getApiKey());
        map.put("refNo", referenceNumber);
        map.put("msisdn", msisdn);
        map.put("amount", amount);
        map.put("network", network);
        map.put("voucher", "voucher");
        map.put("narration", narration);

        String requestResponse = this.post(url, this.getJsonStringFromHashMap(map));

        return new UniWalletResponse(new JSONObject(requestResponse));
    }

    private String getJsonStringFromHashMap(Map<String, String> map) {
        Iterator entries = map.entrySet().iterator();
        StringBuilder sb = new StringBuilder();

        sb.append("{");
        while (entries.hasNext()) {
            Entry thisEntry = (Entry) entries.next();
            String key = thisEntry.getKey().toString();
            String value = thisEntry.getValue().toString();
            sb.append("\"").append(key).append("\"");
            sb.append(":");
            sb.append("\"").append(value).append("\"");

            if (entries.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("}");

        return sb.toString();
    }

    private String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);
        this.client = MyOkHttpClient.getHttpClient(url);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        Response response = client.newCall(request).execute();
        return response.body().string();
    }

}
