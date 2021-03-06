package internship;

import internship.dao.BankDao;
import internship.dao.DepartmentDao;
import internship.models.Bank;
import internship.models.Department;
import internship.services.EmfService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BankDepartmentTest {

  @Test
  public void testBankDepartment() {
    BankDao bankDao = new BankDao();
    DepartmentDao departmentDao = new DepartmentDao();
    EmfService emfService = new EmfService();

    // Create one Bank object
    Bank bank = new Bank(1, "Bank-1");

    // Ceate three departments
    Department dpt1 = new Department(1, "address-1");
    bank.addDepartment(dpt1);

    Department dpt2 = new Department(2, "address-2");
    bank.addDepartment(dpt2);

    Department dpt3 = new Department(3, "address-3");
    bank.addDepartment(dpt3);

    // Save Bank object
    bankDao.save(bank);

    Bank bank1 = bankDao.read(1);
    assertEquals("Bank-1", bank1.getName());

    Department department1 = departmentDao.read(1);
    assertEquals("address-1", department1.getAddress());

    // Don't forget to close the entity manager factory
    emfService.closeEntityManager();
  }

}
