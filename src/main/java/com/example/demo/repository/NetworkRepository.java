package com.example.demo.repository;
import com.example.demo.models.Network;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NetworkRepository extends JpaRepository<Network,String> {

}
