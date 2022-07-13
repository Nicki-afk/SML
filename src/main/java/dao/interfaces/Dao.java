package dao.interfaces;

import dao.Book;
import dao.DetailsBook;
import dao.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

public abstract class Dao {


    protected SessionFactory factory;
    protected Session session;



//    public Dao(SessionFactory factory){
//        this.factory = factory;
//    }

    public Dao(){}



    public abstract void initMethod();
    public abstract void destroyMethod();



    public abstract Boolean addLibraryObjectInLibrary(LibraryObject object);
    public abstract Boolean deleteLibraryObjectInLibrary(LibraryObject object);
    public abstract Boolean updateLibraryObjectInLibrary(LibraryObject object);




}
