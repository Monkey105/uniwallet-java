/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.uniwallet;

/**
 *
 * @author Philip
 */
public class Transflow {

    private final String merchantId;
    private final String apiKey;
    private final String productId;

    public Transflow(String merchantId, String apiKey, String productId) {
        this.merchantId = merchantId;
        this.apiKey = apiKey;
        this.productId = productId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getProductId() {
        return productId;
    }
        
}
