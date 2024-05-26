package id.ac.ui.cs.advpro.trackorder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TrackorderApplicationTests {
    @Test
    public void applicationStarts() {
        TrackorderApplication.main(new String[] {});
        assertNotNull(TrackorderApplication.class);
    }
}
