package dao.dao_objects;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.SpringConfig;

class BookDAOTest {


    private static BookDAO bookDaoTestObject;
    private static AnnotationConfigApplicationContext annotationConfigApplicationContext;


    @BeforeAll
    public static void initTestObjectsComponents(){
        annotationConfigApplicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        bookDaoTestObject = annotationConfigApplicationContext.getBean("bookDAO" , BookDAO.class);
    }




    @Test
    void openFirstSessionAndGetDataLibraryObjects() {}


    @Test
    @Disabled
    public void getObjectInLinkedHashMap(){

    }


    @Test
    @Disabled
    public void addBookToLibrary(){

    }

    @Test
    @Disabled
    public void getBookInMap(){

    }


    @Test
    @Disabled
    public void updateBookInLibrary(){

    }


}