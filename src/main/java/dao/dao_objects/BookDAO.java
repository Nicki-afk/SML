package dao.dao_objects;

import dao.Book;
import dao.interfaces.Dao;
import dao.interfaces.LibraryObject;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class BookDAO extends Dao {
    private Map<String,Book> mapBooksWithNameAndBookObjects = new LinkedHashMap<>();



    public BookDAO(){}


    @Override
    public void openFirstSessionAndGetDataLibraryObjects() {

        super.session.beginTransaction();
        this.mapBooksWithNameAndBookObjects =
                (Map<String, Book>)
                        session
                        .createQuery("SELECT a FROM Book a")
                        .getResultList()
                        .stream()
                        .collect(Collectors.toMap(Book::getName , book -> book));

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


    public Map<String,Book> getMapBooksWithNameAndBookObjects() {
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
