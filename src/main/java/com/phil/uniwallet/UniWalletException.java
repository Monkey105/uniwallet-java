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
public class UniWalletException extends Exception {

    public UniWalletException(String message) {
        super(message);
    }

    public UniWalletException(String message, Throwable cause) {
        super(message, cause);
    }

}
