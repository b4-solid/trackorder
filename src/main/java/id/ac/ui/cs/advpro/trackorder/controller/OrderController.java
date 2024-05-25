package id.ac.ui.cs.advpro.trackorder.controller;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import id.ac.ui.cs.advpro.trackorder.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/api/order/getall", method = RequestMethod.GET)
    public ResponseEntity<List<Order>> getAllOrders() {
        // Implementation
        return null;
    }

    @RequestMapping(value = "/api/order/delete/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        // Implementation
        return null;
    }

    @RequestMapping(value = "/api/order/update/{orderId}", method = RequestMethod.PUT)
    public ResponseEntity<Void> updateOrder(@PathVariable Long orderId) {
        // Implementation
        return null;
    }
}
