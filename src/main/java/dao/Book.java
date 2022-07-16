package dao;

import dao.interfaces.LibraryObject;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book extends LibraryObject {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;



    @Column(name = "nbook") private String name;



    @OneToOne(mappedBy = "book" , cascade = CascadeType.ALL)
    private DetailsBook detailsBook;



    public Book(){}

    public Book(String name) {
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



    public DetailsBook getDetailsBook() {
        return detailsBook;
    }

    public void setDetailsBook(DetailsBook detailsBook) {
        this.detailsBook = detailsBook;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", detailsBook=" + detailsBook +
                '}';
    }
}
