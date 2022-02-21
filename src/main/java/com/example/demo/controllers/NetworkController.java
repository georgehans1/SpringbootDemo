package com.example.demo.controllers;

import com.example.demo.services.DisplayNetworkServices;
import com.example.demo.dto.NetworkDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class NetworkController {
    @Autowired
    private DisplayNetworkServices displayNetworkServices;

    @GetMapping
    public List<NetworkDTO> findNetwork(){
        return displayNetworkServices.getMyNetwork();
    }
}
