package pl.klugeradoslaw.winemakers.wine.dto;

import org.springframework.web.multipart.MultipartFile;
import pl.klugeradoslaw.winemakers.step.dto.StepFullResponseDto;

import java.time.LocalDate;
import java.util.List;

public class WineToUpdateDto {
    private Long id;
    private String name;
    private String shortDescription;
    private String longDescription;
    private String status;

    public WineToUpdateDto() {
    }

    public WineToUpdateDto(Long id, String name, String shortDescription, String longDescription, String status) {
        this.id = id;
        this.name = name;
        this.shortDescription = shortDescription;
        this.longDescription = longDescription;
        this.status = status;

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
}

