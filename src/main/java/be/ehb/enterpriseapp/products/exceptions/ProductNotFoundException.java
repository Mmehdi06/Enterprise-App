package be.ehb.enterpriseapp.products.exceptions;

public class ProductNotFoundException extends RuntimeException {
    
    public ProductNotFoundException( Long id ) {
        super( "Could not find product " + id );
    }
}
