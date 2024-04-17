package id.ac.ui.cs.advpro.trackorder;

import java.util.ArrayList;
import java.util.List;

public class Trackorder implements OrderObserver {
    private List<Order> orders = new ArrayList<>();

    public Trackorder(String orderId, Order order) {
        this.orderId = orderId;
        order.addObserver(this);
    }

    @Override
    public void update(String status) {
        //TODO: Isi
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
