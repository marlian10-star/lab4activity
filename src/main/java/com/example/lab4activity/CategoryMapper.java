package com.example.lab4activity;

import org.springframework.stereotype.Component;
    @Component
    public class CategoryMapper {
        // Convert Category entity to CategoryDTO
        public CategoryDTO toDTO(Category category) {
            if (category == null) {
                return null;
            }
            return new CategoryDTO(
                    category.getId(),
                    category.getName(),
                    category.getDescription()
            );
        }
        // Convert CategoryDTO to Category entity
        public Category toEntity(CategoryDTO categoryDTO) {
            if (categoryDTO == null) {
                return null;
            }
            Category category = new Category();
            category.setId(categoryDTO.getId());
            category.setName(categoryDTO.getName());
            category.setDescription(categoryDTO.getDescription());
            return category;
        }
    }
