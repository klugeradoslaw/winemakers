package pl.klugeradoslaw.winemakers.wine;

import pl.klugeradoslaw.winemakers.step.StepDtoMapper;
import pl.klugeradoslaw.winemakers.step.dto.StepFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;

import java.util.List;

public class WineDtoMapper {
    static WineHomePageDto mapHomePage(Wine wine) {
        return new WineHomePageDto(
                wine.getId(),
                wine.getName(),
                wine.getDateOfStart(),
                wine.getShortDescription(),
                wine.getStatus().toString(),
                wine.getPhoto()
        );

    }

    static WineFullResponseDto mapFullResponse(Wine wine) {
        List<StepFullResponseDto> steps = wine.getSteps().stream().map(StepDtoMapper::mapFullResponse).toList();
        WineFullResponseDto dto = new WineFullResponseDto();
        dto.setId(wine.getId());
        dto.setName(wine.getName());
        dto.setDateOfStart(wine.getDateOfStart());
        dto.setShortDescription(wine.getShortDescription());
        dto.setLongDescription(wine.getLongDescription());
        dto.setStatus(wine.getStatus().toString());
        dto.setSteps(steps);
        dto.setPhoto(wine.getPhoto());

        return dto;
    }
}
