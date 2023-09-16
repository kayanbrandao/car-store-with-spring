package com.carstorewithspring.data.model;

import com.carstorewithspring.data.enums.GearboxType;
import jakarta.persistence.*;

import java.time.Year;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_car")
public class Car {
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

        if (!Objects.equals(id, car.id)) return false;
        if (!Objects.equals(color, car.color)) return false;
        if (!Objects.equals(version, car.version)) return false;
        if (gearbox != car.gearbox) return false;
        if (!Objects.equals(year, car.year)) return false;
        return Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        result = 31 * result + (gearbox != null ? gearbox.hashCode() : 0);
        result = 31 * result + (year != null ? year.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        return result;
    }
}
