package com.jalasoft.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author HP
 * @version 1.1
 */
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello.");
        SpringApplication.run(Main.class, args);
    }
}
