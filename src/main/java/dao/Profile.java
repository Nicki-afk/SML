package dao;

import dao.interfaces.LibraryObject;

import javax.persistence.*;
import javax.print.attribute.standard.MediaSize;
import java.util.List;

@Entity
@Table(name = "profiles")
public class Profile extends LibraryObject {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private Long id;

    @Column(name = "name")             private String theFirstnameProfile;
    @Column(name = "lastname")         private String theLastnameProfile;
    @Column(name = "nphone")           private String theNumberPhoneProfile;
    @Column(name = "email")            private String theEmailProfile;
    @Column(name = "staccount")        private String theStatusAccountProfile;
    @Column(name = "dstatus")          private String theDescriptionStatusAccountProfile;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "rent_table" ,
            joinColumns = @JoinColumn(name = "id") , inverseJoinColumns = @JoinColumn(name = "profile_id"))
    private List<Book> aRentBooksListProfile;


    public Profile(){}

    public Profile(String theFirstnameProfile, String theLastnameProfile, String number_phone, String email) {
        this.theFirstnameProfile = theFirstnameProfile;
        this.theLastnameProfile = theLastnameProfile;
        this.theNumberPhoneProfile = number_phone;
        this.theEmailProfile = email;
    }

    public String getTheFirstnameProfile() {
        return theFirstnameProfile;
    }

    public void setTheFirstnameProfile(String theFirstnameProfile) {
        this.theFirstnameProfile = theFirstnameProfile;
    }

    public String getTheLastnameProfile() {
        return theLastnameProfile;
    }

    public void setTheLastnameProfile(String theLastnameProfile) {
        this.theLastnameProfile = theLastnameProfile;
    }

    public String getTheNumberPhoneProfile() {
        return theNumberPhoneProfile;
    }

    public void setTheNumberPhoneProfile(String theNumberPhoneProfile) {
        this.theNumberPhoneProfile = theNumberPhoneProfile;
    }

    public String getTheEmailProfile() {
        return theEmailProfile;
    }

    public void setTheEmailProfile(String theEmailProfile) {
        this.theEmailProfile = theEmailProfile;
    }


    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", name='" + theFirstnameProfile + '\'' +
                ", lastname='" + theLastnameProfile + '\'' +
                ", number_phone='" + theNumberPhoneProfile + '\'' +
                ", email='" + theEmailProfile + '\'' +
                ", bookList=" + aRentBooksListProfile +
                '}';
    }
}
