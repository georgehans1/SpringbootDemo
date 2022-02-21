package com.example.demo.dto;

import com.example.demo.models.Network;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@ToString
public class Tags {
//    @JoinColumn(name = "network_id")
//    @ManyToOne
//    private Network network;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tagName;

    public Tags(String tagName) {
        this.tagName = tagName;
    }
}
