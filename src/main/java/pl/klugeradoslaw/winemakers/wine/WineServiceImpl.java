package pl.klugeradoslaw.winemakers.wine;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import pl.klugeradoslaw.winemakers.step.Step;
import pl.klugeradoslaw.winemakers.step.StepDtoMapper;
import pl.klugeradoslaw.winemakers.step.StepRepository;
import pl.klugeradoslaw.winemakers.step.StepService;
import pl.klugeradoslaw.winemakers.step.dto.StepFullResponseDto;
import pl.klugeradoslaw.winemakers.step.dto.StepSaveDto;
import pl.klugeradoslaw.winemakers.storage.FileStorageService;
import pl.klugeradoslaw.winemakers.wine.dto.WineFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineSaveDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineToUpdateDto;

import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;
    private final StepService stepService;
    private final FileStorageService fileStorageService;
    private final StepRepository stepRepository;

    public WineServiceImpl(WineRepository wineRepository, StepService stepService, FileStorageService fileStorageService,
                           StepRepository stepRepository) {
        this.wineRepository = wineRepository;
        this.stepService = stepService;
        this.fileStorageService = fileStorageService;
        this.stepRepository = stepRepository;
    }

    @Override
    public List<WineHomePageDto> findAll() {
        return wineRepository.findAll()
                .stream()
                .map(WineDtoMapper::mapHomePage)
                .toList();
    }

    @Override
    public Optional<WineFullResponseDto> findWineById(long id) {
        return wineRepository.findById(id).map(WineDtoMapper::mapFullResponse);
    }


    @Override
    public void addWine(WineSaveDto wineToSave) {
        Wine wine = new Wine();
        wine.setName(wineToSave.getName());
        wine.setDateOfStart(wineToSave.getDateOfStart());
        wine.setShortDescription(wineToSave.getShortDescription());
        wine.setLongDescription(wineToSave.getLongDescription());
        wine.setStatus(WineStatus.valueOf(wineToSave.getStatus()));
        wine.setSteps(new ArrayList<Step>());
        if (wineToSave.getPhoto() != null) {
            String savedFileName = fileStorageService.saveImage(wineToSave.getPhoto());
            wine.setPhoto(savedFileName);
        }
        wineRepository.save(wine);
    }

    @Override
    public void deleteWineById(Long id) {
        stepService.deleteAllStepsByWineId(id);
        wineRepository.deleteById(id);
    }

    // wyjątek do dodania
    @Override
    public void updateWine(long wineId, WineToUpdateDto wineDto) {
        Optional<Wine> optionalWine = wineRepository.findById(wineId);
        if (optionalWine.isPresent()) {
            Wine wine = optionalWine.get();
            wine.setName(wineDto.getName());
            wine.setShortDescription(wineDto.getShortDescription());
            wine.setLongDescription(wineDto.getLongDescription());
            wine.setStatus(WineStatus.valueOf(wineDto.getStatus()));
            wineRepository.save(wine);
        } else {
            throw new RuntimeException();
        }
    }
}