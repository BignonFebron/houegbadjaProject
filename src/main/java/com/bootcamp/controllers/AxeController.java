package com.bootcamp.controllers;

import com.bootcamp.jpa.entities.Axe;
import com.bootcamp.models.WSAxe;
import com.bootcamp.models.WSAxeList;
import com.bootcamp.services.AxeService;
import com.bootcamp.version.ApiVersions;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.sql.SQLException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController("AxeController")
@RequestMapping("/axe")
@Api(value = "Axe API", description = "Axe API")
public class AxeController {
    
    @Autowired
    AxeService axeService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new axe", notes = "Create a new axe")
    public ResponseEntity<WSAxe> create(@RequestBody @Valid Axe axe) {
        
        WSAxe axeWS = new WSAxe();
        try {
            axeWS = axeService.create(axe);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<WSAxe>((WSAxe) axeWS, httpStatus);
        } catch (SQLException e) {
            axeWS.setErrorMsg(e.getMessage());
            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<WSAxe>((WSAxe) axeWS, httpStatus);
        }       
        //return new ResponseEntity<Axe>(new Axe(), httpStatus);
    }
    
  @RequestMapping(method = RequestMethod.PUT, value = "/update")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "update a axe", notes = "update a axe")
    public ResponseEntity<WSAxe> update(@RequestBody @Valid Axe axe) {
        WSAxe axeWS = new WSAxe();
        try {
            axeWS = axeService.update(axe);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<WSAxe>((WSAxe) axeWS, httpStatus);
        } catch (SQLException e) {
            axeWS.setErrorMsg(e.getMessage());
            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<WSAxe>((WSAxe) axeWS, httpStatus);
        }       
        //return new ResponseEntity<Axe>(new Axe(), httpStatus);
    }  
    
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "get list of axes", notes = "get list of axes")
    public ResponseEntity<WSAxeList> findAll() {
        WSAxeList axesWS = null;
        try {
            axesWS = axeService.findAll();
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<WSAxeList>((WSAxeList) axesWS, httpStatus);
        } catch (SQLException e) {
            axesWS.setErrorMsg(e.getMessage());
            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<WSAxeList>((WSAxeList) axesWS, httpStatus);
        }       
        //return new ResponseEntity<Axe>(new Axe(), httpStatus);
    }
    
     @RequestMapping(method = RequestMethod.GET, value = "/find/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "find an axe by it id", notes = "find an axe by it id")
    public ResponseEntity<WSAxe> findById(@PathVariable int id) {
        WSAxe axeWS = new WSAxe();
        try {
            axeWS = axeService.findById(id);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<WSAxe>((WSAxe) axeWS, httpStatus);
        } catch (SQLException e) {
            axeWS.setErrorMsg(e.getMessage());
            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<WSAxe>((WSAxe) axeWS, httpStatus);
        }       
        //return new ResponseEntity<Axe>(new Axe(), httpStatus);
    }  
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "delete an axe", notes = "delete an axe")
    public ResponseEntity<String> delete(@RequestBody @Valid Axe axe) {
        WSAxe axeWS = new WSAxe();
        try {
            axeService.delete(axe);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<String>((String) "success of the delete", httpStatus);
        } catch (SQLException e) {
            axeWS.setErrorMsg(e.getMessage());
            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<String>((String) "delete fail", httpStatus);
        }       
        //return new ResponseEntity<Axe>(new Axe(), httpStatus);
    }  
}
