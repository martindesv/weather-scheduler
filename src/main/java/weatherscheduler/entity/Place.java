package weatherscheduler.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

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

    private LocalDate date;

    public void setName(String name) {
        this.name = name;
    }

    public void setPhenomenonNight(String phenomenonNight) {
        this.phenomenonNight = phenomenonNight;
    }

    public void setPhenomenonDay(String phenomenonDay) {
        this.phenomenonDay = phenomenonDay;
    }

    public void setTempmin(Integer tempmin) {
        this.tempmin = tempmin;
    }

    public void setTempmax(Integer tempmax) {
        this.tempmax = tempmax;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
