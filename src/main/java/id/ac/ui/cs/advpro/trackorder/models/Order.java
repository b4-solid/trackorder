package id.ac.ui.cs.advpro.trackorder.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
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
        this.status = "NEW";
    }

    public void updateStatus() {
        if (status.equals("NEW")) {
            status = "IN PROGRESS";
        } else if (status.equals("IN PROGRESS")) {
            status = "COMPLETED";
        }
    }
}