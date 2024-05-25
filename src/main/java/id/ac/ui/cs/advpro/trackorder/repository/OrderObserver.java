package id.ac.ui.cs.advpro.trackorder.repository;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderObserver {
    void update(Order order);
    void addOrder(Order order);
    void removeOrder(Order order);
}