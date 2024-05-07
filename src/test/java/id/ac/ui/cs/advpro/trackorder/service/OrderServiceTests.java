package id.ac.ui.cs.advpro.trackorder.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import id.ac.ui.cs.advpro.trackorder.repository.OrderRepository;
import id.ac.ui.cs.advpro.trackorder.service.OrderServiceImpl;

public class OrderServiceTests {

    @Mock
    private OrderRepository orderRepositoryMock;

    @InjectMocks
    private OrderServiceImpl orderService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddOrder() {
        Order order = new Order();
        when(orderRepositoryMock.save(order)).thenReturn(order);

        Order savedOrder = orderService.addOrder(order);

        assertEquals(order, savedOrder);
        verify(orderRepositoryMock, times(1)).save(order);
    }

    @Test
    public void testFindAllOrder() {
        Order order1 = new Order();
        Order order2 = new Order();
        List<Order> orders = Arrays.asList(order1, order2);
        when(orderRepositoryMock.findAll()).thenReturn(orders);

        List<Order> foundOrders = orderService.findAllOrder();

        assertEquals(2, foundOrders.size());
        assertTrue(foundOrders.contains(order1));
        assertTrue(foundOrders.contains(order2));
        verify(orderRepositoryMock, times(1)).findAll();
    }

    @Test
    public void testFindById() {
        long id = 1L;
        Order order = new Order();
        when(orderRepositoryMock.findById(id)).thenReturn(Optional.of(order));

        Optional<Order> foundOrder = orderService.findById(id);

        assertTrue(foundOrder.isPresent());
        assertEquals(order, foundOrder.get());
        verify(orderRepositoryMock, times(1)).findById(id);
    }

    @Test
    public void testUpdateOrder() {
        Order order = new Order();
        when(orderRepositoryMock.save(order)).thenReturn(order);

        Order updatedOrder = orderService.updateOrder(order);

        assertEquals(order, updatedOrder);
        verify(orderRepositoryMock, times(1)).save(order);
    }

    @Test
    public void testDeleteOrder() {
        long id = 1L;
        doNothing().when(orderRepositoryMock).deleteById(id);

        orderService.deleteOrder(id);

        verify(orderRepositoryMock, times(1)).deleteById(id);
    }
}

