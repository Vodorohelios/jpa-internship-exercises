package internship.dao;

import internship.models.Bank;
import internship.models.JavaProject;
import internship.models.User;
import internship.services.EmfService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class JavaProjectDao {

  public EmfService emfService = new EmfService();

  public void save(JavaProject javaProject) {
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Save the JavaProject object
      manager.merge(javaProject);

      // Commit the transaction
      transaction.commit();
    }
    catch (Exception ex) {
      // If there are any exceptions, roll back the changes
      if (transaction != null) {
        transaction.rollback();
      }
      ex.printStackTrace();
    }
    finally {
      manager.close();
    }
  }

  public void delete(String name) {
    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get the javaProject object
      JavaProject javaProject = manager.find(JavaProject.class, name);

      // Delete the javaProject
      manager.remove(javaProject);

      // Commit the transaction
      transaction.commit();
    } catch (Exception ex) {
      // If there are any exceptions, roll back the changes
      if (transaction != null) {
        transaction.rollback();
      }
      // Print the Exception
      ex.printStackTrace();
    } finally {
      // Close the EntityManager
      manager.close();
    }
  }

  public JavaProject read(String name) {

    JavaProject javaProject = null;

    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get the User object
      javaProject = manager.find(JavaProject.class, name);

      // Commit the transaction
      transaction.commit();
    } catch (Exception ex) {
      // If there are any exceptions, roll back the changes
      if (transaction != null) {
        transaction.rollback();
      }
      // Print the Exception
      ex.printStackTrace();
    } finally {
      // Close the EntityManager
      manager.close();
    }
    return javaProject;
  }

}
