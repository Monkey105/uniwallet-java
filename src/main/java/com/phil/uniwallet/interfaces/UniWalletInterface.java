/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.uniwallet.interfaces;

import com.phil.uniwallet.UniWalletException;
import com.phil.uniwallet.models.UniWalletResponse;
import java.io.IOException;

/**
 *
 * @author Philip
 */
public interface UniWalletInterface {

    /**
     * Get networks from uni wallet
     *
     * @return
     * @throws com.phil.uniwallet.UniWalletException
     */
    public String[] getNetworks() throws UniWalletException;

    /**
     * Debit customer
     * @param referenceNumber
     * @param msisdn
     * @param amount
     * @param network
     * @param voucher
     * @param narraction
     * @return 
     * @throws com.phil.uniwallet.UniWalletException 
     */
    public UniWalletResponse debitCustomer(
            String referenceNumber, String msisdn, String amount, String network,
            String voucher, String narraction
    ) throws UniWalletException;
    
    /**
     * 
     * @param referenceNumber
     * @param msisdn
     * @param amount
     * @param network
     * @param narration
     * @return 
     * @throws com.phil.uniwallet.UniWalletException 
     */
    public UniWalletResponse creditCustomer(
            String referenceNumber, String msisdn, String amount, String network,
            String narration
    ) throws UniWalletException;
    
}
