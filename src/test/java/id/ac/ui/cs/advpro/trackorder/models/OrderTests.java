package id.ac.ui.cs.advpro.trackorder.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderTests {

    private OrderModel order;

    @BeforeEach
    public void setUp() {
        order = new OrderModel();
    }

    @Test
    public void testParameterizedConstructor() {
        OrderModel order = new OrderModel(1L, "dummy", 3L, 4L, 5);
        assertEquals(1L, order.getOrderId());
        assertEquals(3L, order.getProductId());
        assertEquals(4L, order.getTransactionId());
        assertEquals(5L, order.getAmount());
    }

    @Test
    public void testGettersAndSetters() {
        order.setOrderId(1L);
        order.setProductId(3L);
        order.setTransactionId(4L);
        order.setAmount(5);

        assertEquals(1L, order.getOrderId());
        assertEquals(3L, order.getProductId());
        assertEquals(4L, order.getTransactionId());
        assertEquals(5L, order.getAmount());
    }
}
