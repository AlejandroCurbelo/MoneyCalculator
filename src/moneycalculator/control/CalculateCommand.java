package moneycalculator.control;

import moneycalculator.ui.MoneyDialog;
import moneycalculator.ui.MoneyDisplay;

public class CalculateCommand implements Command {

    private final MoneyDisplay moneyDisplay;
    private final MoneyDialog moneyDialog;

    public CalculateCommand(MoneyDialog moneyDialog, MoneyDisplay moneyDisplay) {
        this.moneyDisplay = moneyDisplay;
        this.moneyDialog = moneyDialog;
    }

    @Override
    public String name() {
        return "calculate";
    }

    @Override
    public void execute() {
        moneyDisplay.display(moneyDialog.get());
    }
    
}
