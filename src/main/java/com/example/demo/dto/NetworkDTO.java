package com.example.demo.dto;

import com.example.demo.models.Network;
import com.example.demo.models.ProductTypes;
import com.example.demo.models.Tags;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@ToString
@Builder
public class NetworkDTO {
    private Long id;
    private String networkId;
    private long organizationId;
    private List<String> productTypes;
    private String url;
    private String name;
    private String timeZone;
    private String enrollmentString;
    private List<String> tags;
    private String notes;


    public static Network toNetwork(NetworkDTO network){
        return Network.builder()
                .id(network.id)
                .name(network.name)
                .networkId(network.networkId)
                .timeZone(network.timeZone)
                .url(network.url)
                .enrollmentString(network.enrollmentString)
                .organizationId(network.organizationId)
                .notes(network.notes)
                .productTypes(network.productTypes.stream().map(ProductTypes::new).collect(Collectors.toList()))
                .tags(network.tags.stream().map(Tags::new).collect(Collectors.toList()))
                .build();
    }
}
