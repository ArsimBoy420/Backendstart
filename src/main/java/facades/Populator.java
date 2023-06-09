/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManagerFactory;

import dtos.RenameMeDTO;
import dtos.UserDTO;
import entities.RenameMe;
import entities.User;
import utils.EMF_Creator;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tha
 */
public class Populator {
    public static void populate() {
//        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
       // User user = new User("Lars", "lars123");
//        List<String> list = new ArrayList<>();
//        UserFacade userFacade = UserFacade.getUserFacade(emf);
//        list.add("admin");
//        userFacade.createUser(new UserDTO("Lars", "lars123", list));
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        FacadeExample fe = FacadeExample.getFacadeExample(emf);
        fe.create(new RenameMeDTO(new RenameMe("First 1", "Last 1")));
        fe.create(new RenameMeDTO(new RenameMe("First 2", "Last 2")));
        fe.create(new RenameMeDTO(new RenameMe("First 3", "Last 3")));
    }


    public static void main(String[] args) {
        populate();
    }
}
