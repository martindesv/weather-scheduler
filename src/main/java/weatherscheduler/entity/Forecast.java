package weatherscheduler.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate date;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "forecast")
    private List<Place> place;

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setPlace(List<Place> place) {
        this.place = place;
    }
}
