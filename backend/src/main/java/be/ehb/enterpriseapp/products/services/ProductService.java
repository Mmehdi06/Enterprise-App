package be.ehb.enterpriseapp.products.services;

import be.ehb.enterpriseapp.products.exceptions.ProductNotFoundException;
import be.ehb.enterpriseapp.products.models.Product;
import be.ehb.enterpriseapp.products.models.ProductDTO;
import be.ehb.enterpriseapp.products.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    public ProductDTO getById(Long id) {
        Optional< Product > product = productRepository.findById( id);
        return product.map( this::convertToDTO )
                      .orElseThrow(() -> new ProductNotFoundException( id ));
    }
    
    public List<ProductDTO> findProductsByFilters(String category, String name, Boolean available) {
        List<Product> products = productRepository.findAll(createSpecification(category, name, available));
        return products.stream().map(this::convertToDTO).toList();
    }
    
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product product = convertToEntity(productDTO);
        Product savedProduct = productRepository.save(product);
        return convertToDTO(savedProduct);
    }
    
    public ProductDTO updateProduct(Long id, ProductDTO updates) {
        Optional<Product> existingProductOpt = productRepository.findById(id);
        
        if (existingProductOpt.isPresent()) {
            Product existingProduct = getProduct( updates, existingProductOpt );
            
            Product updatedProduct = productRepository.save(existingProduct);
            return convertToDTO(updatedProduct);
        } else {
            throw new RuntimeException("Product not found with id: " + id);
        }
    }
    
    private static Product getProduct ( ProductDTO updates, Optional< Product > existingProductOpt ) {
        Product existingProduct = existingProductOpt.get();
        
        // Update fields based on DTO
        if ( updates.getName() != null) existingProduct.setName( updates.getName());
        if ( updates.getDescription() != null) existingProduct.setDescription( updates.getDescription());
        if ( updates.getCategory() != null) existingProduct.setCategory( updates.getCategory());
        if ( updates.getPrice() != null) existingProduct.setPrice( updates.getPrice());
        if ( updates.getAvailable() != null) existingProduct.setAvailable( updates.getAvailable());
        return existingProduct;
    }
    
    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    
    private Specification<Product> createSpecification(String category, String name, Boolean available) {
        return (root, query, criteriaBuilder) -> {
            var predicates = criteriaBuilder.conjunction(); // Start with a true predicate
            
            if (category != null) {
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.equal(root.get("category"), category));
            }
            
            if (name != null) {
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            
            if (available != null) {
                predicates = criteriaBuilder.and(predicates, criteriaBuilder.equal(root.get("available"), available));
            }
            
            return predicates;
        };
    }
    
    private ProductDTO convertToDTO(Product product) {
        if (product == null) {
            return null;
        }
        ProductDTO dto = new ProductDTO();
        dto.setName(product.getName());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setPrice(product.getPrice());
        dto.setAvailable(product.getAvailable());
        return dto;
    }
    
    private Product convertToEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setCategory(productDTO.getCategory());
        product.setPrice(productDTO.getPrice());
        product.setAvailable(productDTO.getAvailable());
        return product;
    }
}

