package internship;

import internship.dao.JavaProjectDao;
import internship.models.JavaProject;
import internship.services.EmfService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HierarchyTest {

  @Test
  public void testHierarchy() {
    EmfService emfService = new EmfService();
    JavaProjectDao javaProjectDao = new JavaProjectDao();

    JavaProject javaProject = new JavaProject("Project-1", "1.0");
    javaProjectDao.save(javaProject);

//    JavaProject foundJavaProject = javaProjectDao.read(javaProject.getName());
//
//    assertEquals(javaProject.getName(), foundJavaProject.getName());
  }
}
