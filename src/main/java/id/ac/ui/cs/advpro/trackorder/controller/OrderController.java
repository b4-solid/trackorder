package id.ac.ui.cs.advpro.trackorder.controller;

import id.ac.ui.cs.advpro.trackorder.order.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.boot.configurationprocessor.json.JSONArray;
import org.springframework.boot.configurationprocessor.json.JSONException;

import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.web.bind.annotation.RestController;
import id.ac.ui.cs.advpro.trackorder.service.OrderService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity deleteOrder(@PathVariable String orderId) {
        // Implementation
    }

    @RequestMapping(value = "/api/order", method = RequestMethod.PUT)
    public ResponseEntity updateOrder(@RequestBody Order order) {
        // Implementation
    }

}

