package com.example.crudproduct.config.properties;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
@Data
//@StringBuilder
public class DatabaseProperties {
    public static void main(String[] args){
        DatabaseProperties dbProps = new DatabaseProperties();
        System.err.println(dbProps);
    }
    private String url;
    private String username;
    private String password;
    private String driver;
    public DatabaseProperties(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream input = classLoader.getResourceAsStream("application.properties");
        try {
            Properties properties = new Properties();
            properties.load(input);
            this.setUrl(properties.getProperty("database.properties.url").trim());
            this.setUsername(properties.getProperty("database.properties.username").trim());
            this.setPassword(properties.getProperty("database.properties.password").trim()); // todo : hashcode  -> decode
            this.setDriver(properties.getProperty("database.properties.driver-class-name").trim());
        } catch (IOException e) {
            System.err.println("Cannot read file properties \n");
            e.printStackTrace();
        }
    }
}