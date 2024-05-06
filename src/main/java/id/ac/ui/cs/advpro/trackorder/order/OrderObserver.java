package id.ac.ui.cs.advpro.trackorder.order;

import id.ac.ui.cs.advpro.trackorder.order.Order;

public interface OrderObserver {
    void update(Order order);
    void addOrder(Order order);
    void removeOrder(Order order);
}