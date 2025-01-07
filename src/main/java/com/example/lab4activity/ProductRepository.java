package com.example.lab4activity;

import java.util.List;


import com.example.lab4activity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> { List<Product> findByCategoryId(Long categoryId);
    }
