package id.ac.ui.cs.advpro.trackorder.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Entity
@Table(name = "orders")
public class Order {

    @Id
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

    @Getter
    private String status;

    public Order() {
        // Constructor implementation
    }

    public Order(long orderId, long userId, long productId, long transactionId, long amount) {
        // Constructor implementation
    }

    public void updateStatus() {
        // Method implementation
    }
}


