package id.ac.ui.cs.advpro.trackorder.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Getter
@Entity()
@Table(name="orders")
public class OrderModel {

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
    private String username;

    @Column(name = "productId")
    @NotNull
    @Setter
    @Getter
    private long productId;

    @Column(name = "transactionId")
    @Setter
    @Getter
    private Long transactionId;

    @Column(name = "amount")
    @NotNull
    @Setter
    @Getter
    private int amount;

    public OrderModel(){
    }

    public OrderModel(long orderId, String username, long productId, Long transactionId, int amount){
        this.orderId=orderId;
        this.username=username;
        this.productId=productId;
        this.transactionId=transactionId;
        this.amount=amount;
    }
}


