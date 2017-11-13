package internship.dao;

import internship.Bank;
import internship.services.BankService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class BankDao {
  public BankService bankService = new BankService();

  public void save(int id, String name) {
    EntityManager manager = bankService.createEntityManager();
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
    EntityManager manager = bankService.createEntityManager();
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
    EntityManager manager = bankService.createEntityManager();
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

  public List readAll() {

    List<Bank> banks = null;

    // Create an EntityManager
    EntityManager manager = bankService.createEntityManager();
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
