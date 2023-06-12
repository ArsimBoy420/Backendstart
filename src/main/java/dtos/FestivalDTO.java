package dtos;

import entities.Festival;

public class FestivalDTO {

    private long id;
    String name;
    String city;
    String startDate;
    String duration;

    public FestivalDTO(long id, String name, String city, String startDate, String duration) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.startDate = startDate;
        this.duration = duration;
    }

    public FestivalDTO(Festival festival) {
        if (festival.getName() != null)
            this.name = festival.getName();
        this.city = festival.getCity();
        this.startDate = festival.getStartDate();
        this.duration = festival.getDuration();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return "FestivalDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", startDate='" + startDate + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
