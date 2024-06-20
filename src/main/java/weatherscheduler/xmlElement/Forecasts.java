package weatherscheduler.xmlElement;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "forecasts")
public class Forecasts {

    @XmlElement(name = "forecast")
    public List<Forecast> forecast;
}
