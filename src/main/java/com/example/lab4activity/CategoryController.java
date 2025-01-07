package com.example.lab4activity;

import com.example.lab4activity.CategoryDTO;
import com.example.lab4activity.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

    @RestController
    public class CategoryController {
        private final CategoryService categoryService;
        public CategoryController(CategoryService categoryService) {
            this.categoryService = categoryService;
        }
        @GetMapping("/categories")
        public List<CategoryDTO> getAllCategories() {
            return categoryService.getAllCategories();
        }
    }

