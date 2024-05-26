package id.ac.ui.cs.advpro.trackorder.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import id.ac.ui.cs.advpro.trackorder.models.OrderModel;
import id.ac.ui.cs.advpro.trackorder.repository.OrderRepository;
import id.ac.ui.cs.advpro.trackorder.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    //C(reate)
    @Override
    public OrderModel addOrder(OrderModel transaction) {
        Optional<OrderModel> existingOrder = repository.findbyProductIdAndUsername(transaction.getProductId(), transaction.getUsername());

        if (existingOrder.isPresent()) {
            transaction.setOrderId(existingOrder.get().getOrderId());
            transaction.setAmount(existingOrder.get().getAmount() + transaction.getAmount());
        }

        return repository.save(transaction);
    };


    //R(ead)
    @Override
    public List<OrderModel> findAllOrder() {
        return repository.findAll();
    };

    @Override
    public Optional<OrderModel> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<OrderModel> findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public List<OrderModel> findByUsernameAdmin(String username) {
        return repository.findByUsernameAdmin(username);
    }

    @Override
    public List<OrderModel> findByTransactionId(String transactionId) {
        return repository.findByTransactionId(transactionId);
    }

    @Override
    public List<OrderModel> findByProductIdAndAmountGreaterThan(long productId, long remainder) {
        return repository.findByProductIdAndAmountGreaterThan(productId, remainder);
    }

    //U(pdate)
    @Override
    public OrderModel updateOrder(OrderModel transaction) {
        Optional<OrderModel> existingOrder = repository.findbyProductIdAndUsername(transaction.getProductId(), transaction.getUsername());

        if (existingOrder.isPresent()) {
            transaction.setOrderId(existingOrder.get().getOrderId());
            transaction.setAmount(existingOrder.get().getAmount() + transaction.getAmount());
        }

        return repository.save(transaction);
    };

    //D(elete)
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    };
}