package id.ac.ui.cs.advpro.trackorder.service;

import java.util.List;
import java.util.Optional;

import id.ac.ui.cs.advpro.trackorder.models.Order;

public interface OrderService {

    //C(reate)
    Order addOrder(Order order);

    //R(ead)
    List<Order> findAllOrder();
    Optional<Order> findById(Long id);

    //U(pdate)
    Order updateOrder(Order order);

    //D(elete)
    void deleteOrder(Long id);
}