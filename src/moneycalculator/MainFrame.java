package moneycalculator;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import moneycalculator.ui.Swing.SwingMoneyDialog;
import moneycalculator.ui.Swing.SwingMoneyDisplay;

class MainFrame extends JFrame{

    SwingMoneyDialog moneyDialog;
    SwingMoneyDisplay moneyDisplay;
    
    public MainFrame() {
        setTitle("Money Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        add(moneyDialog(), BorderLayout.NORTH);
        add(moneyDisplay(), BorderLayout.CENTER);
        add(toolbar(), BorderLayout.SOUTH);
        setVisible(true);
    }

    private Component moneyDialog() {
        SwingMoneyDialog swingMoneyDialog = new SwingMoneyDialog();
        return swingMoneyDialog;
    }

    private Component moneyDisplay() {
        SwingMoneyDisplay swingMoneyDisplay = new SwingMoneyDisplay();
        return swingMoneyDisplay;
    }

    private Component toolbar() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(calculateButton());
        return panel;
    }

    private Component calculateButton() {
        JButton button = new JButton("Calculate");
        button.addActionListener(calculate());
        return button;
    }

    private ActionListener calculate() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                moneyDisplay.display(moneyDialog.get());
            }
        };
    }
    
}
