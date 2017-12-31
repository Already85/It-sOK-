package ru.stqa.pft.addressbook.model;

public class ContactData {

  @Override
  public String toString() {
    return "ContactData{" + "id='" + id + '\'' + ", lastname='" + lastname + '\'' + ", address='" + address + '\'' +'}';
  }

  public void setId(int id) {
    this.id=id;
  }


  private int id;
  private final String firstname;
  private final String middlename;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String home;
  private final String mobile;
  private final String work;
  private final String fax;
  private final String ayear;
  private final String address2;
  private final String phone2;
  private final String notes;

  public int getId() {
    return id;
  }

  public ContactData(int id, String firstname, String middlename, String lastname, String nickname, String company, String address, String home, String mobile, String work, String fax, String ayear, String address2, String phone2, String notes) {

    this.id = id;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.ayear = ayear;
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that=(ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return address != null ? address.equals(that.address) : that.address == null;
  }

  @Override
  public int hashCode() {
    int result=firstname != null ? firstname.hashCode() : 0;
    result=31 * result + (lastname != null ? lastname.hashCode() : 0);
    result=31 * result + (address != null ? address.hashCode() : 0);
    return result;
  }

  public ContactData(String firstname, String middlename, String lastname, String nickname, String company, String address, String home, String mobile, String work, String fax, String ayear, String address2, String phone2, String notes) {

    this.id = Integer.MAX_VALUE;
    this.firstname = firstname;
    this.middlename = middlename;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.home = home;
    this.mobile = mobile;

    this.work = work;
    this.fax = fax;
    this.ayear = ayear;
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
  }


  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String getAyear() {
    return ayear;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  public String getNotes() {
    return notes;
  }
}
