package dao.dao_objects;

import dao.Book;
import dao.DetailsBook;
import managers.DatabaseConfigurationDataProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.SpringConfig;
import java.util.Date;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class BookDAOTest {



    private static AnnotationConfigApplicationContext context;
    private static BookDAO bookDAO;
    private static DatabaseConfigurationDataProvider manager;

    @BeforeAll
    public static void beforeAll(){

        context = new AnnotationConfigApplicationContext(SpringConfig.class);

       // bookDAO = context.getBean("bookDAO" , BookDAO.class);
        System.out.println(context.getBean("properties" , Properties.class));


    }




    @Test
    @Disabled("THIS TEST IS PASSED!")
    void add() {


        Book book = new Book("Poems");
        DetailsBook detailsBook =
                new DetailsBook
                .DetailsBookBuilder()
                .setAuthor("A.S Pushkin")
                .setGenre("Poem")
                .setDateOfRegistration(new Date())
                .setStatus("OK")
                .setCopy(5)
                .setCopiesAvailable(5)
                .setBook(book)
                .build();

        book.setDetailsBook(detailsBook);
        assertTrue(bookDAO.addLibraryObjectInLibrary(book));
    }



    @Test
    @Disabled("TEST IS PASSED")
    void delete() {

        // passed 15:06:2022

        Book book = bookDAO.getBook("Summer Poem");
        assertTrue(bookDAO.deleteLibraryObjectInLibrary(book));

    }

    @Test
    @Disabled("TEST IS PASSED")
    void update() {

        // passed 17:06:2022

        Book book = bookDAO.getBook("Summer Poem");
        book.setName("Poem Summer A.S Pushkin");
        assertTrue(bookDAO.updateLibraryObjectInLibrary(book));

    }


}