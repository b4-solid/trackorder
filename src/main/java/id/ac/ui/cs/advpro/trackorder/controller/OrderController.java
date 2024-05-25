package id.ac.ui.cs.advpro.trackorder.controller;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import id.ac.ui.cs.advpro.trackorder.service.OrderService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;



@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/api/order/getall", method = RequestMethod.GET)
    public ResponseEntity getAllOrders() {
        ResponseEntity responseEntity = null;
        try {
            List<Order> orders = orderService.findAllOrder();
            responseEntity = ResponseEntity.ok(orders);
        } catch (Exception e) {
            System.out.println("Error in get all orders!");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @RequestMapping(value = "/api/order/delete/{orderId}", method = RequestMethod.DELETE)
    public ResponseEntity deleteOrder(@PathVariable Long orderId) {
        // Implementation
        ResponseEntity responseEntity = null;

        try {
            orderService.deleteOrder(orderId);
            responseEntity = ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("Error in delete order!");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

    @RequestMapping(value = "/api/order/update/{orderId}", method = RequestMethod.PUT)
    public ResponseEntity updateOrder(@PathVariable Long orderId) {
        ResponseEntity responseEntity = null;

        try {
            // Find the Order object with the given orderId
            Optional<Order> existingOrder = orderService.findById(orderId);

            Order existingOrder2 = existingOrder.get();

            System.out.println(existingOrder2);

            // Call the updateStatus() method on the Order object
            existingOrder2.updateStatus();

            // Update the Order object in the database
            orderService.updateOrder(existingOrder2);

            responseEntity = ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Error in update order!");
            responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return responseEntity;
    }

}
