package weatherscheduler.xmlElement;

import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "forecast")
public class ForecastXml {

    @XmlAttribute(name = "date")
    private String date;

    @XmlElement
    private NightXml night;

    @XmlElement
    private DayXml day;

    public String getDate() {
        return date;
    }

    public NightXml getNight() {
        return night;
    }

    public DayXml getDay() {
        return day;
    }
}
