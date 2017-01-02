package moneycalculator;

import moneycalculator.control.CalculateCommand;
import moneycalculator.model.Currency;

public class Main {
    
    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame(currencies());
        mainFrame.add(new CalculateCommand(mainFrame.getMoneyDialog(), mainFrame.getMoneyDisplay()));
    }

    private static Currency[] currencies() {
        return new Currency[]{
            new Currency("USD","Dólar estadounidense","$"),
            new Currency("CAD","Dólar canadiense","$"),
            new Currency("GBP","Libra esterlina","L")
        };
    }
    
}
