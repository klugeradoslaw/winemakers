package pl.klugeradoslaw.winemakers.wine;

import org.springframework.stereotype.Service;
import pl.klugeradoslaw.winemakers.wine.dto.WineFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;

import java.util.List;
import java.util.Optional;

@Service
public class WineService {
    private final WineRepository wineRepository;

    public WineService(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
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

}
