package pl.klugeradoslaw.winemakers.wine.dto;

import pl.klugeradoslaw.winemakers.step.Step;
import pl.klugeradoslaw.winemakers.step.dto.StepFullResponseDto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WineFullResponseDto {
    private Long id;
    private String name;
    private LocalDate dateOfStart;
    private String shortDescription;
    private String longDescription;
    private String status;
    private List<StepFullResponseDto> steps = new ArrayList<>();
    private String photo;

    public WineFullResponseDto(Long id, String name, LocalDate dateOfStart, String shortDescription, String longDescription, String status, List<StepFullResponseDto> steps, String photo) {
        this.id = id;
        this.name = name;
        this.dateOfStart = dateOfStart;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.status = status;
        this.steps = steps;
        this.photo = photo;
    }

    public WineFullResponseDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfStart() {
        return dateOfStart;
    }


    public void setDateOfStart(LocalDate dateOfStart) {
        this.dateOfStart = dateOfStart;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<StepFullResponseDto> getSteps() {
        return steps;
    }

    public void setSteps(List<StepFullResponseDto> steps) {
        this.steps = steps;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}

