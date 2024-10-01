package be.ehb.enterpriseapp.controllers;

import be.ehb.enterpriseapp.models.Product;
import be.ehb.enterpriseapp.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping ("/products")
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }
    
    @GetMapping ("/category/{category}")
    public List< Product > getProductsByCategory( @PathVariable String category) {
        return productService.findByCategory(category);
    }
}
