package com.example.lab4activity;

import com.example.lab4activity.CategoryDTO;
import com.example.lab4activity.Category;
import com.example.lab4activity.CategoryRepository;
import com.example.lab4activity.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

    @Service
    public class CategoryServiceImpl implements CategoryService {
        private final CategoryRepository categoryRepository;
        public CategoryServiceImpl(CategoryRepository categoryRepository) {
            this.categoryRepository = categoryRepository;
        }
        @Override
        public List<CategoryDTO> getAllCategories() {
            return categoryRepository.findAll()
                    .stream()
                    .map(category -> {
                        CategoryDTO dto = new CategoryDTO();
                        dto.setId(category.getId());
                        dto.setName(category.getName());
                        dto.setDescription(category.getDescription());
                        return dto;
                    })
                    .collect(Collectors.toList());
        }
    }
