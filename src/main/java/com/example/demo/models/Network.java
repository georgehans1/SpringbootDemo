package com.example.demo.models;

import com.example.demo.dto.NetworkDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Network {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String networkId;

    private long organizationId;
    private String url;
    private String name;
    private String timeZone;
    private String enrollmentString;
    private String notes;

    @OneToMany(mappedBy = "network", fetch = FetchType.LAZY)
    private List<ProductTypes> productTypes;

    @OneToMany(mappedBy = "network", fetch = FetchType.LAZY)
    private List<Tags> tags ;


    public static NetworkDTO toNetworkDTO(Network network){
        return NetworkDTO.builder()
                .id(network.id)
                .networkId(network.networkId)
                .name(network.name)
                .timeZone(network.timeZone)
                .url(network.url)
                .enrollmentString(network.enrollmentString)
                .organizationId(network.organizationId)
                .notes(network.notes)
                .productTypes(network.productTypes.stream().map(ProductTypes::getProductName).collect(Collectors.toList()))
                .tags(network.tags.stream().map(Tags::getTagName).collect(Collectors.toList()))
                .build();
    }
}
