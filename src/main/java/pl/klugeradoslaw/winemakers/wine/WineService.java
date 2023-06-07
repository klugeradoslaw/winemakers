package pl.klugeradoslaw.winemakers.wine;

import org.springframework.stereotype.Service;
import pl.klugeradoslaw.winemakers.wine.dto.WineFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineSaveDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineToUpdateDto;

import java.util.List;
import java.util.Optional;

@Service
public interface WineService {

    List<WineHomePageDto> findAll();
    Optional<WineFullResponseDto> findWineById(long id);
    void addWine(WineSaveDto wineToSave);
    void deleteWineById(Long id);
    void updateWine(long wineId, WineToUpdateDto wineToUpdate);
}
