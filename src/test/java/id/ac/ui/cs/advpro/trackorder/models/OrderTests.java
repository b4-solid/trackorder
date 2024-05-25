//package id.ac.ui.cs.advpro.trackorder.models;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.Mockito.mock;
//import static org.mockito.Mockito.verify;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//@SpringBootTest
//
//
//public class OrderTests {
//    private Order order;
//
//    @BeforeEach
//    public void setUp() {
//        order = new Order();
//    }
//
//    @Test
//    public void testDefaultConstructor() {
//        assertEquals("NEW", order.getStatus());
//    }
//
//    @Test
//    public void testParameterizedConstructor() {
//        long orderId = 1;
//        long userId = 2;
//        long productId = 3;
//        long transactionId = 4;
//        long amount = 100;
//        Order order = new Order(orderId, userId, productId, transactionId, amount);
//
//        assertEquals(orderId, order.getOrderId());
//        assertEquals(userId, order.getUserId());
//        assertEquals(productId, order.getProductId());
//        assertEquals(transactionId, order.getTransactionId());
//        assertEquals(amount, order.getAmount());
//    }
//
//    @Test
//    public void testAddObserver() {
//        OrderObserver observer = new OrderObserverImpl();
//        order.addObserver(observer);
//
//        assertEquals(1, order.getObservers().size());
//        assertTrue(order.getObservers().contains(observer));
//    }
//
//    @Test
//    public void testRemoveObserver() {
//        OrderObserver observer = new OrderObserverImpl();
//        order.addObserver(observer);
//        order.removeObserver(observer);
//
//        assertEquals(0, order.getObservers().size());
//        assertFalse(order.getObservers().contains(observer));
//    }
//
//    @Test
//    public void testSetStatus() {
//        OrderObserver observer = new OrderObserverImpl();
//        order.addObserver(observer);
//
//        order.setStatus("PROCESSING");
//
//        assertEquals("PROCESSING", order.getStatus());
//        assertTrue(observer.isUpdated());
//    }
//
//    @Test
//    public void testUpdateStatus() {
//        OrderObserver observer = new OrderObserverImpl();
//        order.addObserver(observer);
//        order.setStatus("NEW");
//
//        order.updateStatus();
//
//        assertEquals("PROCESSING", order.getStatus());
//        assertTrue(observer.isUpdated());
//    }
//
//    // Helper class for testing
//    private abstract static class OrderObserverImpl implements OrderObserver {
//        private boolean updated;
//
//        @Override
//        public void update(Order order) {
//            updated = true;
//        }
//
//        public boolean isUpdated() {
//            return updated;
//        }
//    }
//}
//
