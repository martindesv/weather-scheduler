package weatherscheduler.xmlElement;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "night")
public class Night {

    @XmlElement(name = "place")
    private List<Place> place;
}
