package pl.klugeradoslaw.winemakers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.klugeradoslaw.winemakers.common.Message;
import pl.klugeradoslaw.winemakers.step.StepService;
import pl.klugeradoslaw.winemakers.step.dto.StepSaveDto;
import pl.klugeradoslaw.winemakers.wine.WineService;
import pl.klugeradoslaw.winemakers.wine.WineStatus;
import pl.klugeradoslaw.winemakers.wine.dto.WineFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineSaveDto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class WineController {
    private final WineService wineService;
    private final StepService stepService;

    public WineController(WineService wineService, StepService stepService) {
        this.wineService = wineService;
        this.stepService = stepService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<WineHomePageDto> wines = wineService.findAll();
        model.addAttribute("wines", wines);
        return "index";
    }

    @GetMapping("/wine/{id}")
    public String getWine(@PathVariable long id, Model model) {
        Optional<WineFullResponseDto> optionalWine = wineService.findWineById(id);
        optionalWine.ifPresent(wine -> model.addAttribute("wine", wine));
        StepSaveDto step = new StepSaveDto();
        model.addAttribute("step", step);
        return "wine";
    }

    @GetMapping("/wine/new")
    public String newWineForm(Model model) {
        List<WineStatus> allStatuses = Arrays.asList(WineStatus.values());
        model.addAttribute("statuses", allStatuses);
        WineSaveDto wine = new WineSaveDto();
        model.addAttribute("wine", wine);
        return "create_wine";
    }

//czy @modelattribute jest potrzebne?
    @PostMapping("/wine/add")
    public String addWine(@ModelAttribute("wine") WineSaveDto wine, Model model) {
        wineService.addWine(wine);
        model.addAttribute("message", new Message("Sukces!", "Nowe wino zostało dodane do bazy danych!"));
        return "message";
    }

    @PostMapping("/wine/{id}/step/add")
    public String addStepToWine(@PathVariable Long id, StepSaveDto step, Model model) {
        Optional<WineFullResponseDto> optionalWine = wineService.findWineById(id);
        optionalWine.ifPresent(wine -> model.addAttribute("wine", wine));
        wineService.addStep(id, step);
        model.addAttribute("step", step);
        model.addAttribute("message", new Message("Sukces!", "Dnia " + step.getDateOfStep() + " dodano kolejny etap wina o treści: " + step.getDescription()));
        return "message";
    }

}
