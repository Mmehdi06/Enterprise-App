package be.ehb.enterpriseapp.services;

import be.ehb.enterpriseapp.models.Order;
import be.ehb.enterpriseapp.models.Product;
import be.ehb.enterpriseapp.models.User;
import be.ehb.enterpriseapp.models.enums.OrderStatus;
import be.ehb.enterpriseapp.repositories.OrderRepository;
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

