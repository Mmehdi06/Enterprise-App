package be.ehb.enterpriseapp.Orders.repositories;

import be.ehb.enterpriseapp.Orders.models.Order;
import be.ehb.enterpriseapp.auth.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository< Order, Long > {
    List< Order > findByUser( User user );
}
