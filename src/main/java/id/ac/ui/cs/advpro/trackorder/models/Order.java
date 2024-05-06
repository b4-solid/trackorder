package id.ac.ui.cs.advpro.trackorder.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

@Getter
@NoArgsConstructor
@Entity()
@Table(name="orders")
public class Order {

    // username productId transactionId, all long, all NOT NULL kecuali transaction NULL kalau belum check out
    @Id // tambahin ini kalo PK
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    @NotNull
    @Setter
    @Getter
    private long orderId;

    @Column(name = "username")
    @NotNull
    @Setter
    @Getter
    private long userId;

    @Column(name = "productId")
    @NotNull
    @Setter
    @Getter
    private long productId;

    @Column(name = "transactionId")
    @Setter
    @Getter
    private long transactionId;

    @Column(name = "amount")
    @NotNull
    @Setter
    @Getter
    private long amount;


    private List<OrderObserver> observers = new ArrayList<>();
    private String[] array = new String[]{"NEW", "ON THE WAY", "ARRIVED"};
    private List<String> statusList = Arrays.asList(array);

    @Getter
    private String status;

    public Order() {
        this.status = "NEW";
    }
    public Order(long orderId, long userId, long productId, long transactionId, long amount){
        this.orderId=orderId;
        this.userId=userId;
         this.productId=productId;
         this.transactionId=transactionId;
         this.amount=amount;
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

