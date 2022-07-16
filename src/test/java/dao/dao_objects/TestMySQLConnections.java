package dao.dao_objects;

import dao.Book;
import dao.DetailsBook;
import dao.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class TestMySQLConnections {


    private static SessionFactory factoryForOpenSession;
    private static Configuration configurationForSessionFactory;


    @BeforeAll
    public static void beforeAll(){
        configurationForSessionFactory = new Configuration();
        configurationForSessionFactory
                .configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(DetailsBook.class)
                .addAnnotatedClass(Profile.class);
        factoryForOpenSession = configurationForSessionFactory.buildSessionFactory();
    }


    @Test
    @Disabled("TEST PASSED IN 16:07:2022 @Nicki ")
    public void testMySQLConnection(){

        Session session = factoryForOpenSession.openSession();
        session.beginTransaction();
    }

    @Test
    public void testSelectQueryToTableBooksInSMLDatabase(){
        // ...
    }

    @Test
    public void testInsertQueryToTableBooksInSMLDatabase(){
        // ...
    }
    @Test
    public void testUpdateQueryToTableBooksInSMLDatabase(){
      // ...
    }

    @Test
    public void testDeleteQueryToTableBooksInSMLDatabase(){
        // ...
    }
}
