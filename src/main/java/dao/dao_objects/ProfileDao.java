package dao.dao_objects;

import dao.interfaces.Dao;
import dao.interfaces.LibraryObject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ProfileDao extends Dao {

    private AnnotationConfigApplicationContext context;
    private Session sessionForWorkWithEntityProfileInDataBase;
    private SessionFactory factoryForOpeAndCloseSession;






    @Override
    public void initMethod(){
     //   context = new AnnotationConfigApplicationContext(HibernateSpringConfig.class);
        sessionForWorkWithEntityProfileInDataBase = context.getBean("session" , Session.class);

        if(!sessionForWorkWithEntityProfileInDataBase.isOpen()){
            factoryForOpeAndCloseSession = context.getBean("factory" , SessionFactory.class);
            sessionForWorkWithEntityProfileInDataBase = factoryForOpeAndCloseSession.openSession();
        }

    }

    @Override
    public void destroyMethod(){
        // ...
    }

    @Override
    public Boolean addLibraryObjectInLibrary(LibraryObject object) {
        return null;
    }

    @Override
    public Boolean deleteLibraryObjectInLibrary(LibraryObject object) {
        return null;
    }

    @Override
    public Boolean updateLibraryObjectInLibrary(LibraryObject object) {
        return null;
    }


//    public List<Book> getAllBooks(){
//
//
//        return null;
//    }
//




}
