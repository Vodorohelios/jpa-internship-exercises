package internship.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer departmentNumber;

  private String address;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bank_id")
  private Bank bank;

  @OneToMany(
          mappedBy = "department",
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
  private List<User> users = new ArrayList<>();

  public Department() {}

  public Department(Integer departmentNumber, String address) {
    this.departmentNumber = departmentNumber;
    this.address = address;
  }

  public Integer getDepartmentNumber() {
    return departmentNumber;
  }

  public void setDepartmentNumber(Integer departmentNumber) {
    this.departmentNumber = departmentNumber;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Bank getBank() {
    return bank;
  }

  public void setBank(Bank bank) {
    this.bank = bank;
  }

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }

  public void addUser(User user) {
    users.add(user);
    user.setDepartment(this);
  }

  public void removeUser(User user) {
    users.remove(user);
    user.setDepartment(null);
  }
}
