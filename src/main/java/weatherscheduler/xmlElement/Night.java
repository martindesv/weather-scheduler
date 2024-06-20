package weatherscheduler.xmlElement;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "night")
public class Night {

    @XmlElement
    private String phenomenon;

    @XmlElement
    private Integer tempmin;

    @XmlElement
    private Integer tempmax;

    @XmlElement(name = "place")
    private List<Place> places;
}