package com.example.lab4activity;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;


    @Service
    public class ProductServiceImpl implements ProductService {
        private final ProductRepository productRepository;
        private final CategoryRepository categoryRepository;
        public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
            this.productRepository = productRepository;
            this.categoryRepository = categoryRepository;
        }
        @Override
        public List<ProductDTO> getProductsByCategory(Long categoryId) {
            return productRepository.findByCategoryId(categoryId)
                    .stream()
                    .map(product -> {
                        ProductDTO dto = new ProductDTO();
                        dto.setId(product.getId());
                        dto.setName(product.getName());
                        dto.setPrice(product.getPrice());
                        dto.setCategoryId(product.getCategory().getId());
                        return dto;
                    })
                    .collect(Collectors.toList());
        }
        @Override
        public ProductDTO saveProduct(ProductDTO productDTO) {
            Category category = categoryRepository.findById(productDTO.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));
            Product product = new Product();
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setCategory(category);

            Product savedProduct = productRepository.save(product);

            productDTO = new ProductDTO();
            productDTO.setId(savedProduct.getId());
            productDTO.setName(savedProduct.getName());
            productDTO.setPrice(savedProduct.getPrice());
            productDTO.setCategoryId(savedProduct.getCategory().getId());

            return productDTO;
        }
    }
