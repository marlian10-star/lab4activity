package com.example.lab4activity;

import org.springframework.stereotype.Component;
    @Component
    public class ProductMapper {
        private final CategoryMapper categoryMapper;
        public ProductMapper(CategoryMapper categoryMapper) {
            this.categoryMapper = categoryMapper;
        }
        // Convert Product entity to ProductDTO
        public ProductDTO toDTO(Product product) {
            if (product == null) {
                return null;
            }
            return new ProductDTO(
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getCategory() != null ? product.getCategory().getName() : null
            );
        }
        // Convert ProductDTO to Product entity
        public Product toEntity(ProductDTO productDTO, Category category) {
            if (productDTO == null) {
                return null;
            }
            Product product = new Product();
            product.setId(productDTO.getId());
            product.setName(productDTO.getName());
            product.setPrice(productDTO.getPrice());
            product.setCategory(category);
            return product;
        }
    }

