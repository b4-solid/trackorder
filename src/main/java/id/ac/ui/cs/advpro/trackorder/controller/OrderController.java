package id.ac.ui.cs.advpro.trackorder.controller;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import id.ac.ui.cs.advpro.trackorder.models.Order;
import org.springframework.http.HttpStatus;
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

import java.util.List;


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

    @RequestMapping(value = "/api/order/add", method = RequestMethod.POST)
    public ResponseEntity addOrder(@RequestBody Order order) {
        ResponseEntity responseEntity = null;

        try {
            orderService.addOrder(order);
            responseEntity = ResponseEntity.ok().build();
        } catch (Exception e) {
            System.out.println("Error in add order!");
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
        public ResponseEntity updateOrder(@RequestBody Order order) {
            ResponseEntity responseEntity = null;

            try {
                orderService.updateOrder(order);
                responseEntity = ResponseEntity.ok().build();
            } catch (Exception e) {
                System.out.println("Error in update order!");
                responseEntity = ResponseEntity.badRequest().body(HttpStatus.INTERNAL_SERVER_ERROR);
            }

            return responseEntity;
        }

    }
