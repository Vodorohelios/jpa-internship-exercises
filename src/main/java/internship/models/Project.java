package internship.models;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
//@DiscriminatorColumn(name="PROJ_TYPE")
public abstract class Project {
  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
