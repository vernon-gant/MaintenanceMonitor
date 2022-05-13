package maintenance_monitor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.OffsetDateTime;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Service {


    @Id
    @NonNull
    private String name;
    @NonNull
    private State state;
    private OffsetDateTime nextTimeAvailable;

    public Service(@NonNull String name, OffsetDateTime nextTimeAvailable) {
        this.name = name;
        this.state = State.DISABLED;
        this.nextTimeAvailable = nextTimeAvailable;
    }
}
