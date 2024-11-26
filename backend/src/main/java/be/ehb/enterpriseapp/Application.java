package be.ehb.enterpriseapp;

import be.ehb.enterpriseapp.auth.enums.UserRole;
import be.ehb.enterpriseapp.auth.models.User;
import be.ehb.enterpriseapp.auth.repositories.UserRepository;
import be.ehb.enterpriseapp.products.models.Product;
import be.ehb.enterpriseapp.products.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;


@SpringBootApplication
public class Application {
    
    public static void main ( String[] args ) {
        SpringApplication.run( Application.class, args );
    }
    
    @Bean
    CommandLineRunner seedDatabase(ProductRepository productRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            // Check if the database already has products
            if (productRepository.count() == 0) {
                productRepository.saveAll( List.of(
                        new Product("Apple iPhone 13", "Latest model of the iPhone series with A15 Bionic chip and 5G.", "Electronics", 899.99, true),
                        new Product("Samsung Galaxy S22", "High-end Android smartphone with an advanced camera system.", "Electronics", 799.99, true),
                        new Product("Nike Air Max 270", "Comfortable and stylish running shoes with an air-cushioned sole.", "Sportswear", 149.99, true),
                        new Product("Sony WH-1000XM4 Headphones", "Noise-canceling over-ear headphones with superior sound quality.", "Electronics", 349.99, true),
                        new Product("Adidas Ultraboost 21", "Running shoes designed for maximum comfort and energy return.", "Sportswear", 179.99, false),
                        new Product("HP Envy 13 Laptop", "Lightweight laptop with Intel Core i7 and 16GB RAM, perfect for productivity.", "Electronics", 1199.99, true),
                        new Product("Herman Miller Aeron Chair", "Ergonomic office chair providing excellent support for long working hours.", "Furniture", 1249.00, true),
                        new Product("Dyson V11 Cordless Vacuum", "Powerful cordless vacuum cleaner with advanced filtration.", "Home Appliances", 599.99, true),
                        new Product("Bose SoundLink Revolve Speaker", "Portable Bluetooth speaker delivering 360-degree sound.", "Electronics", 199.99, true),
                        new Product("Instant Pot Duo 7-in-1", "Multifunctional pressure cooker for cooking, steaming, and sautéing.", "Home Appliances", 99.99, true)
                ) );
            }
            if (userRepository.count() == 0) {
                userRepository.saveAll( List.of(
                        new User("mehdi@mehdi.com", passwordEncoder.encode("Password123"), UserRole.STUDENT ),
                        new User("admin@admin.com", passwordEncoder.encode("Password123"), UserRole.ADMIN )
                ));
            }
        };
    }
}


