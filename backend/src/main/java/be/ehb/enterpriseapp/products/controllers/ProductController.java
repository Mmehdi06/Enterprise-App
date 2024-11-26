package be.ehb.enterpriseapp.products.controllers;

import be.ehb.enterpriseapp.products.models.ProductDTO;
import be.ehb.enterpriseapp.products.services.ProductService;
import be.ehb.enterpriseapp.products.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequestMapping("/api")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    // Get all products with optional filters
    @GetMapping("/products")
    public List<ProductDTO> getProducts(
            @RequestParam(value = "category", required = false) String category,
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "available", required = false) Boolean available) {
        return productService.findProductsByFilters(category, name, available);
    }
    
    // Get product by ID
    @GetMapping("product/{id}")
    public ProductDTO getProductById(@PathVariable Long id) {
        return productService.getById(id);
    }
    
    // Create new product
    @PostMapping("/product")
    public ProductDTO createProduct(@RequestBody ProductDTO product) {
        return productService.createProduct(product);
    }
    
    // Modify product by ID
    @PatchMapping("product/{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO updates) {
        return productService.updateProduct(id, updates);
    }
    
    // Delete product by ID
    @DeleteMapping("product/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return productService.deleteProduct(id);
    }
}
