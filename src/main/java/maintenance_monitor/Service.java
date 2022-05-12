package maintenance_monitor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Service {

    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private State state;
    @NonNull
    private OffsetDateTime nextUnavailable;
}
