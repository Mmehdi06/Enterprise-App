package be.ehb.enterpriseapp.models;

import jakarta.persistence.*;


@Entity
@Table (name = "products")
public class Product {
    
    public Product ( String name, String description, String category, Double price, Boolean available ) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.available = available;
    }
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Boolean available;
    
    @Override
    public String toString() {
        return "Product {\n" +
                "    id=" + id + ",\n" +
                "    name='" + name + "',\n" +
                "    description='" + description + "',\n" +
                "    category='" + category + "',\n" +
                "    price=" + price + ",\n" +
                "    available=" + available + "\n" +
                '}';
    }
    
    
    public Product ( ) {
    
    }
    
}
