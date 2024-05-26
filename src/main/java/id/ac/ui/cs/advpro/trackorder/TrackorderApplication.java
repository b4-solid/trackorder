package id.ac.ui.cs.advpro.trackorder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class TrackorderApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackorderApplication.class, args);
	}

}
