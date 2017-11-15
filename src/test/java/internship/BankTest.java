package internship;

import internship.dao.BankDao;
import internship.models.Bank;
import internship.services.EmfService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class BankTest {

  @Test
  public void testJpa() {
    BankDao bankDao = new BankDao();
    EmfService emfService = new EmfService();

    // Create three Banks
    bankDao.save(1, "Bank-1"); // Bank-1 will get an id 1
    bankDao.save(2, "Bank-2");
    bankDao.save(3, "Bank-3");

    // Update the name of Bank-1 using the id
    bankDao.upate(1, "Updated-Bank-1");

    // Delete the Bank-3 from database
    bankDao.delete(3);

    // Print all the Banks
    List<Bank> banks = bankDao.readAll();
    if (banks != null) {
      for (Bank b : banks) {
        System.out.println(b);
      }
    }

    Bank bank1 = bankDao.read(1);
    Bank bank2 = bankDao.read(2);

    assertEquals("Updated-Bank-1", bank1.getName());
    assertEquals("Bank-2", bank2.getName());

    // Don't forget to close the entity manager factory
    emfService.closeEntityManager();
  }
}
