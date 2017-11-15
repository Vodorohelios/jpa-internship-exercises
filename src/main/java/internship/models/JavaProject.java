package internship.models;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class JavaProject extends Project {
  public String javaVersion;

  public JavaProject() {}

  public JavaProject(String name, String javaVersion) {
    super.setName(name);
    this.javaVersion = javaVersion;
  }

  public String getJavaVersion() {
    return javaVersion;
  }

  public void setJavaVersion(String javaVersion) {
    this.javaVersion = javaVersion;
  }
}
