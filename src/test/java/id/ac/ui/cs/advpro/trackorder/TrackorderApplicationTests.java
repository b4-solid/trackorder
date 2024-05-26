package id.ac.ui.cs.advpro.trackorder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TrackorderApplicationTests {

    @Test
    public void contextLoads() {
        // This test ensures that the Spring application context is loaded successfully
    }

    @Test
    public void applicationStarts() {
        assertNotNull(TrackorderApplication.class);
    }
}
