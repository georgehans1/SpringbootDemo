package com.example.demo.api;

import com.example.demo.models.Network;
import com.example.demo.models.ProductTypes;
import com.example.demo.models.Tags;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class NetworkResponse {
    private String id;
    private long organizationId;
    private List<String> productTypes;
    private String url;
    private String name;
    private String timeZone;
    private String enrollmentString;
    private List<String> tags;
    private String notes;


    public static Network toNetwork(NetworkResponse networkResponse) {
        return Network.builder()
                .networkId(networkResponse.id)
                .name(networkResponse.name)
                .timeZone(networkResponse.timeZone)
                .url(networkResponse.url)
                .enrollmentString(networkResponse.enrollmentString)
                .organizationId(networkResponse.organizationId)
                .notes(networkResponse.notes)
                .productTypes(networkResponse.productTypes.stream().map(ProductTypes::new).collect(Collectors.toList()))
                .tags(networkResponse.tags.stream().map(Tags::new).collect(Collectors.toList()))
                .build();
    }
}