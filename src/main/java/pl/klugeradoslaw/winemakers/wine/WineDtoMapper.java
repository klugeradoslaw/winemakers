package pl.klugeradoslaw.winemakers.wine;

import pl.klugeradoslaw.winemakers.wine.dto.WineFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;

public class WineDtoMapper {
    static WineHomePageDto mapHomePage(Wine wine) {
        return new WineHomePageDto(
                wine.getId(),
                wine.getName(),
                wine.getDateOfStart(),
                wine.getShortDescription(),
                wine.getStatus().toString()
        );

        }
    static WineFullResponseDto mapFullResponse(Wine wine) {
        return new WineFullResponseDto(
                wine.getId(),
                wine.getName(),
                wine.getDateOfStart(),
                wine.getShortDescription(),
                wine.getLongDescription(),
                wine.getStatus().toString(),
                wine.getSteps().stream().toList()
        );
    }
}
