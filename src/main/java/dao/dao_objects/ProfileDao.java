package dao.dao_objects;

import dao.Profile;
import dao.interfaces.Dao;
import dao.interfaces.LibraryObject;
import managers.DatabaseConfigurationDataProvider;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ProfileDao extends Dao {
    private Map<String, Profile> theProfilesUserList = new LinkedHashMap<>();
    private DatabaseConfigurationDataProvider providerConfigurationHibernate;


    public ProfileDao(){}

    public ProfileDao(DatabaseConfigurationDataProvider providerConfigurationHibernate){
        if(hibernateComponentIsInitialized()){
            setDataProviderForHibernateComponents(providerConfigurationHibernate);
        }
    }




    @Override
    public void openFirstSessionAndGetDataLibraryObjects(){
//     //   context = new AnnotationConfigApplicationContext(HibernateSpringConfig.class);
//        sessionForWorkWithEntityProfileInDataBase = context.getBean("session" , Session.class);
//
//        if(!sessionForWorkWithEntityProfileInDataBase.isOpen()){
//            factoryForOpeAndCloseSession = context.getBean("factory" , SessionFactory.class);
//            sessionForWorkWithEntityProfileInDataBase = factoryForOpeAndCloseSession.openSession();
//        }

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
