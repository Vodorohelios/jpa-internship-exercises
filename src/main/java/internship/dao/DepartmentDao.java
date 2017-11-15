package internship.dao;

import internship.models.Bank;
import internship.models.Department;
import internship.services.EmfService;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class DepartmentDao {
  public EmfService emfService = new EmfService();

  public void save(Department department) {
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Save the Bank object
      manager.merge(department);

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

  public void save(int id, String address) {
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Create a new Department object
      Department department = new Department();
      department.setDepartmentNumber(id);
      department.setAddress(address);

      // Save the department object
      manager.merge(department);

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

      // Get the Department object
      Department department = manager.find(Department.class, id);

      // Change the values
      department.setAddress(name);

      // Update the department
      manager.persist(department);

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

      // Get the department object
      Department department = manager.find(Department.class, id);

      // Delete the department
      manager.remove(department);

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

    List<Department> departments = null;

    // Create an EntityManager
    EntityManager manager = emfService.createEntityManager();
    EntityTransaction transaction = null;

    try {
      // Get a transaction
      transaction = manager.getTransaction();
      // Begin the transaction
      transaction.begin();

      // Get a List of Departments
      departments = manager.createQuery("SELECT b FROM Department b",
              Department.class).getResultList();

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
    return departments;
  }

}
