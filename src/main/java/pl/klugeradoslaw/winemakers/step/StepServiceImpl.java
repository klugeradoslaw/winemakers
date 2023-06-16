package pl.klugeradoslaw.winemakers.step;

import org.springframework.stereotype.Service;
import pl.klugeradoslaw.winemakers.step.dto.StepFullResponseDto;
import pl.klugeradoslaw.winemakers.step.dto.StepSaveDto;
import pl.klugeradoslaw.winemakers.wine.Wine;
import pl.klugeradoslaw.winemakers.wine.WineRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StepServiceImpl implements StepService {

    private final StepRepository stepRepository;
    private final WineRepository wineRepository;

    public StepServiceImpl(StepRepository stepRepository, WineRepository wineRepository) {
        this.stepRepository = stepRepository;
        this.wineRepository = wineRepository;
    }

    @Override
    public List<StepFullResponseDto> findAll() {
        return stepRepository.findAll()
                .stream()
                .map(StepDtoMapper::mapFullResponse)
                .toList();
    }
    @Override
    public void addStep(long id, StepSaveDto stepSaveDto) {
        Step step = new Step();
        step.setDateOfStep(stepSaveDto.getDateOfStep());
        step.setDescription(stepSaveDto.getDescription());
        step.setWineId(id);
        stepRepository.save(step);
    }
    @Override
    public void deleteAllStepsByWineId(Long id) {
        List<Step> stepsToDelete = stepRepository.findByWineId(id);
        stepRepository.deleteAll(stepsToDelete);
    }
    @Override
    public void deleteStep(Long wineId, Long stepId) {
        Optional<Wine> optionalWine = wineRepository.findById(wineId);
        if (optionalWine.isPresent()) {
            Wine wine = optionalWine.get();
            stepRepository.deleteById(stepId);
            wineRepository.save(wine);
        } else {
            throw new RuntimeException();
        }
    }

}
