package internship.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Bank {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  private String name;

  @OneToMany(
          mappedBy = "bank",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<Department> departments = new ArrayList<>();

  public Bank() {}

  public Bank(Integer id, String name) {
    this.id = id;
    this.name = name;
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

  public List<Department> getDepartments() {
    return departments;
  }

  public void setDepartments(List<Department> departments) {
    this.departments = departments;
  }

  public void addDepartment(Department department) {
    departments.add(department);
    department.setBank(this);
  }

  public void removeDepartment(Department department) {
    departments.remove(department);
    department.setBank(null);
  }

  @Override
  public String toString() {
    return id + " " + name;
  }
}
