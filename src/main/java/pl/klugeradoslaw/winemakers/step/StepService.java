package pl.klugeradoslaw.winemakers.step;

import pl.klugeradoslaw.winemakers.step.dto.StepFullResponseDto;
import pl.klugeradoslaw.winemakers.step.dto.StepSaveDto;
import pl.klugeradoslaw.winemakers.wine.Wine;

import java.util.List;
import java.util.Optional;

public interface StepService {

    public List<StepFullResponseDto> findAll();

    public void addStep(long id, StepSaveDto stepSaveDto);

    public void deleteAllStepsByWineId(Long id);

    public void deleteStep(Long wineId, Long stepId);

}
