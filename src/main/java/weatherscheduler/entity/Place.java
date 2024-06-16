package weatherscheduler.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement(name = "place")
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Night night;

    @ManyToOne
    private Day day;

    @Column
    @XmlElement
    private String name;

    @XmlElement
    private String phenomenon;

    @XmlElement
    private Integer tempmin;

    @XmlElement
    private Integer tempmax;
}
