package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Entity
    @Table(name = "Show")
    @NamedQuery(name = "Show.deleteALLRows", query = "DELETE from Show")
    public class Show implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "Show_name")
    private String name;

    @Column(name = "duration")
    private String duration;

    @Column(name = "location")
    private String location;

    @Column(name = "startDate")
    private String startDate;

    @Column(name = "startTime")
    private String startTime;

    @ManyToMany(mappedBy = "guestList")
    private List<Guest> guestList;

    public Show(String name, String duration, String location, String startDate, String startTime) {
        this.name = name;
        this.duration = duration;
        this.location = location;
        this.startDate = startDate;
        this.startTime = startTime;
    }

    public Show(){}

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDuration() {
            return duration;
        }

        public void setDuration(String duration) {
            this.duration = duration;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        @Override
        public String toString() {
            return "Show{" +
                    "name='" + name + '\'' +
                    ", duration='" + duration + '\'' +
                    ", location='" + location + '\'' +
                    ", startDate='" + startDate + '\'' +
                    ", startTime='" + startTime + '\'' +
                    '}';
        }
    }