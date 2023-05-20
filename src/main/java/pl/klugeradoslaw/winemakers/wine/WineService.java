package pl.klugeradoslaw.winemakers.wine;

import org.springframework.stereotype.Service;
import pl.klugeradoslaw.winemakers.step.Step;
import pl.klugeradoslaw.winemakers.step.dto.StepSaveDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineSaveDto;

import java.util.List;
import java.util.Optional;

@Service
public interface WineService {

    public List<WineHomePageDto> findAll();
    public Optional<WineFullResponseDto> findWineById(long id);
    public void addWine(WineSaveDto wineToSave);
    public void addStep(long id, StepSaveDto stepSaveDto);

}
