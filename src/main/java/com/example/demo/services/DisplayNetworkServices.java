package com.example.demo.services;
import com.example.demo.api.NetworkResponse;
import com.example.demo.dto.NetworkDTO;
import com.example.demo.models.ProductTypes;
import com.example.demo.models.Network;
import com.example.demo.models.Tags;
import com.example.demo.repository.NetworkRepository;
import com.example.demo.repository.ProductTypeRepository;
import com.example.demo.repository.TagRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class DisplayNetworkServices {

    private final RestTemplate restTemplate;
    private final NetworkRepository networkRepository;
    private final TagRepository tagRepository;
    private final ProductTypeRepository productTypeRepository;



   public NetworkDTO getData(){
       NetworkResponse networkResponse = restTemplate.getForObject(
               "https://ph1vdun988.execute-api.us-east-2.amazonaws.com/development/iiab/nl/display_network?organizationName=Turntable&networkName=Sprint",
               NetworkResponse.class);

       log.info("network response: {}", networkResponse);

       if (networkResponse == null) return null;

       Network network =  networkRepository.save(NetworkResponse.toNetwork(networkResponse));

       networkResponse.getProductTypes().forEach(x -> {
           productTypeRepository.save(ProductTypes.builder().network(network).productName(x).build());
       });

       networkResponse.getTags().forEach(x -> {
           tagRepository.save(Tags.builder().tagName(x).network(network).build());
       });

       network.setTags(tagRepository.findAll());
       network.setProductTypes(productTypeRepository.findAll());

       return Network.toNetworkDTO(network);

   }

    public List<NetworkDTO> getMyNetwork() {
        return networkRepository.findAll().stream().map(Network::toNetworkDTO).collect(Collectors.toList());
    }

    public List<String> getNetworkNames(){

        return networkRepository.findAll()
                .stream()
                .flatMap(x -> x.getProductTypes().stream())
                .map(ProductTypes::getProductName)
                .collect(Collectors.toList());

    }


}