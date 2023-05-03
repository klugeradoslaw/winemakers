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
}
