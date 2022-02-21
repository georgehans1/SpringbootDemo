package com.example.demo;

import com.example.demo.services.DisplayNetworkServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private DisplayNetworkServices displayNetworkServices;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
         displayNetworkServices.getData();
        System.out.println(displayNetworkServices.getMyNetwork());
    }
}