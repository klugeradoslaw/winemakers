package pl.klugeradoslaw.winemakers.wine.dto;

import pl.klugeradoslaw.winemakers.wine.WineStatus;

import java.time.LocalDate;

public class WineHomePageDto {

    private Long id;
    private String name;
    private LocalDate dateOfStart;
    private String shortDescription;
    private String status;
    private String photo;

    public WineHomePageDto(Long id, String name, LocalDate dateOfStart, String shortDescription, String status, String photo) {
        this.id = id;
        this.name = name;
        this.dateOfStart = dateOfStart;
        this.shortDescription = shortDescription;
        this.status = status;
        this.photo = photo;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
