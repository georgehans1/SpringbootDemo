package com.example.demo.repository;
import com.example.demo.models.ProductTypes;
import com.example.demo.models.Tags;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductTypeRepository extends JpaRepository<ProductTypes,Long> {

}
