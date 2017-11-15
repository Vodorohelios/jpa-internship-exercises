package internship.models;

import javax.persistence.Entity;

@Entity
public class ScalaProject extends Project {
  public String scalaVersion;

  public ScalaProject() {}

  public ScalaProject(String name, String scalaVersion) {
    super.setName(name);
    this.scalaVersion = scalaVersion;
  }

  public String getScalaVersion() {
    return scalaVersion;
  }

  public void setScalaVersion(String scalaVersion) {
    this.scalaVersion = scalaVersion;
  }
}
