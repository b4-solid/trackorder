package id.ac.ui.cs.advpro.trackorder.controller;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import id.ac.ui.cs.advpro.trackorder.service.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/api/order", method = RequestMethod.GET)
    public ResponseEntity getAllOrders() {
        // Implementation
    }

    @RequestMapping(value = "/api/order", method = RequestMethod.POST)
    public ResponseEntity addOrder(@RequestBody Order order) {
        // Implementation
    }

    @RequestMapping(value = "/api/order/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrder(@PathVariable Long orderId) {
        // Implementation
    }

    @RequestMapping(value = "/api/order", method = RequestMethod.PUT)
    public ResponseEntity updateOrder(@RequestBody Order order) {
        // Implementation
    }

}

