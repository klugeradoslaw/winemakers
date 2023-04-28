package pl.klugeradoslaw.winemakers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.klugeradoslaw.winemakers.wine.Wine;
import pl.klugeradoslaw.winemakers.wine.WineRepository;

import java.util.List;

@Controller
public class HomeController {

    private final WineRepository wineRepository;

    public HomeController(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Wine> wines = wineRepository.findAll();
        model.addAttribute("wines", wines);
        return "index";
    }


}
