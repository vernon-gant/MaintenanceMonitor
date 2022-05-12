package maintenance_monitor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;
import java.util.concurrent.TimeUnit;

@Component
public class ScheduledStateUpdater {

    private final ServiceRepository repository;
    private final static Logger logger = LoggerFactory.getLogger(ScheduledStateUpdater.class);

    public ScheduledStateUpdater(ServiceRepository repository) {
        this.repository = repository;
    }

    @Scheduled(cron = "0 2 19 ? * THU")
    public void changeState() throws InterruptedException {
        Service service = repository.findByName("Garosh");
        service.setState(State.DISABLED);
        repository.save(service);
        TimeUnit.MILLISECONDS.sleep(328500);
        service.setState(State.ENABLED);
        OffsetDateTime newTime = service.getNextUnavailable().plusDays(7);
        service.setNextUnavailable(newTime);
        repository.save(service);
    }
}
