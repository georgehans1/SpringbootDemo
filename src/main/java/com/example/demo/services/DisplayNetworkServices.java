package com.example.demo.services;
import com.example.demo.dto.NetworkDTO;
import com.example.demo.dto.ProductTypes;
import com.example.demo.models.Network;
import com.example.demo.repository.NetworkRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DisplayNetworkServices {

    private List<NetworkDTO> myNetworkDTO = new ArrayList<>();

    private final RestTemplate restTemplate;

    @Autowired
    private NetworkRepository networkRepository;


    public DisplayNetworkServices(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }




   public NetworkDTO getData(){
       NetworkDTO networkDTO = restTemplate.getForObject(
               "https://ph1vdun988.execute-api.us-east-2.amazonaws.com/development/iiab/nl/display_network?organizationName=Turntable&networkName=Sprint", NetworkDTO.class);
       log.info("{}", networkDTO);
       NetworkDTO.toNetwork(networkDTO).getProductTypes().stream().map(x -> x.getProductName()).forEach(System.out::println);
       myNetworkDTO.add(networkDTO);
       if(networkDTO != null) {
           Network network2 = NetworkDTO.toNetwork(networkDTO);
           network2.setProductTypes(networkDTO.getProductTypes().stream().map(x -> ProductTypes.builder().productName(x).build()).collect(Collectors.toList()));
           Network network = networkRepository.save(network2);
           System.out.println("My network is " + network.getProductTypes());
       }
       return networkDTO;
   }

    public List<NetworkDTO> getMyNetwork() {
        return networkRepository.findAll().stream().map(Network::toNetworkDTO).collect(Collectors.toList());
    }

    public List<Network> getNetwork(){
        return networkRepository.findAll();
    }


    public List<String> getNetworkName(){
        List<String> networks = myNetworkDTO.stream().map(NetworkDTO::getName).collect(Collectors.toList());
        return networks;
    }


}