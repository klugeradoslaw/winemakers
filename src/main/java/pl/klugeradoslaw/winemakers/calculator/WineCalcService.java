package pl.klugeradoslaw.winemakers.calculator;

import org.springframework.stereotype.Service;

@Service
public class WineCalcService {

    // 17 grams sugar in 1 liter of wine makes 1% alkohol
    public double amountOfSugar(double alcoholPercentage, double amountOfWineInCarboy) {
        return 17 * alcoholPercentage * amountOfWineInCarboy / 1000;
    }
}
