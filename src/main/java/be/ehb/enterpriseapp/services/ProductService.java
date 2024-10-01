package be.ehb.enterpriseapp.services;

import be.ehb.enterpriseapp.models.Product;
import be.ehb.enterpriseapp.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductService {
   @Autowired
    private ProductRepository productRepository;
   
    public List< Product > findAll() {
        return productRepository.findAll( );
    }
    
    public List< Product > findByName( String name ) {
        return productRepository.findByName( name );
    }
    
    public List< Product > findByCategory( String category ) {
        return productRepository.findByCategory( category );
    }
    
    public Product getById( Long id ) {
        return productRepository.findById( id ).orElse( null );
    }
}
