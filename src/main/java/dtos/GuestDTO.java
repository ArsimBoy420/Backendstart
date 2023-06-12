package dtos;

public class GuestDTO {

    private long id;
    private String name;
    private int phone;
    private String email;
    private String status;

    public GuestDTO(long id, String name, int phone, String email, String status) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "GuestDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
