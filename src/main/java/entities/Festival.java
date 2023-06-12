package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Festival")
@NamedQuery(name = "Festival.deleteAllRows", query = "DELETE from Festival")
public class Festival implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "festival_name")
    String name;

    @Column(name = "city")
    String city;

    @Column(name = "startDate")
    String startDate;

    @Column(name = "duration")
    String duration;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "festival")
    private List<Guest> guests = new ArrayList<>();

    public Festival(String name, String city, String startDate, String duration) {
        this.name = name;
        this.city = city;
        this.startDate = startDate;
        this.duration = duration;
    }


    public List<Guest> getGuests() {
        return guests;
    }

    public void setGuests(List<Guest> guests) {
        this.guests = guests;
    }

    public Festival(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Festival{" +
                "name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", startDate='" + startDate + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}