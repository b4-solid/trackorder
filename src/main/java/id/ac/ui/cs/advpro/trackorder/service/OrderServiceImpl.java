package id.ac.ui.cs.advpro.trackorder.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import id.ac.ui.cs.advpro.trackorder.models.Order;
import id.ac.ui.cs.advpro.trackorder.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository repository;

    public OrderServiceImpl(OrderRepository repository) {
        this.repository = repository;
    }

    //C(reate)
    @Override
    public Order addOrder(Order transaction) {
        return repository.save(transaction);
    };

    //R(ead)
    @Override
    public List<Order> findAllOrder() {
        return repository.findAll();
    };

    @Override
    public Optional<Order> findById(Long id) {
        return repository.findById(id);
    }

    //U(pdate)
    @Override
    public Order updateOrder(Order transaction) {
        return repository.save(transaction);
    };

    //D(elete)
    public void deleteOrder(Long id) {
        repository.deleteById(id);
    };
}