package id.ac.ui.cs.advpro.trackorder.service;

import id.ac.ui.cs.advpro.trackorder.order.Order;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    List<Order> orders = new ArrayList<>();

    public OrderService() {
        Order order1 = new Order("F01");
        Order order2 = new Order("F02");
        Order order3 = new Order("F03");

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
    }

    public List<Order> getAllOrders() {
        return orders;
    }

    public void add(Order order) {
        Order newOrder = new Order(order.getOrderId());
        orders.add(newOrder);
    }

    public void delete(String kodeOrder) {
        Order orderDeleted = null;

        for (Order order: orders) {
            if (order.getOrderId().equals(kodeOrder))
                orderDeleted = order;
        }

        orders.remove(orderDeleted);
    }

    public void update(Order order) {
        delete(order.getOrderId());
        add(order);
        order.updateStatus();


    }

    public void updateOrderStatus(Long orderId) {
        Order optionalOrder = orderRepository.findById(orderId);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.update(newStatus);
            // Save the updated order
            orderRepository.save(order);
        } else {
            // Handle case where order with given ID is not found
            throw new IllegalArgumentException("Order with ID " + orderId + " not found");
        }
    }

}