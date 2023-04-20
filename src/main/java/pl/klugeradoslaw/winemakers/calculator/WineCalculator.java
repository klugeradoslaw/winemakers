package pl.klugeradoslaw.winemakers.calculator;

import org.springframework.stereotype.Component;

@Component
public class WineCalculator {
    private double amountOfSugar;
    private double alcoholPercentage;
    private double amountOfWineInCarboy;

    public WineCalculator() {
    }

    public double getAmountOfSugar() {
        return amountOfSugar;
    }

    public void setAmountOfSugar(double amountOfSugar) {
        this.amountOfSugar = amountOfSugar;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public double getAmountOfWineInCarboy() {
        return amountOfWineInCarboy;
    }

    public void setAmountOfWineInCarboy(double amountOfWineInCarboy) {
        this.amountOfWineInCarboy = amountOfWineInCarboy;
    }
}