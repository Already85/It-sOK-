package ru.stqa.pft.addressbook.model;

public class ContactData {

  @Override
  public String toString() {
    return "ContactData{" + "id='" + id + '\'' + ", lastname='" + lastname + '\'' + ", address='" + address + '\'' +'}';
  }

  public ContactData withId(int id)
  {
    this.id=id;
  return this;
  }

  public ContactData withAyear(String ayear) {
    this.ayear=ayear;
    return this;
  }

  public ContactData withFirstname(String firstname) {
    this.firstname=firstname;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename=middlename;
    return this;
  }

  public ContactData withLastname(String lastname) {
    this.lastname=lastname;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname=nickname;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company=company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address=address;
    return this;
  }

  public ContactData withHome(String home) {
    this.home=home;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile=mobile;
    return this;
  }

  public ContactData withWork(String work) {
    this.work=work;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax=fax;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2=address2;
    return this;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2=phone2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes=notes;
    return this;
  }
  private int id = Integer.MAX_VALUE;
  private String firstname;
  private String middlename;
  private String lastname;
  private String nickname;
  private String company;
  private String address;
  private String home;
  private String mobile;
  private String work;
  private String fax;
  private String ayear;
  private String address2;
  private String phone2;
  private String notes;

  public int getId() {
    return id;
  }
/*
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
*/
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that=(ContactData) o;

    if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;
    return address != null ? address.equals(that.address) : that.address == null;
  }

  @Override
  public int hashCode() {
    int result=lastname != null ? lastname.hashCode() : 0;
    result=31 * result + (address != null ? address.hashCode() : 0);
    return result;
  }

  /*public ContactData(String firstname, String middlename, String lastname, String nickname, String company, String address, String home, String mobile, String work, String fax, String ayear, String address2, String phone2, String notes) {

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

*/
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
