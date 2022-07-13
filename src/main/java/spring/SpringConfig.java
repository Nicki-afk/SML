package spring;


import dao.dao_objects.BookDAO;
import dao.dao_objects.ProfileDao;
import managers.DatabaseConfigurationDataProvider;
import managers.DatabaseFilesDataProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;


import java.io.File;

@org.springframework.context.annotation.Configuration
public class SpringConfig {


    @Bean(initMethod = "initMethod" , destroyMethod = "destroyMethod")
    @Lazy
    public ProfileDao profileDao(){
        return new ProfileDao();
    }

    @Bean(initMethod = "initMethod" , destroyMethod = "destroyMethod")
    @Lazy
    public BookDAO bookDAO(){
        return new BookDAO(databaseConfigurationDataProvider());
    }


    @Bean(initMethod = "initMethodWhichCheckAndConfigureDatabaseFiles")
    public DatabaseConfigurationDataProvider databaseConfigurationDataProvider(){
        return new DatabaseConfigurationDataProvider(databaseFilesDataProvider());
    }

    @Bean
    public DatabaseFilesDataProvider databaseFilesDataProvider(){
        return new DatabaseFilesDataProvider(configFile());
    }


    @Bean
    public File configFile(){
        return new File("databaseConfigPackage/configDataBase.properties");
    }

}
