package internship.models;

import javax.persistence.Embeddable;
import java.math.BigDecimal;

@Embeddable
public class PrivateInfo {
  public String phoneNumber;

  public Address address;

  public BigDecimal salary;

  @Embeddable
  public static class Address {
    public String street;

    public Integer house;

    public Integer apartment;

    public Address() {}

    public Address(String street, Integer house, Integer apartment) {
      this.street = street;
      this.house = house;
      this.apartment = apartment;
    }

    public String getStreet() {
      return street;
    }

    public void setStreet(String street) {
      this.street = street;
    }

    public Integer getHouse() {
      return house;
    }

    public void setHouse(Integer house) {
      this.house = house;
    }

    public Integer getApartment() {
      return apartment;
    }

    public void setApartment(Integer apartment) {
      this.apartment = apartment;
    }
  }

  public PrivateInfo() {}

  public PrivateInfo(String phoneNumber, Address address, BigDecimal salary) {
    this.phoneNumber = phoneNumber;
    this.address = address;
    this.salary = salary;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }
}
