package com.example.lab4activity;

import java.util.List;

import com.example.lab4activity.ProductDTO;
import com.example.lab4activity.ProductService;
import org.springframework.web.bind.annotation.*;



    @RestController
    @RequestMapping("/products")
    public class ProductController {
        private final ProductService productService;

        public ProductController(ProductService productService) {
            this.productService = productService;
        }
        @GetMapping("/category/{categoryId}")
        public List<ProductDTO> getProductsByCategory(@PathVariable Long categoryId) {
            return productService.getProductsByCategory(categoryId);
        }
        @PostMapping
        public ProductDTO addProduct(@RequestBody ProductDTO productDTO) {
            return productService.saveProduct(productDTO);
        }
    }


