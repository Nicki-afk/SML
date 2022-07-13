package dao.dao_objects;

import dao.Book;
import dao.interfaces.Dao;
import dao.interfaces.LibraryObject;
import managers.DatabaseConfigurationDataProvider;

import java.util.HashMap;
import java.util.List;

public class BookDAO extends Dao {


    private HashMap<String,Book> mapBooksWithNameAndBookObjects = new HashMap<>();
 //   @Autowired private Properties propertiesWithDataForDataBase;

    private DatabaseConfigurationDataProvider providerConfigurationHibernate;

    public BookDAO(DatabaseConfigurationDataProvider providerConfigurationHibernate){
        this.providerConfigurationHibernate = providerConfigurationHibernate;
    }

    public BookDAO(){}


    @Override
    public void initMethod() {


        session = factory.openSession();

        session.beginTransaction();
        List<Book>bookList = session.createQuery("SELECT a FROM Book a" , Book.class).getResultList();
        session.getTransaction().commit();


        // copy to HashMap
        if(bookList != null) {
            for (Book book : bookList) {
                mapBooksWithNameAndBookObjects.put(book.getName(), book);}
        }


    }

    @Override
    public void destroyMethod() {

    }

    @Override
    public Boolean addLibraryObjectInLibrary(LibraryObject object) {


        Book book = (Book) object;
        try{

            session.beginTransaction();
            session.save(book);
            session.getTransaction().commit();

            this.mapBooksWithNameAndBookObjects.put(book.getName(), book);


            return true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean deleteLibraryObjectInLibrary(LibraryObject object) {

        try{

            session.beginTransaction();
            session.delete(object);
            session.getTransaction().commit();

            Book book = (Book) object;
            this.mapBooksWithNameAndBookObjects.remove(book.getName());


            return true;


        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public Boolean updateLibraryObjectInLibrary(LibraryObject object) {

        Book book = (Book) object;

        try {
            session.beginTransaction();
            session.update(book);
            session.getTransaction().commit();

            this.mapBooksWithNameAndBookObjects.put(book.getName(),  book);


            return true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }


    public Book getBook(String nameBook){
        return this.mapBooksWithNameAndBookObjects.get(nameBook);
    }


    public HashMap<String,Book> getMapBooksWithNameAndBookObjects() {
        return mapBooksWithNameAndBookObjects;
    }

//    public Properties getPropertiesWithDataForDataBase() {
//        return propertiesWithDataForDataBase;
//    }
//
//    public void setPropertiesWithDataForDataBase(Properties propertiesWithDataForDataBase) {
//        this.propertiesWithDataForDataBase = propertiesWithDataForDataBase;
//    }
}
