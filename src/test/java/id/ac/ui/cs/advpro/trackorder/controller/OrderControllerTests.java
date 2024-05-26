package id.ac.ui.cs.advpro.trackorder.controller;

import id.ac.ui.cs.advpro.trackorder.models.OrderModel;
import id.ac.ui.cs.advpro.trackorder.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
public class OrderControllerTests {

    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @InjectMocks
    private OrderController orderController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void testGetAllOrders() throws Exception {
        List<OrderModel> orders = new ArrayList<>();
        orders.add(new OrderModel());
        orders.add(new OrderModel());

        when(orderService.findAllOrder()).thenReturn(orders);

        mockMvc.perform(get("/orders")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        verify(orderService, times(1)).findAllOrder();
    }

    @Test
    public void testDeleteOrder() throws Exception {
        Long orderId = 1L;

        doNothing().when(orderService).deleteOrder(orderId);

        mockMvc.perform(delete("/orders/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(orderService, times(1)).deleteOrder(orderId);
    }

    @Test
    public void testGetOrderByUsernameAdmin() throws Exception {
        when(orderService.findByUsernameAdmin("admin")).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/orders/admin/admin"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testGetOrderByUsername() throws Exception {
        when(orderService.findByUsername("user")).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/orders/user"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testGetOrderByTransactionId() throws Exception {
        when(orderService.findByTransactionId("txn123")).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/orders/transaction/txn123"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$").isEmpty());
    }

    @Test
    public void testAddOrder() throws Exception {
        OrderModel order = new OrderModel();
        order.setAmount(100);

        when(orderService.addOrder(any(OrderModel.class))).thenReturn(order);

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"amount\": 100}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.amount").value(100));
    }

    @Test
    public void testUpdateOrder() throws Exception {
        OrderModel order = new OrderModel();
        order.setAmount(200);

        when(orderService.addOrder(any(OrderModel.class))).thenReturn(order);

        mockMvc.perform(put("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"amount\": 200}"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.amount").value(200));
    }

    @Test
    public void testGetAllOrdersException() throws Exception {
        when(orderService.findAllOrder()).thenThrow(new RuntimeException("Exception occurred"));

        mockMvc.perform(get("/orders"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Exception occurred"));
    }

    @Test
    public void testGetOrderByUsernameAdminException() throws Exception {
        when(orderService.findByUsernameAdmin("admin")).thenThrow(new RuntimeException("Exception occurred"));

        mockMvc.perform(get("/orders/admin/admin"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Exception occurred"));
    }

    @Test
    public void testGetOrderByUsernameException() throws Exception {
        when(orderService.findByUsername("user")).thenThrow(new RuntimeException("Exception occurred"));

        mockMvc.perform(get("/orders/user"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Exception occurred"));
    }

    @Test
    public void testGetOrderByTransactionIdException() throws Exception {
        when(orderService.findByTransactionId("txn123")).thenThrow(new RuntimeException("Exception occurred"));

        mockMvc.perform(get("/orders/transaction/txn123"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Exception occurred"));
    }

    @Test
    public void testAddOrderException() throws Exception {
        when(orderService.addOrder(any(OrderModel.class))).thenThrow(new RuntimeException("Exception occurred"));

        mockMvc.perform(post("/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"amount\": 100}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Exception occurred"));
    }

    @Test
    public void testUpdateOrderException() throws Exception {
        when(orderService.addOrder(any(OrderModel.class))).thenThrow(new RuntimeException("Exception occurred"));

        mockMvc.perform(put("/orders/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"amount\": 200}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(content().string("Exception occurred"));
    }

}
