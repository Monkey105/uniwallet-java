/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.uniwallet.interfaces;

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
     * @throws IOException
     */
    public String[] getNetworks() throws IOException;

    /**
     * Debit customer
     * @param referenceNumber
     * @param msisdn
     * @param amount
     * @param network
     * @param voucher
     * @param narraction
     * @return 
     * @throws IOException 
     */
    public UniWalletResponse debitCustomer(
            String referenceNumber, String msisdn, String amount, String network,
            String voucher, String narraction
    ) throws IOException;
    
    /**
     * 
     * @param referenceNumber
     * @param msisdn
     * @param amount
     * @param network
     * @param narration
     * @return 
     * @throws IOException 
     */
    public UniWalletResponse creditCustomer(
            String referenceNumber, String msisdn, String amount, String network,
            String narration
    ) throws IOException;
    
}
