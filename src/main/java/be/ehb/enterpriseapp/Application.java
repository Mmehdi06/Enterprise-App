package be.ehb.enterpriseapp;

import be.ehb.enterpriseapp.models.Product;
import be.ehb.enterpriseapp.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application {
    
    public static void main ( String[] args ) {
        SpringApplication.run( Application.class, args );
    }
    
    @Bean
    CommandLineRunner runner( ProductRepository productRepository ) {
        return args -> {
            Product product = new Product( "Product 1", "Description 1", "Category 1", 10.0, true);
            productRepository.save( product );
            
            System.out.println( productRepository.findAll().toString() );
        };
    }
    
}
