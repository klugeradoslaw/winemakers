package pl.klugeradoslaw.winemakers.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.klugeradoslaw.winemakers.common.Message;
import pl.klugeradoslaw.winemakers.step.StepService;
import pl.klugeradoslaw.winemakers.step.dto.StepSaveDto;

import java.time.LocalDate;

@Controller
public class StepController {

    private final StepService stepService;

    public StepController(StepService stepService) {
        this.stepService = stepService;
    }

    @PostMapping("/wine/{id}/step/add")
    public String addStepToWine(@PathVariable Long id, StepSaveDto step, Model model) {
        step.setDateOfStep(LocalDate.now());
        stepService.addStep(id, step);
        model.addAttribute("step", step);
        model.addAttribute("message", new Message("Sukces!", "Dnia " + step.getDateOfStep() + " dodano kolejny etap wina o treści: " + step.getDescription()));
        return "message";
    }
}
