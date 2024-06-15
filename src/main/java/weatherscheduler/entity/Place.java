package weatherscheduler.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JsonIgnore
    private Forecast forecast;

    @Column
    private String name;

    private String phenomenon;

    private int tempmin;

    private int tempmax;
}
