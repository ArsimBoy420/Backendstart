package dtos;

import entities.Show;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class ShowDTO {

    private long id;

    private String name;

    private String duration;

    private String location;

    private String startDate;

    private String startTime;

    public ShowDTO(long id, String name, String duration, String location, String startDate, String startTime) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.location = location;
        this.startDate = startDate;
        this.startTime = startTime;
    }

//    public static List<ShowDTO> getDtos(List<Show> shows){
//        List<ShowDTO> showDTOS = new ArrayList();
//        shows.forEach(user-> showDTOS.add(new ShowDTO(shows)));
//        return showDTOS;
//    }

    public ShowDTO(Show show){
        if(show.getName() != null)
            this.name = show.getName();
        this.duration = show.getDuration();
        this.location = show.getLocation();
        this.startDate = show.getStartDate();
        this.startTime = show.getStartTime();
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
}
