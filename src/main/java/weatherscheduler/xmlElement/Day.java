package weatherscheduler.xmlElement;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "day")
public class Day {

    @XmlElement(name = "place")
    private List<Place> place;
}
