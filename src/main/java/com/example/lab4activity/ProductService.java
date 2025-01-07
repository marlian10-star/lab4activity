package com.example.lab4activity;

import com.example.lab4activity.ProductDTO;
import java.util.List;

    public interface ProductService {
        List<ProductDTO> getProductsByCategory(Long categoryId);
        ProductDTO saveProduct(ProductDTO productDTO);
    }
