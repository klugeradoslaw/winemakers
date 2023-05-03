package pl.klugeradoslaw.winemakers.step.dto;

import java.time.LocalDate;

public class StepFullResponseDto {
    private Long id;
    private LocalDate dateOfStep;
    private String description;

    public StepFullResponseDto(Long id, LocalDate dateOfStep, String description) {
        this.id = id;
        this.dateOfStep = dateOfStep;
        this.description = description;
    }

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
}
