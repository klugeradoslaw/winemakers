package pl.klugeradoslaw.winemakers.wine;

import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;

public class WineDtoMapper {
    static WineHomePageDto map(Wine wine) {
        return new WineHomePageDto(
                wine.getId(),
                wine.getName(),
                wine.getDateOfStart(),
                wine.getShortDescription(),
                wine.getStatus().toString()
        );
    }
}
