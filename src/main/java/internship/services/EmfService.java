package internship.services;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EmfService {
  // Create an EntityManagerFactory when you start the application.
  private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = Persistence
          .createEntityManagerFactory("jpapu");

  public EntityManager createEntityManager() {
    return ENTITY_MANAGER_FACTORY.createEntityManager();
  }

  public void closeEntityManager() {
    ENTITY_MANAGER_FACTORY.close();
  }
}
