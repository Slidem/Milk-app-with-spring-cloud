package ami.cloudexample.milk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MilkServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MilkServiceApplication.class, args);
    }

}
