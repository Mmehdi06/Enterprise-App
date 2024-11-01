package be.ehb.enterpriseapp.Orders.models;

import be.ehb.enterpriseapp.Orders.enums.OrderStatus;
import be.ehb.enterpriseapp.auth.models.User;
import be.ehb.enterpriseapp.products.models.Product;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;


@Entity
@Table (name = "orders")
public class Order {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private User user;
    
    @ManyToMany
    private List< Product > products;
    
    private LocalDate startDate;
    private LocalDate endDate;
    private OrderStatus orderStatus; // PENDING, ACCEPTED, REJECTED, DELIVERED
    
    
    public Long getId ( ) {
        return id;
    }
    
    public void setId ( Long id ) {
        this.id = id;
    }
    
    public User getUser ( ) {
        return user;
    }
    
    public void setUser ( User user ) {
        this.user = user;
    }
    
    public List< Product > getProducts ( ) {
        return products;
    }
    
    public void setProducts ( List< Product > products ) {
        this.products = products;
    }
    
    public LocalDate getStartDate ( ) {
        return startDate;
    }
    
    public void setStartDate ( LocalDate startDate ) {
        this.startDate = startDate;
    }
    
    public LocalDate getEndDate ( ) {
        return endDate;
    }
    
    public void setEndDate ( LocalDate endDate ) {
        this.endDate = endDate;
    }
    
    public OrderStatus getOrderStatus ( ) {
        return orderStatus;
    }
    
    public void setOrderStatus ( OrderStatus orderStatus ) {
        this.orderStatus = orderStatus;
    }
    
    
}

