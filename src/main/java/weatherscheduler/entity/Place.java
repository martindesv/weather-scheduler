package weatherscheduler.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.List;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String phenomenonNight;

    private String phenomenonDay;

    private Integer tempmin;

    private Integer tempmax;

    @ManyToOne
    @JoinColumn(name = "forecast_id")
    private Forecast forecast;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhenomenonNight() {
        return phenomenonNight;
    }

    public void setPhenomenonNight(String phenomenonNight) {
        this.phenomenonNight = phenomenonNight;
    }

    public String getPhenomenonDay() {
        return phenomenonDay;
    }

    public void setPhenomenonDay(String phenomenonDay) {
        this.phenomenonDay = phenomenonDay;
    }

    public Integer getTempmin() {
        return tempmin;
    }

    public void setTempmin(Integer tempmin) {
        this.tempmin = tempmin;
    }

    public Integer getTempmax() {
        return tempmax;
    }

    public void setTempmax(Integer tempmax) {
        this.tempmax = tempmax;
    }

    public Forecast getForecast() {
        return forecast;
    }

    public void setForecast(Forecast forecast) {
        this.forecast = forecast;
    }
}
