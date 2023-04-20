package pl.klugeradoslaw.winemakers.calculator;

import org.springframework.stereotype.Service;

@Service
public class WineCalcService {
    public double amountOfSugar(double alcoholPercentage, double amountOfWineInCarboy) {
        return 17 * alcoholPercentage * amountOfWineInCarboy / 1000;
    }
}
