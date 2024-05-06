package id.ac.ui.cs.advpro.trackorder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class Order {
    @Getter
    private String orderId;
    private List<OrderObserver> observers = new ArrayList<>();
    @Getter
    private String status;
    public Order(String orderId) {
        this.orderId = orderId;
        this.status = "NEW";
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(OrderObserver observer) {
        observers.remove(observer);
    }

    public void setStatus(String status) {
        this.status = status;
        notifyObservers();
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }
}
