package be.ehb.enterpriseapp.Orders.services;

import be.ehb.enterpriseapp.Orders.enums.OrderStatus;
import be.ehb.enterpriseapp.Orders.models.Order;
import be.ehb.enterpriseapp.Orders.repositories.OrderRepository;
import be.ehb.enterpriseapp.products.models.Product;
import be.ehb.enterpriseapp.auth.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public Order createOrder(
            User user, List<Product> products, LocalDate startDate, LocalDate endDate
    )
     {
        Order order = new Order();
        order.setUser(user);
        order.setProducts(products);
        order.setStartDate(startDate);
        order.setEndDate(endDate);
        order.setOrderStatus( OrderStatus.PENDING);
        return orderRepository.save(order);
    }
}

