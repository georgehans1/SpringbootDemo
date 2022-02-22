package com.example.demo.models;

import com.example.demo.models.Network;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
@Builder
public class Tags {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagName;

    @JoinColumn(name = "network_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Network network;

    public Tags(String tagName) {
        this.tagName = tagName;
    }
}
