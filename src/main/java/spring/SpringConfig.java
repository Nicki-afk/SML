package spring;


import dao.dao_objects.BookDAO;
import dao.dao_objects.ProfileDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;


import java.io.File;

@org.springframework.context.annotation.Configuration
public class SpringConfig {


    @Bean(initMethod = "openFirstSessionAndGetDataLibraryObjects" , destroyMethod = "destroyMethod")
    @Lazy
    public ProfileDao profileDao(){
        return new ProfileDao();
    }

    @Bean(initMethod = "openFirstSessionAndGetDataLibraryObjects" , destroyMethod = "destroyMethod")
    @Lazy
    public BookDAO bookDAO(){
        return new BookDAO();
    }



    @Bean
    public File configFile(){
        return new File("databaseConfigPackage/configDataBase.properties");
    }

}
