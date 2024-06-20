package weatherscheduler.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;
}
