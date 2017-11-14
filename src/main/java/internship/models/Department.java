package internship.models;

import javax.persistence.*;

@Entity
public class Department {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer departmentNumber;

  private String address;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "bank_id")
  private Bank bank;

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
}
