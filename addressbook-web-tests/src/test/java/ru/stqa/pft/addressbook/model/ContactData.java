package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.ManyToAny;
import org.hibernate.annotations.Type;
import org.testng.util.Strings;


import javax.persistence.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="addressbook")
public class ContactData {

  @Id
  @Column(name="id")
  private int id;

  @Column(name="firstname")
  private String firstname;

  @Column(name="middlename")
  private String middlename;

  @Column(name="lastname")
  private String lastname;

  @Column(name="nickname")
  private String nickname;

  @Column(name="company")
  private String company;

  @Column(name="address")
  @Type(type = "text")
  private String address;

  @Column(name="home")
  @Type(type = "text")
  private String homePhone;

  @Column(name="mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Column(name="work")
  @Type(type = "text")
  private String workPhone;

  @Column(name="fax")
  @Type(type = "text")
  private String fax;

  @Column(name="ayear")
  private String ayear;

  @Column(name="address2")
  @Type(type = "text")
  private String address2;

  @Column(name="phone2")
  @Type(type = "text")
  private String phone2;

  @Column(name="notes")
  @Type(type = "text")
  private String notes;

  @ManyToMany(fetch=FetchType.EAGER)
  @JoinTable(name="address_in_groups", joinColumns = @JoinColumn(name="id"), inverseJoinColumns = @JoinColumn(name="group_id"))
  private Set<GroupData> groups = new HashSet<GroupData>();

  @Transient
  private String allPhones;

  @Column(name="email")
  @Type(type = "text")
  private String email;

  @Column(name="email2")
  @Type(type = "text")
  private String email2;

  @Column(name="email3")
  @Type(type = "text")
  private String email3;

  @Transient
  private String allEmail;

  @Transient
  private String allAddress;

  @Column(name="photo")
  @Type(type = "text")
  private String photo;

  public ContactData withId(int id)
  {
    this.id=id;return this; }

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

  public ContactData withHomePhone(String homePhone) {
    this.homePhone=homePhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone=mobilePhone;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone=workPhone;
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
  public ContactData withEmail2(String Email2) {
    this.email2=Email2;
    return this;
  }
  public ContactData withEmail(String Email) {
    this.email=Email;
    return this;
  }
  public ContactData withEmail3(String Email3) {
    this.email3=Email3;
    return this;
  }
  public ContactData withAllEmail(String allEmail) {
    this.allEmail=allEmail;
    return this;
  }
  public ContactData withAllPhones(String allPhones) {
    this.allPhones=allPhones;
    return this;
  }
  public ContactData withAllAddress(String allAddress) {
    this.allAddress=allAddress;
    return this;
  }
  public ContactData withPhoto(File photo) {
    this.photo=photo.getPath();
    return this;
  }
  public ContactData inGroup(GroupData group){
    if (groups == null) {
      groups = new HashSet<>();
    }
    groups.add(group);
    return this;
  }

  public void setId(int id) { this.id=id; }

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

  public String getHomePhone() {
    return homePhone;
  }

  public String getMobilePhone() {
    return mobilePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getEmail2() { return email2; }

  public String getEmail() { return email; }

  public String getEmail3() { return email3; }

  public String getAllEmail() { return allEmail; }

  public String getAllPhones() { return allPhones; }

  public int getId() {
    return id;
  }

  public String getAllAddress() { return allAddress; }

  public File getPhoto() { return new File (photo); }

  @Override
  public String toString() {
    return "ContactData{" + "id=" + id + ", firstname='" + firstname + '\'' + ", middlename='" + middlename + '\'' + "," +
            " lastname='" + lastname + '\'' + ", nickname='" + nickname + '\'' + ", company='" + company + '\'' + ", " +
            "address='" + address + '\'' + ", homePhone='" + homePhone + '\'' + ", mobilePhone='" + mobilePhone + '\'' + ", " +
            "workPhone='" + workPhone + '\'' + ", fax='" + fax + '\'' + ", ayear='" + ayear + '\'' + ", " +
            "address2='" + address2 + '\'' + ", phone2='" + phone2 + '\'' + ", notes='" + notes + '\'' +  /*", " +
            "group='" + group + '\'' + ", allPhones='" + allPhones + '\'' +*/ ", email='" + email + '\'' + "," +
            " email2='" + email2 + '\'' + ", email3='" + email3 + '\'' + ",/* allEmail='" + allEmail + '\'' + ", " +
            "allAddress='" + allAddress + '\'' + ", photo='" + photo + '\'' + '}';
  }


  public Groups getGroups() {
    if (groups == null) {
      groups=new HashSet<>();
      return new Groups(groups);
    }
    return null;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that=(ContactData) o;

    if (id != that.id) return false;

    /*if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;*/
    if (firstname != null && that.firstname != null) {
      if (!firstname.equals(that.firstname)) {
        return false;
      }
    }
   /* if (middlename != null ? !middlename.equals(that.middlename) : that.middlename != null) return false;*/
    if (middlename != null && that.middlename != null) {
      if (!middlename.equals(that.middlename)) {
        return false;
      }
    }

        /* if (lastname != null ? !lastname.equals(that.lastname) : that.lastname != null) return false;*/
    if (lastname != null && that.lastname != null) {
      if (!lastname.equals(that.lastname)) {
        return false;
      }
    }

            /*if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;*/
    if (nickname != null && that.nickname != null) {
      if (!nickname.equals(that.nickname)) {
        return false;
      }
    }

                /*if (company != null ? !company.equals(that.company) : that.company != null) return false;*/
    if (company != null && that.company != null) {
      if (!company.equals(that.company)) {
        return false;
      }
    }

                   /* if (address != null ? !address.equals(that.address) : that.address != null) return false;*/
    if (address != null && that.address != null) {
      if (!address.equals(that.address)) {
        return false;
      }
    }

                        /*if (homePhone != null ? !homePhone.equals(that.homePhone) : that.homePhone != null) return false;*/
    if (homePhone != null && that.homePhone != null) {
      if (!homePhone.equals(that.homePhone)) {
        return false;
      }
    }

                            /*if (mobilePhone != null ? !mobilePhone.equals(that.mobilePhone) : that.mobilePhone != null) return false;*/
    if (mobilePhone != null && that.mobilePhone != null) {
      if (!mobilePhone.equals(that.mobilePhone)) {
        return false;
      }
    }

                                /*if (workPhone != null ? !workPhone.equals(that.workPhone) : that.workPhone != null) return false;*/
    if (workPhone != null && that.workPhone != null) {
      if (!workPhone.equals(that.workPhone)) {
        return false;
      }
    }

                                    /*if (fax != null ? !fax.equals(that.fax) : that.fax != null) return false;*/
    if (fax != null && that.fax != null) {
      if (!fax.equals(that.fax)) {
        return false;
      }
    }


                                      /* if (ayear != null ? !ayear.equals(that.ayear) : that.ayear != null) return false;*/
    if (ayear != null && that.ayear != null) {
      if (!ayear.equals(that.ayear)) {
        return false;
      }
    }

                                            /*if (address2 != null ? !address2.equals(that.address2) : that.address2 != null) return false;*/
    if (address2 != null && that.address2 != null) {
      if (!address2.equals(that.address2)) {
        return false;
      }
    }

                                               /* if (phone2 != null ? !phone2.equals(that.phone2) : that.phone2 != null) return false;*/
    if (phone2 != null && that.phone2 != null) {
      if (!phone2.equals(that.phone2)) {
        return false;
      }
    }

                                                    /*if (notes != null ? !notes.equals(that.notes) : that.notes != null) return false;*/
    if (notes != null && that.notes != null) {
      if (!notes.equals(that.notes)) {
        return false;
      }
    }

                                                        /*if (group != null ? !group.equals(that.group) : that.group != null) return false;*/
    /*if (group != null && that.group != null) {
                                                          /*if (!group.equals(that.group))*/
      /*{
        return false;
      }
    }*/



                                                            /*if (allPhones != null ? !allPhones.equals(that.allPhones) : that.allPhones != null) return false;*/
    if (allPhones != null && that.allPhones != null) {
                                                             /* if (!allPhones.equals(that.allPhones))*/
      {
        return false;
      }
    }

                                                                /*if (email != null ? !email.equals(that.email) : that.email != null) return false;*/
    if (email != null && that.email != null) {
      if (!email.equals(that.email)) {
        return false;
      }
    }

                                                                    /*if (email2 != null ? !email2.equals(that.email2) : that.email2 != null) return false;*/
    if (email2 != null && that.email2 != null) {
      if (!email2.equals(that.email2)) {
        return false;
      }
    }


                                                                       /* if (email3 != null ? !email3.equals(that.email3) : that.email3 != null) return false;*/
    if (email3 != null && that.email3 != null) {
      if (!email3.equals(that.email3)) {
        return false;
      }
    }

                                                                            /*if (allEmail != null ? !allEmail.equals(that.allEmail) : that.allEmail != null) return false;*/
    if (allEmail != null && that.allEmail != null) {
                                                                              /*if (!allEmail.equals(that.allEmail))*/
      {
        return false;
      }
    }

    if (allAddress != null ? !allAddress.equals(that.allAddress) : that.allAddress != null) return false;
    if (allAddress != null && that.allAddress != null) {
      if (!allAddress.equals(that.allAddress)) {
        return false;
      }
    }



                                                                                    return photo != null ? photo.equals(that.photo) : that.photo == null;
  }

                                                                                  @Override
                                                                                  public int hashCode() {
                                                                                    int result=id;
                                                                                    result=31 * result + (firstname != null ? firstname.hashCode() : 0);
                                                                                    result=31 * result + (middlename != null ? middlename.hashCode() : 0);
                                                                                    result=31 * result + (lastname != null ? lastname.hashCode() : 0);
                                                                                    result=31 * result + (nickname != null ? nickname.hashCode() : 0);
                                                                                    result=31 * result + (company != null ? company.hashCode() : 0);
                                                                                    result=31 * result + (address != null ? address.hashCode() : 0);
                                                                                    result=31 * result + (homePhone != null ? homePhone.hashCode() : 0);
                                                                                    result=31 * result + (mobilePhone != null ? mobilePhone.hashCode() : 0);
                                                                                    result=31 * result + (workPhone != null ? workPhone.hashCode() : 0);
                                                                                    result=31 * result + (fax != null ? fax.hashCode() : 0);
                                                                                    result=31 * result + (ayear != null ? ayear.hashCode() : 0);
                                                                                    result=31 * result + (address2 != null ? address2.hashCode() : 0);
                                                                                    result=31 * result + (phone2 != null ? phone2.hashCode() : 0);
                                                                                    result=31 * result + (notes != null ? notes.hashCode() : 0);
                                                                                    /*result=31 * result + (group != null ? group.hashCode() : 0);*/
                                                                                    result=31 * result + (allPhones != null ? allPhones.hashCode() : 0);
                                                                                    result=31 * result + (email != null ? email.hashCode() : 0);
                                                                                    result=31 * result + (email2 != null ? email2.hashCode() : 0);
                                                                                    result=31 * result + (email3 != null ? email3.hashCode() : 0);
                                                                                    result=31 * result + (allEmail != null ? allEmail.hashCode() : 0);
                                                                                    result=31 * result + (allAddress != null ? allAddress.hashCode() : 0);
                                                                                    /*result=31 * result + (photo != null ? photo.hashCode() : 0);*/
                                                                                    return result;
                                                                                  }

}



