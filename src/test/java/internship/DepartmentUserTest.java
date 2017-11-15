package internship;

import internship.dao.DepartmentDao;
import internship.dao.DepartmentDao;
import internship.dao.UserDao;
import internship.models.Department;
import internship.models.Department;
import internship.models.PrivateInfo;
import internship.models.User;
import internship.services.EmfService;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;

public class DepartmentUserTest {

  @Test
  public void testDepartmentUser() {
    DepartmentDao departmentDao = new DepartmentDao();
    UserDao userDao = new UserDao();
    EmfService emfService = new EmfService();

    // Create one Department object
    Department department = new Department(1, "address-1");

    // Ceate three users

    PrivateInfo.Address address1 = new PrivateInfo.Address("street-1", 1, 1);
    PrivateInfo privateInfo1 = new PrivateInfo("111111111", address1, new BigDecimal(1000));
    User user1 = new User(1, "user-1", Instant.now(), privateInfo1);
    department.addUser(user1);

    PrivateInfo.Address address2 = new PrivateInfo.Address("street-2", 2, 2);
    PrivateInfo privateInfo2 = new PrivateInfo("222222222", address2, new BigDecimal(2000));
    User user2 = new User(2, "user-2", Instant.now(), privateInfo2);
    department.addUser(user2);

    PrivateInfo.Address address3 = new PrivateInfo.Address("street-3", 3, 3);
    PrivateInfo privateInfo3 = new PrivateInfo("333333333", address3, new BigDecimal(3000));
    User user3 = new User(3, "user-3", Instant.now(), privateInfo3);
    department.addUser(user3);

    // Save Department object
    departmentDao.save(department);

    // Don't forget to close the entity manager factory
    emfService.closeEntityManager();
  }

}
