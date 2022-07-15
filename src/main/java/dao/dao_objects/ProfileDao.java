package dao.dao_objects;

import dao.Profile;
import dao.interfaces.Dao;
import dao.interfaces.LibraryObject;
import java.util.*;

public class ProfileDao extends Dao {
    private Map<String, Profile> theProfilesUserList = new LinkedHashMap<>();



    public ProfileDao(){}





    @Override
    public void openFirstSessionAndGetDataLibraryObjects(){

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
