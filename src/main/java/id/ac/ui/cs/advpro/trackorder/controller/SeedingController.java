package id.ac.ui.cs.advpro.trackorder.controller;

import id.ac.ui.cs.advpro.trackorder.service.SeedingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/seed")
public class SeedingController {

    @Autowired
    private SeedingService orderSeedingService;

    @GetMapping("/orders")
    public ResponseEntity<String> seedOrders() {
        // Method implementation
        return null;
    }
}
