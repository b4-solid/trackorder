package id.ac.ui.cs.advpro.trackorder.service;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import id.ac.ui.cs.advpro.trackorder.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.*;

public class SeedingServiceTests {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private SeedingService seedingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testSeedOrders() {
//        doNothing().when(orderRepository).saveAll(anyList());
//
//        seedingService.seedOrders();
//
//        verify(orderRepository, times(1)).saveAll(anyList());
//    }

    @Test
    public void testSeedOrdersContent() {
        seedingService.seedOrders();

        // Capture the argument to verify its contents
        ArgumentCaptor<List<Order>> orderListCaptor = ArgumentCaptor.forClass(List.class);
        verify(orderRepository, times(1)).saveAll(orderListCaptor.capture());
        List<Order> savedOrders = orderListCaptor.getValue();

        assertEquals(100, savedOrders.size());
        for (int i = 1; i <= 100; i++) {
            Order order = savedOrders.get(i - 1);
            assertEquals(i, order.getOrderId());
            assertEquals(100L + i, order.getUserId());
            assertEquals(1000L + i, order.getProductId());
            assertEquals(5000L + i, order.getTransactionId());
            assertTrue(order.getAmount() >= 1 && order.getAmount() <= 10);
        }
    }
}
