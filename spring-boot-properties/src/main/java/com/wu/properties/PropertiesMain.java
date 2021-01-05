package com.wu.properties;


import com.wu.properties.config.PropertiesConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.wu.properties.*")
public class PropertiesMain {

    public static void main(String[] args) {
        SpringApplication.run(PropertiesMain.class);
    }

}