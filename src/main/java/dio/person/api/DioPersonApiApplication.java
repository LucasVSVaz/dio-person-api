package dio.person.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class DioPersonApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(DioPersonApiApplication.class, args);
    }

}
