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

    public void updateStatus() {
        int currentIndex = statusList.indexOf(status);
        if (currentIndex < statusList.size() - 1) {
            setStatus(statusList.get(currentIndex + 1));
        }
    }

    private void notifyObservers() {
        for (OrderObserver observer : observers) {
            observer.update(this);
        }
    }
}

