package pl.klugeradoslaw.winemakers.step;

import org.springframework.stereotype.Service;
import pl.klugeradoslaw.winemakers.step.dto.StepFullResponseDto;
import pl.klugeradoslaw.winemakers.step.dto.StepSaveDto;
import pl.klugeradoslaw.winemakers.wine.Wine;
import pl.klugeradoslaw.winemakers.wine.WineRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class StepService {

    private final StepRepository stepRepository;
    private final WineRepository wineRepository;

    public StepService(StepRepository stepRepository, WineRepository wineRepository) {
        this.stepRepository = stepRepository;
        this.wineRepository = wineRepository;
    }

    public List<StepFullResponseDto> findAll() {
        return stepRepository.findAll()
                .stream()
                .map(StepDtoMapper::mapFullResponse)
                .toList();
    }

    public void addStep(long id, StepSaveDto stepSaveDto) {
        Step step = new Step();
        step.setDateOfStep(stepSaveDto.getDateOfStep());
        step.setDescription(stepSaveDto.getDescription());
        step.setWineId(id);
        stepRepository.save(step);
    }

    public void deleteAllStepsByWineId(Long id) {
        List<Step> stepsToDelete = stepRepository.findByWineId(id);
        for (Step step : stepsToDelete) {
            stepRepository.delete(step);
        }
    }

    //wyjatek do dodania
    public void deleteStep(Long wineId, Long stepId) {
        Optional<Wine> optionalWine = wineRepository.findById(wineId);
        if (optionalWine.isPresent()) {
            Wine wine = optionalWine.get();
            List<Step> steps = wine.getSteps();
            stepRepository.deleteById(stepId);
            //steps.removeIf(step -> step.getId().equals(stepId));
            wineRepository.save(wine);
        } else {
            throw new RuntimeException();
        }
    }

}
