package pl.klugeradoslaw.winemakers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.klugeradoslaw.winemakers.wine.WineService;
import pl.klugeradoslaw.winemakers.wine.dto.WineFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;

import java.util.List;
import java.util.Optional;

@Controller
public class WineController {
    private final WineService wineService;

    public WineController(WineService wineService) {
        this.wineService = wineService;
    }

//    @GetMapping("/")
//    public String home(Model model) {
//        List<WineHomePageDto> wines = wineService.findAll();
//        model.addAttribute("wines", wines);
//        return "index";
//    }

    @GetMapping("/wine/{id}")
    public String getWine(@PathVariable long id, Model model) {
        Optional<WineFullResponseDto> optionalWine = wineService.findWineById(id);
        optionalWine.ifPresent(wine -> model.addAttribute("wine", wine));
        return "wine";
    };


}
