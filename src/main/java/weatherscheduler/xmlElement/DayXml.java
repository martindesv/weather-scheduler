package weatherscheduler.xmlElement;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "day")
public class DayXml {

    @XmlElement(name = "place")
    private List<PlaceXml> place;

    public List<PlaceXml> getPlace() {
        return place;
    }
}
