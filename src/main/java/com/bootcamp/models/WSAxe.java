/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.models;

import com.bootcamp.jpa.entities.Axe;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bignon
 */
@Component
public class WSAxe {
    private Axe axe;
    private String errorMsg;

    public WSAxe() {
    }

    public Axe getAxe() {
        return axe;
    }

    public void setAxe(Axe axe) {
        this.axe = axe;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
    
    
}
