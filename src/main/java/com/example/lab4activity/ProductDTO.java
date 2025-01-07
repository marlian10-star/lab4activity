package com.example.lab4activity;


import lombok.Data;

    @Data
    public class ProductDTO {
        private Long id;
        private String name;
        private Double price;
        private Long categoryId;

        public ProductDTO(Long id, String name, Double price, String s) {
        }

        public ProductDTO() {

        }
    }

