package dtos;

import entities.Show;

public class ShowDTO {

    private long id;

    private String name;

    private String duration;

    private String location;

    private String startDate;

    private String startTime;
    private Long showId;

    public ShowDTO(String name, String duration, String location, String startDate, String startTime) {
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

    public Long GetShowId(){ return showId;}
    public long getId() {
        return id;
    }

    public void setId(int id) {
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

    @Override
    public String toString() {
        return "ShowDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", duration='" + duration + '\'' +
                ", location='" + location + '\'' +
                ", startDate='" + startDate + '\'' +
                ", startTime='" + startTime + '\'' +
                ", showId=" + showId +
                '}';
    }
}
