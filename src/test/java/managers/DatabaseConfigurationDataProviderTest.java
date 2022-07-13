package managers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.SpringConfig;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseConfigurationDataProviderTest {


    private static DatabaseConfigurationDataProvider provider;


    @BeforeAll
    public static void beforeAll(){
        provider = new AnnotationConfigApplicationContext(SpringConfig.class).getBean("databaseConfigurationDataProvider" , DatabaseConfigurationDataProvider.class);

    }


    @Test
    public void firstStartApplication(){
        assertTrue(DatabaseConfigurationDataProvider.IS_FIRST_START_APPLICATION);
    }

    @Test
    public void isNotFirstStartApplication(){
        assertFalse(DatabaseConfigurationDataProvider.IS_FIRST_START_APPLICATION);
    }

    @Test
    public void nextStartApplication(){
        assertFalse(DatabaseConfigurationDataProvider.IS_FIRST_START_APPLICATION);
    }

}