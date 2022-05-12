package maintenance_monitor;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.OffsetDateTime;


@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
public class MaintenanceMonitorApplication {

    public static void main(String[] args) {
        SpringApplication.run(MaintenanceMonitorApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ServiceRepository serviceRepository) {
        return args -> serviceRepository.save(new Service("Garosh",State.ENABLED, OffsetDateTime.parse("2022-05-12T19:02:00+02:00")));
    }


}
