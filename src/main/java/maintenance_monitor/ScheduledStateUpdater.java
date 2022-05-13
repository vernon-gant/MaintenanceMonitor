package maintenance_monitor;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledStateUpdater {

    private final ServiceRepository repository;

    public ScheduledStateUpdater(ServiceRepository repository) {
        this.repository = repository;
    }

    @Scheduled(cron = "0 53 13 ? * FRI")
    public void changeState() throws InterruptedException {
        Service service = repository.findByName("IBM");
        service.setNextTimeAvailable(OffsetDateTime.now().plus(328500, ChronoUnit.MILLIS));
        service.setState(State.DISABLED);
        repository.save(service);
        TimeUnit.MILLISECONDS.sleep(328500);
        service.setState(State.ENABLED);
        service.setNextTimeAvailable(null);
        repository.save(service);
    }
}
