package weatherscheduler.xmlElement;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "place")
public class PlaceXml {

    @XmlElement
    private String name;

    @XmlElement
    private String phenomenon;

    @XmlElement
    private Integer tempmin;

    @XmlElement
    private Integer tempmax;
}
