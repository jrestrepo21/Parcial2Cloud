package co.com.poli.showtimesservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class ShowtimeServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShowtimeServiceApplication.class, args);
    }

}
