package managers;

import java.io.*;
import java.util.Enumeration;
import java.util.Properties;

public  class DatabaseFilesDataProvider {

    private File databasePropertiesFile;


    public DatabaseFilesDataProvider(File file){
        this.databasePropertiesFile = file;
    }

    public DatabaseFilesDataProvider(){}



    public void createStructureFoldersForDataDatabase(){
        try{

            File directoryConfigFileDataBase = new File("databaseConfigPackage"), fileConfigDatabase = new File("databaseConfigPackage\\configDataBase.properties");
            directoryConfigFileDataBase.mkdir();
            fileConfigDatabase.createNewFile();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Properties readPropertiesFileDataBase(){
        Properties propertiesDataDatabaseFile = new Properties();

        try{
            try(BufferedReader reader = new BufferedReader(new FileReader(databasePropertiesFile))){
                String i = "";
                while ((i = reader.readLine()) != null){
                    propertiesDataDatabaseFile.setProperty(i.substring(0 , i.indexOf('=')).trim() , i.substring(i.indexOf('=')+1).trim());
                }

            }
            return propertiesDataDatabaseFile;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    /*
        Функция перезаписывает файл свойств БД , после чего потребуется перезапустить
        приложение , так как новые данные не были установлены , и настроены в Hibernate
     */
    public Boolean writeToFileDatabaseProperties(Properties propertiesToWriteToFile){

        try {
            try(
                    BufferedWriter writer = new BufferedWriter(new FileWriter(databasePropertiesFile))

            ){

                Enumeration enumerationKeysProperties = propertiesToWriteToFile.keys() , enumerationValueProperties = propertiesToWriteToFile.elements();
                while (enumerationKeysProperties.hasMoreElements()){
                    writer.write(enumerationKeysProperties.nextElement() + "=" + enumerationValueProperties.nextElement() + "\n");
                }
                writer.flush();
            }
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }


    public File getDatabasePropertiesFile() {
        return databasePropertiesFile;
    }

    public void setDatabasePropertiesFile(File databasePropertiesFile) {
        this.databasePropertiesFile = databasePropertiesFile;
    }
}
