package id.ac.ui.cs.advpro.trackorder.service;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import id.ac.ui.cs.advpro.trackorder.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class SeedingService {

    @Autowired
    private OrderRepository orderRepository;

    @Async
    public CompletableFuture<Void> seedOrders() {
        return CompletableFuture.runAsync(() -> {
            List<Order> orders = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                orders.add(new Order((long) i, 100L + i, 1000L + i, 5000L + i, (long) (Math.random() * 10 + 1)));
            }
            orderRepository.saveAll(orders);
        });
    }
}

