package id.ac.ui.cs.advpro.trackorder.controller;

import id.ac.ui.cs.advpro.trackorder.models.Order;
import id.ac.ui.cs.advpro.trackorder.service.OrderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        List<Order> orders = new ArrayList<>();
        orders.add(new Order());
        orders.add(new Order());

        when(orderService.findAllOrder()).thenReturn(orders);

        mockMvc.perform(get("/api/order/getall")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2));

        verify(orderService, times(1)).findAllOrder();
    }

    @Test
    public void testDeleteOrder() throws Exception {
        Long orderId = 1L;

        doNothing().when(orderService).deleteOrder(orderId);

        mockMvc.perform(delete("/api/order/delete/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(orderService, times(1)).deleteOrder(orderId);
    }
    @Test
    public void testUpdateOrderSuccess() throws Exception {
        Long orderId = 1L;
        Order order = new Order();

        when(orderService.findById(orderId)).thenReturn(Optional.of(order));
        when(orderService.updateOrder(any(Order.class))).thenReturn(order);

        mockMvc.perform(put("/api/order/update/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(orderService, times(1)).findById(orderId);
        verify(orderService, times(1)).updateOrder(any(Order.class));
    }

    @Test
    public void testUpdateOrderNotFound() throws Exception {
        Long orderId = 1L;

        when(orderService.findById(orderId)).thenReturn(Optional.empty());

        mockMvc.perform(put("/api/order/update/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(orderService, times(1)).findById(orderId);
        verify(orderService, times(0)).updateOrder(any(Order.class));
    }

    @Test
    public void testUpdateOrderException() throws Exception {
        Long orderId = 1L;

        when(orderService.findById(orderId)).thenThrow(new RuntimeException());

        mockMvc.perform(put("/api/order/update/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(orderService, times(1)).findById(orderId);
        verify(orderService, times(0)).updateOrder(any(Order.class));
    }
}
