package com.example.demo.models;

import com.example.demo.dto.NetworkDTO;
import com.example.demo.dto.ProductTypes;
import com.example.demo.dto.Tags;
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
    private String id;
    private long organizationId;
    private String url;
    private String name;
    private String timeZone;
    private String enrollmentString;
    private String notes;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "network_id")
    private List<ProductTypes> productTypes = new ArrayList<>();

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "network_id")
    private List<Tags> tags = new ArrayList<>();



    public static NetworkDTO toNetworkDTO(Network network){
        return NetworkDTO.builder()
                .id(network.id)
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
