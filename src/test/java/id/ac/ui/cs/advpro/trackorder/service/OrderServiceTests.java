package id.ac.ui.cs.advpro.trackorder.service;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import id.ac.ui.cs.advpro.trackorder.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class OrderServiceTests {

    @Mock
    private OrderRepository orderRepository;

    @InjectMocks
    private OrderServiceImpl orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddOrder() {
        Order order = new Order();
        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.addOrder(order);

        assertNotNull(result);
        assertEquals(order, result);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void testFindAllOrder() {
        List<Order> orders = Arrays.asList(new Order(), new Order());
        when(orderRepository.findAll()).thenReturn(orders);

        List<Order> result = orderService.findAllOrder();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(orders, result);
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Long orderId = 1L;
        Order order = new Order();
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        Optional<Order> result = orderService.findById(orderId);

        assertTrue(result.isPresent());
        assertEquals(order, result.get());
        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    public void testUpdateOrder() {
        Order order = new Order();
        when(orderRepository.save(order)).thenReturn(order);

        Order result = orderService.updateOrder(order);

        assertNotNull(result);
        assertEquals(order, result);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void testDeleteOrder() {
        Long orderId = 1L;

        doNothing().when(orderRepository).deleteById(orderId);

        orderService.deleteOrder(orderId);

        verify(orderRepository, times(1)).deleteById(orderId);
    }
}