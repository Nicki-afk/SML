package dao.interfaces;
import dao.Book;
import dao.DetailsBook;
import dao.Profile;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public abstract class Dao {


    protected SessionFactory factory;
    protected Session session;


    public Dao(){}


    protected void abstractInitHibernateComponents(){
        Configuration configurationForSessionFactory = new Configuration();
        configurationForSessionFactory
                .configure("hibernate/hibernate.cfg.xml")
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Profile.class)
                .addAnnotatedClass(DetailsBook.class);
        this.factory = configurationForSessionFactory.buildSessionFactory();
        this.session = factory.openSession();
    }

    protected boolean hibernateComponentsIsInit(){
        return session == null || factory == null;
    }



    public abstract void openFirstSessionAndGetDataLibraryObjects();



    public abstract Boolean addLibraryObjectInLibrary(LibraryObject object);
    public abstract Boolean deleteLibraryObjectInLibrary(LibraryObject object);
    public abstract Boolean updateLibraryObjectInLibrary(LibraryObject object);


}
