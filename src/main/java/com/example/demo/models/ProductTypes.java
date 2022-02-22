package com.example.demo.models;

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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "network_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Network network;

    public ProductTypes(String productName) {
        this.productName = productName;
    }

    private String productName;
}
