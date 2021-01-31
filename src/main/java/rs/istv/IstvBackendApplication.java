package rs.istv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class IstvBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(IstvBackendApplication.class, args);
    }

}
