package com.example.demo;

import com.example.demo.dto.NetworkDTO;
import com.example.demo.services.DisplayNetworkServices;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@Slf4j
public class DemoApplication implements CommandLineRunner {

    @Autowired
    private DisplayNetworkServices displayNetworkServices;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
         NetworkDTO networkDto = displayNetworkServices.getData();
         log.info("all networks {}", displayNetworkServices.getMyNetwork());
    }
}
