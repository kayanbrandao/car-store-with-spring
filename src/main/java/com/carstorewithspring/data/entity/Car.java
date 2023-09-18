package com.carstorewithspring.data.entity;

import com.carstorewithspring.data.enums.GearboxType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.Year;
import java.util.Objects;

@Entity
@Table(name = "tb_car")
public class Car implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    private Long id;
    @Column(nullable = false)
    private String color;
    @Column(nullable = false)
    private String version;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private GearboxType gearbox;
    @Column(nullable = false)
    private Year year;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tb_model", foreignKey = @ForeignKey(name = "model_id"))
    private Model model;

    public Car() {
    }

    public Car(String color, String version, GearboxType gearbox, Year year, Model model) {
        this.color = color;
        this.version = version;
        this.gearbox = gearbox;
        this.year = year;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public GearboxType getGearbox() {
        return gearbox;
    }

    public void setGearbox(GearboxType gearbox) {
        this.gearbox = gearbox;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
