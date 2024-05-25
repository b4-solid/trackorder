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
/* INI TARDULU YA GW UDH MAU GILA
    @Test
    public void testUpdateOrderSuccess() throws Exception {
        Long orderId = 1L;
        OrderModel order = new OrderModel();
        order.setOrderId(orderId);
        order.setAmount(4);

        when(orderService.findById(orderId)).thenReturn(Optional.of(order));
        when(orderService.updateOrder(any(OrderModel.class))).thenReturn(order);

        mockMvc.perform(put("/orders/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(orderService, times(1)).findById(orderId);
        verify(orderService, times(1)).updateOrder(any(OrderModel.class));
    }

    @Test
    public void testUpdateOrderNotFound() throws Exception {
        Long orderId = 1L;

        when(orderService.findById(orderId)).thenReturn(Optional.empty());

        mockMvc.perform(put("/orders/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(orderService, times(1)).findById(orderId);
        verify(orderService, times(0)).updateOrder(any(OrderModel.class));
    }

    @Test
    public void testUpdateOrderException() throws Exception {
        Long orderId = 1L;

        when(orderService.findById(orderId)).thenThrow(new RuntimeException());

        mockMvc.perform(put("/orders/{orderId}", orderId)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());

        verify(orderService, times(1)).findById(orderId);
        verify(orderService, times(0)).updateOrder(any(OrderModel.class));
    }
*/
}
