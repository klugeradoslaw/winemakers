package pl.klugeradoslaw.winemakers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.klugeradoslaw.winemakers.common.Message;
import pl.klugeradoslaw.winemakers.step.StepService;
import pl.klugeradoslaw.winemakers.step.dto.StepSaveDto;
import pl.klugeradoslaw.winemakers.wine.WineService;
import pl.klugeradoslaw.winemakers.wine.WineStatus;
import pl.klugeradoslaw.winemakers.wine.dto.WineFullResponseDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineHomePageDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineSaveDto;
import pl.klugeradoslaw.winemakers.wine.dto.WineToUpdateDto;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
public class WineController {
    private final WineService wineService;

    public WineController(WineService wineService) {
        this.wineService = wineService;
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


    @GetMapping("/wine/{id}/delete")
    public String deleteWine(@PathVariable long id, Model model) {
        model.addAttribute("wine", wineService.findWineById(id));
        wineService.deleteWineById(id);
        model.addAttribute("message", new Message("Wine deleted", "Wine deleted correctly."));
        return "message";
    }


    @PostMapping("/wine/add")
    public String addWine(@ModelAttribute("wine") WineSaveDto wine, Model model) {
        wineService.addWine(wine);
        model.addAttribute("message", new Message("Sukces!", "Nowe wino zostało dodane do bazy danych!"));
        return "message";
    }


    @GetMapping("/wine/{id}/edit")
    public String editWineForm(@PathVariable long id, Model model) {
        List<WineStatus> allStatuses = Arrays.asList(WineStatus.values());
        model.addAttribute("statuses", allStatuses);

        Optional<WineFullResponseDto> optionalWine = wineService.findWineById(id);
        optionalWine.ifPresent(wine -> model.addAttribute("wine", wine));

        return "edit_wine";
    }


    @PostMapping("/wine/{id}/edited")
    public String updateWine(@PathVariable Long id, WineToUpdateDto wineToUpdate, Model model) {
        wineService.updateWine(id, wineToUpdate);
        model.addAttribute("wine", wineToUpdate);
        model.addAttribute("message", new Message("Sukces!", "Wino zostało zaktualizowane!"));
        return "message";
    }

}
