package utils;


import entities.Flag;
import entities.Role;
import entities.User;
import errorhandling.NotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.io.IOException;

public class SetupFlags {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
    EntityManager em = emf.createEntityManager();

    Flag germany = new Flag("Germany", "276");
    Flag england = new Flag("England", "gb-eng");
    Flag wales = new Flag("Wales", "gb-wls");
    Flag scotland = new Flag("Scotland", "gb-sct");
    Flag northIreland = new Flag("North Ireland", "gb-nir");
    Flag france = new Flag("France", "250");
    Flag italy = new Flag("Italy", "380");
    Flag spain = new Flag("Spain", "724");
    Flag ukraine = new Flag("Ukraine", "804");
    Flag russia = new Flag("Russia", "643");
    Flag poland = new Flag("Poland", "616");
    Flag romania = new Flag("Romania", "642");
    Flag netherlands = new Flag("Netherlands", "528");
    Flag belgium = new Flag("Belgium", "056");
    Flag greece = new Flag("Greece", "300");
    Flag portugal = new Flag("Portugal", "620");
    Flag sweden = new Flag("Sweden", "752");
    Flag hungary = new Flag("Hungary", "348");
    Flag belarus = new Flag("Belarus", "112");
    Flag austria = new Flag("Austria", "040");
    Flag serbia = new Flag("Serbia", "688");
    Flag switzerland = new Flag("Switzerland", "756");
    Flag denmark = new Flag("Denmark", "208");
    Flag norway = new Flag("Norway", "578");
    Flag bulgaria = new Flag("Bulgaria", "100");
    Flag finland = new Flag("Finland", "246");
    Flag slovakia = new Flag("Slovakia", "703");
    Flag ireland = new Flag("Ireland", "372");
    Flag croatia = new Flag("Croatia", "191");
    Flag moldova = new Flag("Moldova", "498");
    Flag bosnia = new Flag("Bosnia & Herz.", "070");
    Flag albania = new Flag("Albania", "008");
    Flag lithuania = new Flag("Lithuania", "440");
    Flag northMacedonia = new Flag("North Macedonia", "807");
    Flag slovenia = new Flag("Slovenia", "705");
    Flag latvia = new Flag("Latvia", "428");
    Flag estonia = new Flag("Estonia", "233");
    Flag montenegro = new Flag("Montenegro", "499");
    Flag luxembourg = new Flag("Luxembourg", "442");
    Flag malta = new Flag("Malta", "470");
    Flag iceland = new Flag("Iceland", "352");
    Flag andorra = new Flag("Andorra", "020");
    Flag monaco = new Flag("Monaco", "492");
    Flag liechtenstein = new Flag("Liechtenstein", "438");
    Flag sanMarino = new Flag("San Marino", "674");


    try {
      em.getTransaction().begin();
      em.persist(germany);
      em.persist(england);
      em.persist(wales);
      em.persist(scotland);
      em.persist(northIreland);
      em.persist(france);
      em.persist(italy);
      em.persist(spain);
      em.persist(ukraine);
      em.persist(russia);
      em.persist(poland);
      em.persist(romania);
      em.persist(netherlands);
      em.persist(belgium);
      em.persist(greece);
      em.persist(portugal);
      em.persist(sweden);
      em.persist(hungary);
      em.persist(belarus);
      em.persist(austria);
      em.persist(serbia);
      em.persist(switzerland);
      em.persist(denmark);
      em.persist(norway);
      em.persist(bulgaria);
      em.persist(finland);
      em.persist(slovakia);
      em.persist(finland);
      em.persist(ireland);
      em.persist(croatia);
      em.persist(moldova);
      em.persist(bosnia);
      em.persist(albania);
      em.persist(lithuania);
      em.persist(northMacedonia);
      em.persist(slovenia);
      em.persist(latvia);
      em.persist(estonia);
      em.persist(montenegro);
      em.persist(luxembourg);
      em.persist(malta);
      em.persist(iceland);
      em.persist(andorra);
      em.persist(monaco);
      em.persist(liechtenstein);
      em.persist(sanMarino);

      em.getTransaction().commit();
    } finally {
      em.close();
    }
  }







}
