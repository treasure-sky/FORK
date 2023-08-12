package ms.twentythree.addefender;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class AdDefenderApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdDefenderApplication.class, args);
    }

}
