package com.example.lab4activity;


import lombok.Data;

    @Data
    public class CategoryDTO {
        private Long id;
        private String name;
        private String description;

        public CategoryDTO(Long id, String name, String description) {
        }

        public CategoryDTO() {

        }
    }
