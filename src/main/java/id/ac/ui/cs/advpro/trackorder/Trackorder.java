package id.ac.ui.cs.advpro.trackorder;

import id.ac.ui.cs.advpro.trackorder.order.Order;
import id.ac.ui.cs.advpro.trackorder.order.OrderObserver;

import java.util.ArrayList;
import java.util.List;

public class Trackorder implements OrderObserver {
    private List<Order> orders = new ArrayList<>();
    public String orderId;

    public Trackorder(String orderId, Order order) {
        this.orderId = orderId;
        order.addObserver(this);
    }


    @Override
    public void update(Order order) {

    }

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removeOrder(Order order) {
        orders.remove(order);
    }
}
