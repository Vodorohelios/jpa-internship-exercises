package internship.dao;

import internship.models.Department;
import internship.models.PrivateInfo;
import internship.models.User;
import internship.services.EmfService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.time.Instant;
import java.util.List;

public class UserDao {
  public EmfService emfService = new EmfService();

  public void save(User user) {
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Save the User object
      manager.merge(user);

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

  public void upate(int id, String name, Instant lastLogin, PrivateInfo privateInfo) {
    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get the User object
      User user = manager.find(User.class, id);

      // Change the values
      user.setName(name);
      user.setLastLogin(lastLogin);
      user.setPrivateInfo(privateInfo);

      // Update the user
      manager.persist(user);

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

  public void delete(int id) {
    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get the user object
      User user = manager.find(User.class, id);

      // Delete the user
      manager.remove(user);

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

  public User read(int id) {

    User user = null;

    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get the User object
      user = manager.find(User.class, id);

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
    return user;
  }

  public List<User> readAll() {

    List<User> users = null;

    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get a List of Users
      users = manager.createQuery("SELECT b FROM Department b",
              User.class).getResultList();

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
    return users;
  }

  public PrivateInfo readPrivateInfo(String phoneNumber) {
    PrivateInfo privateInfo = null;

    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get the PrivateInfo object
      privateInfo = manager.find(PrivateInfo.class, phoneNumber);

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
    return privateInfo;
  }

}
