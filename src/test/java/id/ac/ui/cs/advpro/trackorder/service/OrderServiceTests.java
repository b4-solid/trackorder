package id.ac.ui.cs.advpro.trackorder.service;

import id.ac.ui.cs.advpro.trackorder.models.OrderModel;
import id.ac.ui.cs.advpro.trackorder.repository.OrderRepository;
import id.ac.ui.cs.advpro.trackorder.service.impl.OrderServiceImpl;

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
import java.util.Collections;


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
        OrderModel order = new OrderModel();
        when(orderRepository.save(order)).thenReturn(order);

        OrderModel result = orderService.addOrder(order);

        assertNotNull(result);
        assertEquals(order, result);
        verify(orderRepository, times(1)).save(order);
    }

    @Test
    public void testFindByUsername() {
        String username = "testuser";
        List<OrderModel> expectedOrders = Collections.emptyList();
        when(orderRepository.findByUsername(username)).thenReturn(expectedOrders);

        List<OrderModel> actualOrders = orderService.findByUsername(username);

        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    public void testFindByUsernameAdmin() {
        String username = "admin";
        List<OrderModel> expectedOrders = Collections.emptyList();
        when(orderRepository.findByUsernameAdmin(username)).thenReturn(expectedOrders);

        List<OrderModel> actualOrders = orderService.findByUsernameAdmin(username);

        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    public void testFindByTransactionId() {
        String transactionId = "txn123";
        List<OrderModel> expectedOrders = Collections.emptyList();
        when(orderRepository.findByTransactionId(transactionId)).thenReturn(expectedOrders);

        List<OrderModel> actualOrders = orderService.findByTransactionId(transactionId);

        assertEquals(expectedOrders, actualOrders);
    }

    @Test
    public void testFindAllOrder() {
        List<OrderModel> orders = Arrays.asList(new OrderModel(), new OrderModel());
        when(orderRepository.findAll()).thenReturn(orders);

        List<OrderModel> result = orderService.findAllOrder();

        assertNotNull(result);
        assertEquals(2, result.size());
        assertEquals(orders, result);
        verify(orderRepository, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        Long orderId = 1L;
        OrderModel order = new OrderModel();
        when(orderRepository.findById(orderId)).thenReturn(Optional.of(order));

        Optional<OrderModel> result = orderService.findById(orderId);

        assertTrue(result.isPresent());
        assertEquals(order, result.get());
        verify(orderRepository, times(1)).findById(orderId);
    }

    @Test
    public void testUpdateOrder() {
        OrderModel order = new OrderModel();
        when(orderRepository.save(order)).thenReturn(order);

        OrderModel result = orderService.updateOrder(order);

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