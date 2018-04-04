/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.uniwallet;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Philip
 */
public class TransflowTest {

    private String merchantId;
    private String apiKey;
    private String productId;
    
    public TransflowTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        this.apiKey = "some_api_key";
        this.merchantId = "some_merchant_id";
        this.productId = "some_product_id";
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getMerchantId method, of class Transflow.
     */
    @Test
    public void testGetMerchantId() {
        System.out.println("getMerchantId");
        Transflow instance = new Transflow(
                this.merchantId, 
                this.apiKey, 
                this.productId
        );
        String expResult = this.merchantId;
        String result = instance.getMerchantId();
        assertEquals(expResult, result);
    }

    /**
     * Test of getApiKey method, of class Transflow.
     */
    @Test
    public void testGetApiKey() {
        System.out.println("getApiKey");
        Transflow instance = new Transflow(merchantId, apiKey, productId);
        String expResult = this.apiKey;
        String result = instance.getApiKey();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProductId method, of class Transflow.
     */
    @Test
    public void testGetProductId() {
        System.out.println("getProductId");
        Transflow instance = new Transflow(merchantId, apiKey, productId);
        String expResult = this.productId;
        String result = instance.getProductId();
        assertEquals(expResult, result);
    }

}
