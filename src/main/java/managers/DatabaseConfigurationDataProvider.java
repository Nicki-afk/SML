package managers;

import dao.Book;
import dao.DetailsBook;
import dao.Profile;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.*;
import java.util.Properties;

public class DatabaseConfigurationDataProvider {
    private Properties propertiesDataBase;
    private Configuration configurationForHibernateSessionFactory;
    private SessionFactory sessionFactory;
    private File configurationDatabaseFile;
    public static Boolean IS_FIRST_START_APPLICATION;

    private DatabaseFilesDataProvider providerDataFiles;



    public DatabaseConfigurationDataProvider(){}


    public DatabaseConfigurationDataProvider(DatabaseFilesDataProvider providerDataFiles){
        this.providerDataFiles = providerDataFiles;
        this.configurationDatabaseFile = providerDataFiles.getDatabasePropertiesFile();
    }


    public void initMethodWhichCheckAndConfigureDatabaseFiles(){

        IS_FIRST_START_APPLICATION = isFirstStartApplication();
        if(IS_FIRST_START_APPLICATION){
            providerDataFiles.createStructureFoldersForDataDatabase();
        }else{
            this.propertiesDataBase = providerDataFiles.readPropertiesFileDataBase();
            configureObjectsConfigurationHibernateWithProperties(this.propertiesDataBase);
        }

    }


    private Boolean isFirstStartApplication(){

        if(!configurationDatabaseFile.exists()){
            return true;
        }
        return false;
    }

    public void configureObjectsConfigurationHibernateWithProperties(Properties properties){

        this.propertiesDataBase = properties;
        this.configurationForHibernateSessionFactory = new Configuration();
        this.configurationForHibernateSessionFactory
                .addProperties(properties)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(DetailsBook.class)
                .addAnnotatedClass(Profile.class);
        this.sessionFactory = this.configurationForHibernateSessionFactory.buildSessionFactory();
    }



    public Properties getPropertiesDataBase() {
        return propertiesDataBase;
    }

    public void setPropertiesDataBase(Properties propertiesDataBase) {
        this.propertiesDataBase = propertiesDataBase;
    }

    public Configuration getConfigurationForHibernateSessionFactory() {
        return configurationForHibernateSessionFactory;
    }

    public void setConfigurationForHibernateSessionFactory(Configuration configurationForHibernateSessionFactory) {
        this.configurationForHibernateSessionFactory = configurationForHibernateSessionFactory;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public File getConfigurationDatabaseFile() {
        return configurationDatabaseFile;
    }

    public void setConfigurationDatabaseFile(File configurationDatabaseFile) {
        this.configurationDatabaseFile = configurationDatabaseFile;
    }

    public DatabaseFilesDataProvider getProviderDataFiles() {
        return providerDataFiles;
    }

    public void setProviderDataFiles(DatabaseFilesDataProvider providerDataFiles) {
        this.providerDataFiles = providerDataFiles;
    }
}
