package pl.klugeradoslaw.winemakers.step;

import pl.klugeradoslaw.winemakers.step.dto.StepFullResponseDto;

public class StepDtoMapper {

    public static StepFullResponseDto mapFullResponse(Step step) {
        return new StepFullResponseDto(
                step.getId(),
                step.getDateOfStep(),
                step.getDescription()
        );
    }
}