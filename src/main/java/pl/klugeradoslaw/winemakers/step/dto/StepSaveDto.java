package pl.klugeradoslaw.winemakers.step.dto;

import java.time.LocalDate;

public class StepSaveDto {
    private LocalDate dateOfStep;
    private String description;
    private Long wineId;

    public StepSaveDto() {
    }

    public LocalDate getDateOfStep() { return dateOfStep; }

    public void setDateOfStep(LocalDate dateOfStep) {
        this.dateOfStep = dateOfStep;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getWineId() { return wineId; }

    public void setWineId(Long wineId) { this.wineId = wineId; }
}
