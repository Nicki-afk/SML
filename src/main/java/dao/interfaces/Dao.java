package dao.interfaces;
import managers.DatabaseConfigurationDataProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public abstract class Dao {


    protected SessionFactory factory;
    protected Session session;
    private DatabaseConfigurationDataProvider dataProviderForHibernateComponents;


//    public Dao(DatabaseConfigurationDataProvider dataProviderForHibernateComponents){
//        this.dataProviderForHibernateComponents = dataProviderForHibernateComponents;
//        this.factory = dataProviderForHibernateComponents.getSessionFactory();
//    }



//    public Dao(SessionFactory factory){
//        this.factory = factory;
//    }

    public Dao(){}




    protected boolean hibernateComponentIsInitialized(){
        return factory == null || dataProviderForHibernateComponents == null;
    }

    public abstract void openFirstSessionAndGetDataLibraryObjects();
    public abstract void destroyMethod();



    public abstract Boolean addLibraryObjectInLibrary(LibraryObject object);
    public abstract Boolean deleteLibraryObjectInLibrary(LibraryObject object);
    public abstract Boolean updateLibraryObjectInLibrary(LibraryObject object);

    public void setDataProviderForHibernateComponents(DatabaseConfigurationDataProvider provider) {
        this.dataProviderForHibernateComponents = provider;
        this.factory = dataProviderForHibernateComponents.getSessionFactory();
    }
}
