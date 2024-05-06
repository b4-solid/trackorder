package id.ac.ui.cs.advpro.trackorder.order;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Getter
@NoArgsConstructor
@Entity()
public class Order {
    @Getter
    private String orderId;
    private List<OrderObserver> observers = new ArrayList<>();
    private String[] array = new String[]{"NEW", "ON THE WAY", "ARRIVED"};
    private List<String> statusList = Arrays.asList(array);

    @Getter
    private String status;

    public Order(String orderId) {
        // Constructor implementation
    }

    public void addObserver(OrderObserver observer) {
        // Add observer implementation
    }

    public void removeObserver(OrderObserver observer) {
        // Remove observer implementation
    }

    public void setStatus(String status) {
        // Set status implementation
    }

    public void updateStatus() {
        // Update status implementation
    }

    private void notifyObservers() {
        // Notify observers implementation
    }
}

