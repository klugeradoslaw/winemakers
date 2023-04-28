package pl.klugeradoslaw.winemakers.step;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import pl.klugeradoslaw.winemakers.wine.Wine;

import java.time.LocalDate;

@Entity
public class Step {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOfStep;
    private String description;

    public Step() {
    }

}
