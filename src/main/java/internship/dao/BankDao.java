package internship.dao;

import internship.models.Bank;
import internship.services.EmfService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BankDao {
  public EmfService emfService = new EmfService();

  public void save(Bank bank) {
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Save the Bank object
      manager.merge(bank);

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

  public void save(int id, String name) {
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Create a new Bank object
      Bank bank = new Bank();
      bank.setId(id);
      bank.setName(name);

      // Save the bank object
      manager.merge(bank);

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

  public void upate(int id, String name) {
    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get the Bank object
      Bank bank = manager.find(Bank.class, id);

      // Change the values
      bank.setName(name);

      // Update the bank
      manager.persist(bank);

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

      // Get the bank object
      Bank bank = manager.find(Bank.class, id);

      // Delete the bank
      manager.remove(bank);

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

  public Bank read(int id) {

    Bank bank = null;

    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get a Bank object by its id
      bank = manager.createQuery("SELECT b FROM Bank b where id = :id",
              Bank.class).setParameter("id", id).getSingleResult();

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
    return bank;
  }

  public List<Bank> readAll() {

    List<Bank> banks = null;

    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get a List of Banks
      banks = manager.createQuery("SELECT b FROM Bank b",
              Bank.class).getResultList();

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
    return banks;
  }

}
