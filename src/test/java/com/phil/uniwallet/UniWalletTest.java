/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.uniwallet;

import com.phil.uniwallet.models.UniWalletResponse;
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
public class UniWalletTest {
    
    private String merchantId;
    private String apiKey;
    private String productId;
    private Transflow transflow;
    
    public UniWalletTest() {
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
        this.transflow = new Transflow(merchantId, apiKey, productId);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTransflow method, of class UniWallet.
     */
    @Test
    public void testGetTransflow() {
        System.out.println("getTransflow");        
        Transflow expResult = new Transflow(merchantId, apiKey, productId);
        UniWallet instance = new UniWallet(expResult, true);
        Transflow result = instance.getTransflow();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUrlTestEndpoint method, of class UniWallet.
     */
    @Test
    public void testGetTestUrlEndpoint() {
        System.out.println("getTestUrlEndpoint");
        UniWallet instance = new UniWallet(transflow, true);
        String expResult = EndPoints.GET_TEST_ENDPOINT;
        String result = instance.getUrlEndpoint();
        assertEquals(expResult, result);
    }

    /**
     * Test of getUrlTestEndpoint method, of class UniWallet.
     */
    @Test
    public void testGetLiveUrlEndpoint() {
        System.out.println("getTestUrlEndpoint");
        UniWallet instance = new UniWallet(transflow);
        String expResult = EndPoints.GET_LIVE_ENDPOINT;
        String result = instance.getUrlEndpoint();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of setUrlEndpoint method, of class UniWallet.
     */
    @Test
    public void testSetUrlEndpoint() {
        System.out.println("setUrlEndpoint");
        String urlEndpoint = "someEndpoint";
        UniWallet instance = new UniWallet(transflow);
        instance.setUrlEndpoint(urlEndpoint);
        String result = instance.getUrlEndpoint();
        assertEquals(urlEndpoint, result);
    }

    /**
     * Test of getPort method, of class UniWallet.
     */
    @Test
    public void testGetPort() {
        System.out.println("getPort");
        UniWallet instance = new UniWallet(transflow);
        instance.setPort("8080");
        String expResult = "8080";
        String result = instance.getPort();
        assertEquals(expResult, result);
    }

    /**
     * Test of setPort method, of class UniWallet.
     */
    @Test
    public void testSetPort() {
        System.out.println("setPort");
        String port = "8080";
        UniWallet instance = new UniWallet(transflow);
        instance.setPort(port);
        String result = instance.getPort();
        assertEquals(port, result);
    }

    /**
     * Test of getNetworks method, of class UniWallet.
     */
    @Test
    public void testGetNetworks() throws Exception {
        System.out.println("getNetworks");
        UniWallet instance = new UniWallet(transflow, true);
        String[] expResult = new String[0];
        String[] result = instance.getNetworks();
        
        assertEquals(expResult.getClass().getTypeName(), result.getClass().getTypeName());
    }

    /**
     * Test of creditCustomer method, of class UniWallet.
     */
    @Test
    public void testCreditCustomer() throws Exception {
        System.out.println("creditCustomer");
        String referenceNumber = "";
        String msisdn = "";
        String amount = "";
        String network = "";
        String narration = "";
        UniWallet instance = null;
        UniWalletResponse expResult = null;
        UniWalletResponse result = instance.creditCustomer(referenceNumber, msisdn, amount, network, narration);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of debitCustomer method, of class UniWallet.
     */
    @Test
    public void testDebitCustomer() throws Exception {
        System.out.println("debitCustomer");
        String referenceNumber = "";
        String msisdn = "";
        String amount = "";
        String network = "";
        String voucher = "";
        String narration = "";
        UniWallet instance = null;
        UniWalletResponse expResult = null;
        UniWalletResponse result = instance.debitCustomer(referenceNumber, msisdn, amount, network, voucher, narration);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
