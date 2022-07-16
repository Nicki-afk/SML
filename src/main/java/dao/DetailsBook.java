package dao;

import dao.interfaces.LibraryObject;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "book_details")
public class DetailsBook extends LibraryObject {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column private long id;
    @Column(name = "author")                 private String theAuthorBook;
    @Column(name = "genre")                  private String theGenreBook;
    @Column(name = "date_of_registration")   private String theDateOfRegistrationBook;
    @Column(name = "status")                 private String theStatusBookAvailableOrNotAvailable;
    @Column(name = "sdescription")           private String theDescriptionStatusBook;
    @Column(name = "copy")                   private Integer theCopiesBook;
    @Column(name = "acopy")                  private Integer theCopiesBookAvailable;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_book")
    private Book book;


    public DetailsBook(){}

    public DetailsBook(String theAuthorBook, String theGenreBook,
                       String theDateOfRegistrationBook, String status, Integer theCopiesBook, Integer copies_available) {

        this.theAuthorBook = theAuthorBook;
        this.theGenreBook = theGenreBook;
        this.theDateOfRegistrationBook = theDateOfRegistrationBook;
        this.theStatusBookAvailableOrNotAvailable = status;
        this.theCopiesBook = theCopiesBook;
        this.theCopiesBookAvailable = copies_available;

    }

    public String getTheAuthorBook() {
        return theAuthorBook;
    }

    public void setTheAuthorBook(String theAuthorBook) {
        this.theAuthorBook = theAuthorBook;
    }

    public String getTheGenreBook() {
        return theGenreBook;
    }

    public void setTheGenreBook(String theGenreBook) {
        this.theGenreBook = theGenreBook;
    }

    public String getTheDateOfRegistrationBook() {
        return theDateOfRegistrationBook;
    }

    public void setTheDateOfRegistrationBook(String theDateOfRegistrationBook) {
        this.theDateOfRegistrationBook = theDateOfRegistrationBook;
    }

    public String getTheStatusBookAvailableOrNotAvailable() {
        return theStatusBookAvailableOrNotAvailable;
    }

    public void setTheStatusBookAvailableOrNotAvailable(String theStatusBookAvailableOrNotAvailable) {
        this.theStatusBookAvailableOrNotAvailable = theStatusBookAvailableOrNotAvailable;
    }

    public Integer getTheCopiesBook() {
        return theCopiesBook;
    }

    public void setTheCopiesBook(Integer theCopiesBook) {
        this.theCopiesBook = theCopiesBook;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getTheCopiesBookAvailable() {
        return theCopiesBookAvailable;
    }

    public void setTheCopiesBookAvailable(Integer theCopiesBookAvailable) {
        this.theCopiesBookAvailable = theCopiesBookAvailable;
    }

    @Override
    public String toString() {
        return "DetailsBook{" +
                "author='" + theAuthorBook + '\'' +
                ", genre='" + theGenreBook + '\'' +
                ", date_of_registration='" + theDateOfRegistrationBook + '\'' +
                ", status='" + theStatusBookAvailableOrNotAvailable + '\'' +
                ", copy=" + theCopiesBook +
                ", copies_available=" + theCopiesBookAvailable +
                ", book=" + book +
                '}';
    }



    // It's a help class builder
    public static class DetailsBookBuilder{

        private DetailsBook detailsBook;

        public DetailsBookBuilder(){
            detailsBook = new DetailsBook();
        }


        public DetailsBookBuilder setAuthor(String nameAuthor){

            this.detailsBook.theAuthorBook = nameAuthor;
            return this;
        }

        public DetailsBookBuilder setGenre(String genre){
            this.detailsBook.theGenreBook = genre;
            return this;
        }

        public DetailsBookBuilder setDateOfRegistration(Date date){
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            this.detailsBook.theDateOfRegistrationBook = dateFormat.format(new Date());
            return this;
        }

        public DetailsBookBuilder setStatus(String status){
            this.detailsBook.theStatusBookAvailableOrNotAvailable = status;
            return this;
        }

        public DetailsBookBuilder setCopy(Integer copy){
            this.detailsBook.theCopiesBook = copy;
            return this;
        }

        public DetailsBookBuilder setCopiesAvailable(Integer copiesAvailable){
            this.detailsBook.theCopiesBookAvailable = copiesAvailable;
            return this;
        }

        public DetailsBookBuilder setBook(Book book){
            this.detailsBook.book = book;
            return this;

        }

        public DetailsBook build(){
            return this.detailsBook;
        }

    }
}
