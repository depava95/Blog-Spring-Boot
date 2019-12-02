package ua.biedin.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.event.EventListener;

import java.util.Arrays;

@SpringBootApplication
public class BlogApplication {


    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);

    }

/*

 Get all beans!

 @Autowired
    ApplicationContext applicationContext;

    @EventListener(ApplicationReadyEvent.class)
    public void printBeans() {
        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
        for (String s : beanDefinitionNames) {
            System.out.println(s);
        }
    }*/
}
