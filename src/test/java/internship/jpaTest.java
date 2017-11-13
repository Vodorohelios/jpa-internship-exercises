package internship;

import internship.dao.BankDao;
import internship.services.BankService;
import org.junit.Test;

import java.util.List;

public class jpaTest {

  @Test
  public void testJpa() {
    BankDao bankDao = new BankDao();
    BankService bankService = new BankService();

    // Create two Three Banks
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

    // Don't forget to close the entity manager factory
    bankService.closeEntityManager();
  }
}
