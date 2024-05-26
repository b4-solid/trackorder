package id.ac.ui.cs.advpro.trackorder.service;

import java.util.List;
import java.util.Optional;

import id.ac.ui.cs.advpro.trackorder.models.OrderModel;

public interface OrderService {

    //C(reate)
    OrderModel addOrder(OrderModel order);

    //R(ead)
    List<OrderModel> findAllOrder();
    Optional<OrderModel> findById(Long id);
    List<OrderModel> findByUsername(String username);
    List<OrderModel> findByUsernameAdmin(String username);
    List<OrderModel> findByTransactionId(String transactionId);

    //U(pdate)
    OrderModel updateOrder(OrderModel order);

    //D(elete)
    void deleteOrder(Long id);
}