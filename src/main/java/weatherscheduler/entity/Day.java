package weatherscheduler.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.*;

import java.util.List;

@Entity
@XmlRootElement(name = "day")
public class Day {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement
    private String phenomenon;

    @XmlElement
    private Integer tempmin;

    @XmlElement
    private Integer tempmax;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "day")
    @XmlElement(name = "place")
    private List<Place> places;

    @ManyToOne
    private Forecast forecast;
}
