package maintenance_monitor;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {

    Service findByName(@NonNull String name);
}
