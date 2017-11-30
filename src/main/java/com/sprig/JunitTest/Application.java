/*
Last Modified --
11-29-2017 /prasanth/ Extend SpringBootServletInitializer to set the app up as a servlet(as war).
*/
package com.sprig.JunitTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication // combination of @Configuration @EnableAutoConfiguration @ComponentScan
public class Application extends SpringBootServletInitializer {

    //To set the app up as a servlet we extend the main class with SpringBootServletInitializer and override 
    //the configure method using SpringApplicationBuilder(as war).
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    //The main() method uses Spring Boot’s SpringApplication.run() method to launch an application.
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
