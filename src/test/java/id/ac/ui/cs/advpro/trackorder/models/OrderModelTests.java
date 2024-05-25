package id.ac.ui.cs.advpro.trackorder.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTests {

    private Order order;

    @BeforeEach
    public void setUp() {
        order = new Order();
    }

    @Test
    public void testDefaultConstructor() {
        assertEquals("NEW", order.getStatus());
    }

    @Test
    public void testParameterizedConstructor() {
        Order order = new Order(1L, 2L, 3L, 4L, 5L);
        assertEquals(1L, order.getOrderId());
        assertEquals(2L, order.getUserId());
        assertEquals(3L, order.getProductId());
        assertEquals(4L, order.getTransactionId());
        assertEquals(5L, order.getAmount());
        assertEquals("NEW", order.getStatus());
    }

    @Test
    public void testGettersAndSetters() {
        order.setOrderId(1L);
        order.setUserId(2L);
        order.setProductId(3L);
        order.setTransactionId(4L);
        order.setAmount(5L);

        assertEquals(1L, order.getOrderId());
        assertEquals(2L, order.getUserId());
        assertEquals(3L, order.getProductId());
        assertEquals(4L, order.getTransactionId());
        assertEquals(5L, order.getAmount());
    }

    @Test
    public void testUpdateStatus() {
        assertEquals("NEW", order.getStatus()); // Assuming no change in status based on current implementation
        order.updateStatus();
        assertEquals("IN PROGRESS", order.getStatus()); // Assuming no change in status based on current implementation
    }
}
