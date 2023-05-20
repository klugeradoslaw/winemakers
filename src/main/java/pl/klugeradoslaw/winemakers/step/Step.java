package pl.klugeradoslaw.winemakers.step;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfStep;
    private String description;
    @Column(name = "wine_id")
    private Long wineId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateOfStep() {
        return dateOfStep;
    }

    public void setDateOfStep(LocalDate dateOfStep) {
        this.dateOfStep = dateOfStep;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getWineId() {
        return wineId;
    }

    public void setWineId(Long wineId) {
        this.wineId = wineId;
    }
}
