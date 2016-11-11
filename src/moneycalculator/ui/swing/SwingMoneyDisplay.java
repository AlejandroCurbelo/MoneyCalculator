package moneycalculator.ui.swing;

import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import moneycalculator.ui.MoneyDisplay;

public class SwingMoneyDisplay extends JPanel implements MoneyDisplay {

    public SwingMoneyDisplay() {
        setLayout(new FlowLayout());
        add(amount());
        add(currency());
    }

    private JLabel amount() {
        JLabel jLabel = new JLabel("500");
        return jLabel;
    }

    private JLabel currency() {
        JLabel jLabel = new JLabel("$");
        return jLabel;
    }
}
