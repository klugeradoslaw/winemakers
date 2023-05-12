package pl.klugeradoslaw.winemakers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.klugeradoslaw.winemakers.wine.WineService;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;

import java.util.List;

@Controller
public class HomeController {

    private final WineService wineService;

    public HomeController(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<WineHomePageDto> wines = wineService.findAll();
        model.addAttribute("wines", wines);
        return "index";
    }


}
