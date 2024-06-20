package weatherscheduler.xmlElement;


import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@XmlRootElement(name = "forecasts")
public class ForecastsXml {

    @XmlElement(name = "forecast")
    public List<ForecastXml> forecast;

    public List<ForecastXml> getForecast() {
        return forecast;
    }
}
