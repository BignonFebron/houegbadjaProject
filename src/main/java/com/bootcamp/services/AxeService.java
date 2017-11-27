/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bootcamp.services;

import com.bootcamp.crud.CategorieCRUD;
import com.bootcamp.jpa.entities.Axe;
import com.bootcamp.models.WSAxe;
import com.bootcamp.models.WSAxeList;
import java.sql.SQLException;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author Bignon
 */
@Component
public class AxeService {
    public WSAxe create(Axe axe) throws SQLException{
       WSAxe data = null;
       CategorieCRUD.createAxe(axe);
       data.setAxe(axe);
       
       return data;
    }
    
    public WSAxe update(Axe axe) throws SQLException{
       WSAxe data = null;
       Axe axe1 = CategorieCRUD.findByUniquePropertyAxe("id", axe.getId());
       CategorieCRUD.updateAxe(axe1);
       data.setAxe(CategorieCRUD.findByUniquePropertyAxe("id", axe.getId()));
       
       return data;
    }
    
    public void delete(Axe axe) throws SQLException{
       Axe axe1 = CategorieCRUD.findByUniquePropertyAxe("id", axe.getId());
       CategorieCRUD.deleteAxe(axe1);     
    }
    
   public WSAxe findById(int id) throws SQLException{
       WSAxe data = null;
       Axe axe = CategorieCRUD.findByUniquePropertyAxe("id", id);
       data.setAxe(axe);
       
       return data;
    } 
   
   public WSAxeList findAll() throws SQLException{
       WSAxeList data = null;
       List<Axe> axes =CategorieCRUD.findAllAxe();
       data.setAxes(axes);
       
       return data;
    }
}
