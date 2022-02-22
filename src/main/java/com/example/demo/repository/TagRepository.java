package com.example.demo.repository;
import com.example.demo.models.Network;
import com.example.demo.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tags,Long> {

}
