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
}
