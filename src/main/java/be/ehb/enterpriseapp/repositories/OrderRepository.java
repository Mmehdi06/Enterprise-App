package be.ehb.enterpriseapp.repositories;

import be.ehb.enterpriseapp.models.Order;
import be.ehb.enterpriseapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface OrderRepository extends JpaRepository< Order, Long > {
    List< Order > findByUser( User user );
}
