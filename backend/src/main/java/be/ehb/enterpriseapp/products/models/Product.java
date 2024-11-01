package be.ehb.enterpriseapp.products.models;

import jakarta.persistence.*;


@Entity
@Table (name = "products")
public class Product {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String category;
    private Double price;
    private Boolean available;
    
    public Product ( String name, String description, String category, Double price, Boolean available ) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.available = available;
    }
    
    public Long getId ( ) {
        return id;
    }
    
    public void setId ( Long id ) {
        this.id = id;
    }
    
    public String getName ( ) {
        return name;
    }
    
    public void setName ( String name ) {
        this.name = name;
    }
    
    public String getDescription ( ) {
        return description;
    }
    
    public void setDescription ( String description ) {
        this.description = description;
    }
    
    public String getCategory ( ) {
        return category;
    }
    
    public void setCategory ( String category ) {
        this.category = category;
    }
    
    public Double getPrice ( ) {
        return price;
    }
    
    public void setPrice ( Double price ) {
        this.price = price;
    }
    
    public Boolean getAvailable ( ) {
        return available;
    }
    
    public void setAvailable ( Boolean available ) {
        this.available = available;
    }
    
    public Product ( ) {
    
    }
    
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
    
}
