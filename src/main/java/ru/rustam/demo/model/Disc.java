package ru.rustam.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "disc")
public class Disc {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "disc_id")
    private int disc_id;

    @Column(name = "name")
    private String name;

    @Column(name = "year")
    private int year;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn
    private User user_id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinTable(name = "disc_changer", joinColumns = @JoinColumn(name = "disc_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private User renter;

    public int getDisc_id() {
        return disc_id;
    }

    public void setDisc_id(int disc_id) {
        this.disc_id = disc_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDesc() {
        return description;
    }

    public void setDesc(String desc) {
        this.description = desc;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public User getRenter() {
        return renter;
    }

    public void setRenter(User renter) {
        this.renter = renter;
    }
}
