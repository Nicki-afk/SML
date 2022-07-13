package patterns;

import org.springframework.beans.factory.annotation.Value;

import java.util.Properties;

public class PropertiesBuilder {

    private Properties properties;

    {
        properties = new Properties();
    }

    public PropertiesBuilder setUrl(String url){
        this.properties.setProperty("connection.url" , url);
        return this;
    }

    public PropertiesBuilder setDriverClass(String driverClass){
        this.properties.setProperty("connection.driver.class" , driverClass);
        return this;
    }

    public PropertiesBuilder setUserName(String userName){
        this.properties.setProperty("connection.username" , userName);
        return this;

    }
    public PropertiesBuilder setConnectionPassword(String password){
        this.properties.setProperty("connection.password" , password);
        return this;
    }

    public PropertiesBuilder setCurrentSessionContextClass(){
        this.properties.setProperty("current.session.context.class" , "thread");
        return this;
    }

    public PropertiesBuilder setDialect(){
        this.properties.setProperty("hibernate.dialect" , "org.hibernate.dialect.PostgreSQL94Dialect");
        return this;
    }

    public PropertiesBuilder setShowSql(boolean showSql){
        this.properties.setProperty("show.sql" , Boolean.toString(showSql));
        return this;
    }

    public Properties buildProperties(){
        return properties;
    }

}
