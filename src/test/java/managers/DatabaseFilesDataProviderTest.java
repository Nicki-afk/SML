package managers;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import patterns.PropertiesBuilder;
import spring.SpringConfig;

import java.io.File;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseFilesDataProviderTest {


    private static DatabaseFilesDataProvider provider;

    @BeforeAll
    public static void beforeAll(){
        provider = new AnnotationConfigApplicationContext(SpringConfig.class).getBean("databaseFilesDataProvider" , DatabaseFilesDataProvider.class);
    }

    @Test
    void createStructureFoldersForDataDatabase() {
        provider.createStructureFoldersForDataDatabase();
        File fileToCheckStructureFolders = new File("databaseConfigPackage/configDataBase.properties");
        assertTrue(fileToCheckStructureFolders.exists());
    }

    @Test
    void readPropertiesFileDataBase() {

        Properties propertiesWithDataFiles = provider.readPropertiesFileDataBase();
        assertEquals("jdbc:postgresql://localhost/testdb?user=postgres&amp;password=abcdef&amp;ssl=false" , propertiesWithDataFiles.get("connection.url"));
        assertEquals("postgres" , propertiesWithDataFiles.get("connection.username"));
        assertEquals("abcdef" , propertiesWithDataFiles.get("connection.password"));
        assertEquals("org.postgresql.Driver" , propertiesWithDataFiles.get("connection.driver.class"));
        assertEquals("org.hibernate.dialect.PostgreSQL94Dialect" , propertiesWithDataFiles.get("hibernate.dialect"));

    }

    @Test
    void writeToFileDatabaseProperties() {

        Properties propertiesToWriteFile =
                new PropertiesBuilder()
                        .setUrl("jdbc:postgresql://localhost/testdb?user=postgres&amp;password=abcdef&amp;ssl=false")
                        .setUserName("postgres")
                        .setConnectionPassword("abcdef")
                        .setDriverClass("org.postgresql.Driver")
                        .setDialect()
                        .buildProperties();

        assertTrue(provider.writeToFileDatabaseProperties(propertiesToWriteFile));
    }
}