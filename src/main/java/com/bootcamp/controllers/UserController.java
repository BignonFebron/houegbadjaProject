package com.bootcamp.controllers;

import com.bootcamp.jpa.entities.User;
import com.bootcamp.models.WSUser;
import com.bootcamp.models.WSUserList;
import com.bootcamp.services.UserService;
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


@RestController("UserController")
@RequestMapping("/user")
@Api(value = "User API", description = "User API")
public class UserController {
    
    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "Create a new user", notes = "Create a new user")
    public ResponseEntity<WSUser> create(@RequestBody @Valid User user) {
        
        WSUser userWS = new WSUser();
        try {
            userWS = userService.create(user);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<WSUser>((WSUser) userWS, httpStatus);
        } catch (SQLException e) {
            userWS.setErrorMsg(e.getMessage());
            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<WSUser>((WSUser) userWS, httpStatus);
        }       
        //return new ResponseEntity<User>(new User(), httpStatus);
    }
    
  @RequestMapping(method = RequestMethod.PUT, value = "/update")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "update a user", notes = "update a user")
    public ResponseEntity<WSUser> update(@RequestBody @Valid User user) {
        WSUser userWS = new WSUser();
        try {
            userWS = userService.update(user);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<WSUser>((WSUser) userWS, httpStatus);
        } catch (SQLException e) {
            userWS.setErrorMsg(e.getMessage());
            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<WSUser>((WSUser) userWS, httpStatus);
        }       
        //return new ResponseEntity<User>(new User(), httpStatus);
    }  
    
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "get list of users", notes = "get list of users")
    public ResponseEntity<WSUserList> findAll() {
        WSUserList usersWS = null;
        try {
            usersWS = userService.findAll();
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<WSUserList>((WSUserList) usersWS, httpStatus);
        } catch (SQLException e) {
            usersWS.setErrorMsg(e.getMessage());
            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<WSUserList>((WSUserList) usersWS, httpStatus);
        }       
        //return new ResponseEntity<User>(new User(), httpStatus);
    }
    
     @RequestMapping(method = RequestMethod.GET, value = "/find/{id}")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "find an user by it id", notes = "find an user by it id")
    public ResponseEntity<WSUser> findById(@PathVariable int id) {
        WSUser userWS = new WSUser();
        try {
            userWS = userService.findById(id);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<WSUser>((WSUser) userWS, httpStatus);
        } catch (SQLException e) {
            userWS.setErrorMsg(e.getMessage());
            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<WSUser>((WSUser) userWS, httpStatus);
        }       
        //return new ResponseEntity<User>(new User(), httpStatus);
    }  
    
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    @ApiVersions({"1.0"})
    @ApiOperation(value = "delete an user", notes = "delete an user")
    public ResponseEntity<String> delete(@RequestBody @Valid User user) {
        WSUser userWS = new WSUser();
        try {
            userService.delete(user);
            HttpStatus httpStatus = HttpStatus.OK;
            return new ResponseEntity<String>((String) "success of the delete", httpStatus);
        } catch (SQLException e) {
            userWS.setErrorMsg(e.getMessage());
            HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return new ResponseEntity<String>((String) "delete fail", httpStatus);
        }       
        //return new ResponseEntity<User>(new User(), httpStatus);
    }  
}
