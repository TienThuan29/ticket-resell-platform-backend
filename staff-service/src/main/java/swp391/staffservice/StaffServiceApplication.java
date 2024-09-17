package swp391.staffservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"swp391.*"})
@EntityScan(value = "swp391.*")
public class StaffServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StaffServiceApplication.class, args);
    }

}
