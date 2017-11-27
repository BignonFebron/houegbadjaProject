/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.models;

import com.bootcamp.jpa.entities.Axe;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bignon
 */
@Component
public class WSAxeList {
    private List<Axe> axes;
    private String errorMsg;

    public List<Axe> getAxes() {
        return axes;
    }

    public void setAxes(List<Axe> axes) {
        this.axes = axes;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    
}
