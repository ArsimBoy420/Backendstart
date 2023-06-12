package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Guest")
@NamedQuery(name = "Guest.deleteAllRows", query = "delete from Guest")
public class Guest implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "guest_name")
    private String name;

    @Column(name = "phone")
    private int phone;

    @Column(name = "email")
    private String email;

    @Column(name = "status")
    private String status;

    @ManyToMany
    private List<Guest> guestList = new ArrayList<>();

    public Guest(String name, int phone, String email, String status){
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.status = status;
    }

    public Guest(){}

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

    public List<Guest> getGuestList() {
        return guestList;
    }

    public void setGuestList(List<Guest> guestList) {
        this.guestList = guestList;
    }

    @Override
    public String toString() {
        return "Guest{" +
                "name='" + name + '\'' +
                ", phone=" + phone +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", guestList=" + guestList +
                '}';
    }
}