package internship;

import internship.dao.UserDao;
import internship.models.PrivateInfo;
import internship.models.User;
import internship.services.EmfService;
import org.hibernate.MappingException;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.Instant;

import static org.junit.Assert.assertNotNull;

public class UserTest {

  @Test(expected = Exception.class)
  public void testUser() {
    EmfService emfService = new EmfService();
    UserDao userDao = new UserDao();

    PrivateInfo.Address address1 = new PrivateInfo.Address("street-1", 1, 1);
    PrivateInfo privateInfo1 = new PrivateInfo("111111111", address1, new BigDecimal(1000));
    User user1 = new User(1, "user-1", Instant.now(), privateInfo1);

    userDao.save(user1);

    PrivateInfo foundPrivateInfo = userDao.readPrivateInfo(user1.getPrivateInfo().getPhoneNumber());
  }
}
