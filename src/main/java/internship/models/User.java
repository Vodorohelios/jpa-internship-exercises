package internship.models;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  private Instant lastLogin;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "department_id")
  private Department department;

  @Embedded
  private PrivateInfo privateInfo;

  public User() {}

  public User(Integer id, String name, Instant lastLogin, PrivateInfo privateInfo) {
    this.id = id;
    this.name = name;
    this.lastLogin = lastLogin;
    this.privateInfo = privateInfo;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Instant getLastLogin() {
    return lastLogin;
  }

  public void setLastLogin(Instant lastLogin) {
    this.lastLogin = lastLogin;
  }

  public Department getDepartment() {
    return department;
  }

  public void setDepartment(Department department) {
    this.department = department;
  }

  public PrivateInfo getPrivateInfo() {
    return privateInfo;
  }

  public void setPrivateInfo(PrivateInfo privateInfo) {
    this.privateInfo = privateInfo;
  }
}
