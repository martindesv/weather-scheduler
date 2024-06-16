package weatherscheduler.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@Entity
@XmlRootElement(name = "night")
public class Night {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlElement
    private String phenomenon;

    @XmlElement
    private Integer tempmin;

    @XmlElement
    private Integer tempmax;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "night")
    @XmlElement(name = "place")
    private List<Place> places;

    @ManyToOne
    private Forecast forecast;
}
