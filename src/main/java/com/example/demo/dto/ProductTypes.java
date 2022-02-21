package com.example.demo.dto;

import com.example.demo.models.Network;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class ProductTypes {
//    @JoinColumn(name = "network_id", referencedColumnName = "id")
//    @ManyToOne
//    private Network network;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    public ProductTypes(String productName) {
        this.productName = productName;
    }

    private String productName;
}
