package id.ac.ui.cs.advpro.trackorder.controller;

import id.ac.ui.cs.advpro.trackorder.models.OrderModel;

import id.ac.ui.cs.advpro.trackorder.service.OrderService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @GetMapping()
    public ResponseEntity<Object> getAllOrders() {
        ResponseEntity<Object> responseEntity = null;
        try {
            List<OrderModel> orders = orderService.findAllOrder();
            responseEntity = ResponseEntity.ok(orders);
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/admin/{username}")
    public ResponseEntity<Object> getOrderByUsernameAdmin(@PathVariable String username) {
        ResponseEntity<Object> responseEntity = null;
        try {
            List<OrderModel> orders = orderService.findByUsernameAdmin(username);
            responseEntity = ResponseEntity.ok(orders);
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/{username}")
    public ResponseEntity<Object> getOrderByUsername(@PathVariable String username) {
        ResponseEntity<Object> responseEntity = null;
        try {
            List<OrderModel> orders = orderService.findByUsername(username);
            responseEntity = ResponseEntity.ok(orders);
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/transaction/{transactionId}")
    public ResponseEntity<Object> getOrderByTransactionId(@PathVariable String transactionId) {
        ResponseEntity<Object> responseEntity = null;
        try {
            List<OrderModel> orders = orderService.findByTransactionId(transactionId);
            responseEntity = ResponseEntity.ok(orders);
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @GetMapping("/product/{productId}/{remainder}")
    public ResponseEntity<Object> getOrderByProductIdAndAmountGreaterThan(@PathVariable Long productId, @PathVariable Long remainder) {
        ResponseEntity<Object> responseEntity = null;
        try {
            List<OrderModel> orders = orderService.findByProductIdAndAmountGreaterThan(productId, remainder);
            responseEntity = ResponseEntity.ok(orders);
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }
        return responseEntity;
    }

    @PostMapping()
    public ResponseEntity<Object> addOrder(@RequestBody OrderModel order) {
        ResponseEntity<Object> responseEntity = null;

        try {
            if (order.getAmount() != 0) {
                OrderModel addedOrder = orderService.addOrder(order);
                responseEntity = ResponseEntity.ok(addedOrder);
            }
        } catch (Exception e) {
            System.out.println();
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }

        return responseEntity;
    }

    @DeleteMapping("/{orderId}")
    public ResponseEntity<Object> deleteOrder(@PathVariable Long orderId) {
        ResponseEntity<Object> responseEntity = null;

        try {
            orderService.deleteOrder(orderId);
            responseEntity = ResponseEntity.ok().build();
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }

        return responseEntity;
    }

    @PutMapping("/{orderId}")
    public ResponseEntity<Object> updateOrder(@PathVariable Long orderId, @RequestBody OrderModel order) {
        ResponseEntity<Object> responseEntity = null;

        try {
            if (order.getAmount() != 0) {
                OrderModel addedOrder = orderService.addOrder(order);
                responseEntity = ResponseEntity.ok(addedOrder);
            }
        } catch (Exception e) {
            responseEntity = ResponseEntity.badRequest().body(e.getMessage());
        }

        return responseEntity;
    }

}
