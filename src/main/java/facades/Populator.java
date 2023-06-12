/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import javax.persistence.EntityManagerFactory;

import dtos.FestivalDTO;
import dtos.GuestDTO;
import dtos.ShowDTO;
import entities.Festival;
import entities.Guest;
import utils.EMF_Creator;

/**
 * @author tha
 */
public class Populator {
    public static void populate() {
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

        GuestFacade gf = GuestFacade.getGuestFacade(emf);
        gf.createGuest(new GuestDTO("bro",87654321,"bro@gmail.com","iuus"));
        gf.createGuest(new GuestDTO("BroDude",90909090,"BroDude@gmail.com","VIP"));


        FestivalFacade ff = FestivalFacade.getFestivalFacade(emf);
        ff.createFestival(new FestivalDTO("Bigman","Hvidovre","27/4","2 timer"));
        ff.createFestival(new FestivalDTO("Smallman","ølby","22/5","3 timer"));

//        ShowFacade sf = ShowFacade.getShowFacade(emf);
//        sf.createShow(new ShowDTO("Fast X","1 time","Rødovre","27/4","20:00"));
//        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
//        FacadeExample fe = FacadeExample.getFacadeExample(emf);
//        fe.create(new RenameMeDTO(new RenameMe("First 1", "Last 1")));
//        fe.create(new RenameMeDTO(new RenameMe("First 2", "Last 2")));
//        fe.create(new RenameMeDTO(new RenameMe("First 3", "Last 3")));
    }


    public static void main(String[] args) {
        populate();
    }
}
