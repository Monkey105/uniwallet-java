/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.phil.uniwallet.models;

import org.json.JSONObject;

/**
 *
 * @author Philip
 */
public class UniWalletResponse {
    private String responseMessage;
    private boolean successful;
    
    public UniWalletResponse(JSONObject jSONObject) {
        this.deduceStatusCode(jSONObject);
    }

    private void deduceStatusCode(JSONObject jSONObject) {
        String responseCode = jSONObject.getString("responseCode");
        String message = jSONObject.getString("responseMessage");
        
        this.responseMessage = message;
        switch(responseCode) {
            case "01":
            case "03":
                this.successful = true;
                break;
            case "100":
            case "106":
            case "107":
            case "108":
            case "110":
            case "111":
            case "112":
                this.successful = false;
                break;
        }
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }    

    public boolean isSuccessful() {
        return successful;
    }
    
}
