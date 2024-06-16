package weatherscheduler.entity;

import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@XmlRootElement(name = "forecast")
public class Forecast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @XmlTransient
    private LocalDate date;

    @XmlAttribute(name = "date")
    private String dateString;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement
    private Night night;

    @OneToOne(cascade = CascadeType.ALL)
    @XmlElement
    private Day day;
}
