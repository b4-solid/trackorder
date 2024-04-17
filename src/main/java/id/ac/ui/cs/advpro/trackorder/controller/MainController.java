package id.ac.ui.cs.advpro.trackorder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({""})
public class MainController {
    private final Order order;

    public MainController(Order order) {
        this.order = order;
    }

    @GetMapping({""})
    public String tempPage() {
        // Simulate placing an order
        order.setStatus("Order Placed");
        return "tempPage";
    }
}
