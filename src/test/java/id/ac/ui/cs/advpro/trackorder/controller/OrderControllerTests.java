package id.ac.ui.cs.advpro.trackorder.controller;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import id.ac.ui.cs.advpro.trackorder.service.OrderService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class OrderControllerTests {

    @Mock
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @Test
    public void testGetAllOrders() {
        // Mocking
        List<Order> orders = Arrays.asList(new Order(), new Order());
        when(orderService.findAllOrder()).thenReturn(orders);

        // Testing
        ResponseEntity responseEntity = orderController.getAllOrders();
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(orders, responseEntity.getBody());
    }

    @Test
    public void testAddOrder() {
        // Mocking
        Order order = new Order();

        // Testing
        ResponseEntity responseEntity = orderController.addOrder(order);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(orderService, times(1)).addOrder(order);
    }

    @Test
    public void testDeleteOrder() {
        // Mocking
        String orderId = "123";

        // Testing
        ResponseEntity responseEntity = orderController.deleteOrder(orderId);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(orderService, times(1)).deleteOrder(orderId);
    }

    @Test
    public void testUpdateOrder() {
        // Mocking
        Order order = new Order();

        // Testing
        ResponseEntity responseEntity = orderController.updateOrder(order);
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        verify(orderService, times(1)).updateOrder(order);
    }
}
