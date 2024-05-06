package id.ac.ui.cs.advpro.trackorder.order;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class OrderTest {

    private Order order;
    private OrderObserver observer;

    @BeforeEach
    public void setUp() {
        order = new Order("123");
        observer = mock(OrderObserver.class);
        order.addObserver(observer);
    }

    @Test
    public void testInitialStatus() {
        assertEquals("NEW", order.getStatus());
    }

    @Test
    public void testSetStatus() {
        order.setStatus("ON THE WAY");
        assertEquals("ON THE WAY", order.getStatus());
    }

    @Test
    public void testUpdateStatus() {
        order.updateStatus();
        assertEquals("ON THE WAY", order.getStatus());
    }

    @Test
    public void testUpdateStatus_NotifiesObservers() {
        order.updateStatus();
        verify(observer).update(order);
    }

    @Test
    public void testUpdateStatus_LastStatus_NoChange() {
        // Move to ARRIVED
        order.updateStatus();
        order.updateStatus();
        // Try to move beyond ARRIVED
        order.updateStatus();
        // Status should remain as ARRIVED
        assertEquals("ARRIVED", order.getStatus());
    }

    @Test
    public void testRemoveObserver() {
        order.removeObserver(observer);
        order.updateStatus();
        // Observer should not be notified
        verify(observer, Mockito.never()).update(order);
    }
}
