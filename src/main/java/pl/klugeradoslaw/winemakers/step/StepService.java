package pl.klugeradoslaw.winemakers.step;

import org.springframework.stereotype.Service;
import pl.klugeradoslaw.winemakers.step.dto.StepFullResponseDto;
import pl.klugeradoslaw.winemakers.step.dto.StepSaveDto;

import java.util.List;

@Service
public class StepService {

    private final StepRepository stepRepository;

    public StepService(StepRepository stepRepository) {
        this.stepRepository = stepRepository;
    }

    public List<StepFullResponseDto> findAll() {
        return stepRepository.findAll()
                .stream()
                .map(StepDtoMapper::mapFullResponse)
                .toList();
    }

    public void addStep(StepSaveDto stepSaveDto) {
        Step step = new Step();
        step.setDateOfStep(stepSaveDto.getDateOfStep());
        step.setDescription(stepSaveDto.getDescription());
        stepRepository.save(step);
    }
}
