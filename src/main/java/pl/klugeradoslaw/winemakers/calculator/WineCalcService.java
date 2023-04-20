package pl.klugeradoslaw.winemakers.calculator;

import org.springframework.stereotype.Service;

@Service
public class WineCalcService {

    // 17 grams sugar in 1 liter of wine makes 1% alkohol
    // rounded up to 2 decimal places -> (a * 100) / 100
    public double amountOfSugar(double alcoholPercentage, double amountOfWineInCarboy) {
        return Math.round((17 * alcoholPercentage * amountOfWineInCarboy / 1000)*100)/100D;
    }
}
