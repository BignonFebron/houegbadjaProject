/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.services;

import com.bootcamp.crud.UserCRUD;
import com.bootcamp.jpa.entities.Projet;
import com.bootcamp.jpa.entities.User;
import com.bootcamp.models.WSUser;
import com.bootcamp.models.WSUserList;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bignon
 */
@Component
public class UserService {
    public WSUser create(User user) throws SQLException{
       WSUser data = null;
       UserCRUD.create(user);
       data.setUser(user);
       
       return data;
    }
    
    public WSUser update(User user) throws SQLException{
       WSUser data = null;
       User user1 = UserCRUD.findByPropertyUnique("id", user.getId());
       UserCRUD.update(user1);
       data.setUser(UserCRUD.findByPropertyUnique("id", user.getId()));
       
       return data;
    }
    
    public void delete(User user) throws SQLException{
       User user1 = UserCRUD.findByPropertyUnique("id", user.getId());
       UserCRUD.delete(user1);     
    }
    
   public WSUser findById(int id) throws SQLException{
       WSUser data = null;
       User user = UserCRUD.findByPropertyUnique("id", id);
       data.setUser(user);
       
       return data;
    } 
   
   public WSUserList findAll() throws SQLException{
       WSUserList data = null;
       List<User> users =UserCRUD.findAll();
       data.setUsers(users);
       
       return data;
    }
}
