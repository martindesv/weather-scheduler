package weatherscheduler.xmlElement;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "forecast")
public class Forecast {

    @XmlAttribute(name = "date")
    private String date;

    @XmlElement
    private Night night;

    @XmlElement
    private Day day;
}
