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

    private String phenomenonNight;

    private String phenomenonDay;

    public String getName() {
        return name;
    }

    public Integer getTempmin() {
        return tempmin;
    }

    public Integer getTempmax() {
        return tempmax;
    }

    public String getPhenomenonNight() {
        return phenomenonNight;
    }

    public String getPhenomenonDay() {
        return phenomenonDay;
    }

    public void merge(PlaceXml other) {
        if (this.name.equals(other.name)) {
            if (this.tempmax == null) {
                // This is Night Place, other is Day Place
                this.phenomenonNight = this.phenomenon;
                this.phenomenonDay = other.phenomenon;
                this.tempmax = other.tempmax;
            } else {
                // This is Day Place, other is Night Place
                this.phenomenonNight = other.phenomenon;
                this.phenomenonDay = this.phenomenon;
                this.tempmin = other.tempmin;
            }
        }
    }

}
