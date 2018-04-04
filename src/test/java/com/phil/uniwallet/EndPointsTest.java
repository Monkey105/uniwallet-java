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
public class EndPointsTest {

    public EndPointsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void validGetNetworkEndpoint() {
        assertEquals(EndPoints.GET_NETWORKS, "uniwallet/get/available/networks");
    }

    @Test
    public void validCreditCustomerEndpoint() {
        assertEquals(EndPoints.CREDIT_CUSTOMER, "uniwallet/credit/customer");
    }

    @Test
    public void validDebitCustomerEndpoint() {
        assertEquals(EndPoints.DEBIT_CUSTOMER, "uniwallet/debit/customer");
    }

}
