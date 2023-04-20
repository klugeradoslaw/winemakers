package pl.klugeradoslaw.winemakers.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/calc")
public class WineCalcController {

    private final WineCalcService wineCalcService;

    public WineCalcController(WineCalcService wineCalcService) {
        this.wineCalcService = wineCalcService;
    }

    @GetMapping
    String calcForm(Model model) {
        model.addAttribute("wineCalculator", new WineCalculator());
        return "calc";
    }

    @PostMapping
    String submitCalculation(@ModelAttribute("wineCalculator") WineCalculator wineCalculator, Model model) {
        if (wineCalculator.getAlcoholPercentage() < 0) {
            model.addAttribute("error", "Nie można uzyskać procentowego stężenia alkoholu na minusie!");
        } else if (wineCalculator.getAmountOfWineInCarboy() < 0) {
            model.addAttribute("error", "Nie istnieją baniaki z ujemną pojemnością! Wprowadź dodatnią liczbę!");
        } else {
            model.addAttribute("alcoholPercentage", wineCalculator.getAlcoholPercentage());
            model.addAttribute("amountOfWineInCarboy", wineCalculator.getAmountOfWineInCarboy());
            double amountOfSugar = wineCalcService.amountOfSugar(wineCalculator.getAlcoholPercentage(), wineCalculator.getAmountOfWineInCarboy());
            model.addAttribute("amountOfSugar", amountOfSugar);
        }
        return "calc";
    }
}
