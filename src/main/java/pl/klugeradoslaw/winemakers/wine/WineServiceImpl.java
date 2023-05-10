package pl.klugeradoslaw.winemakers.wine;

import org.springframework.stereotype.Service;
import pl.klugeradoslaw.winemakers.step.Step;
import pl.klugeradoslaw.winemakers.wine.dto.WineFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineSaveDto;
import pl.klugeradoslaw.winemakers.storage.FileStorageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;
    private final FileStorageService fileStorageService;

    public WineServiceImpl(WineRepository wineRepository, FileStorageService fileStorageService) {
        this.wineRepository = wineRepository;
        this.fileStorageService = fileStorageService;
    }

    public List<WineHomePageDto> findAll() {
        return wineRepository.findAll()
                .stream()
                .map(WineDtoMapper::mapHomePage)
                .toList();
    }

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
}
