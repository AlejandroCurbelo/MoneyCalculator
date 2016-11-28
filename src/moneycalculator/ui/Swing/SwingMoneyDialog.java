package moneycalculator.ui.Swing;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import moneycalculator.model.Currency;
import moneycalculator.model.Money;
import moneycalculator.ui.MoneyDialog;

public class SwingMoneyDialog extends JPanel implements MoneyDialog {

    private String amount;
    private Currency currency;

    public SwingMoneyDialog() {
        setLayout(new FlowLayout());
        add(amount());
        add(currency());
    }

    @Override
    public Money get() {
        return new Money(Double.parseDouble(amount),currency);
    }

    private Component amount() {
        JTextField field = new JTextField(""+0);
        field.setColumns(10);
        field.getDocument().addDocumentListener(amountChanged());
        return field;
    }
    
    private Component currency() {
        JComboBox<Currency> combo = new JComboBox<>(currencies());
        currency = combo.getItemAt(0);
        combo.addItemListener(currencyChanged());
        return combo;
    }

    private Currency[] currencies() {
        return new Currency[] {
            new Currency("USD", "Dólar Americano", "$"),
            new Currency("GBP", "Libra Esterlina", "L"),
            new Currency("CAD", "Dólar Canadiense", "$")
        };
    }

    private ItemListener currencyChanged() {
        return new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.DESELECTED) return;
                currency = (Currency) e.getItem();
            }
        };
    }

    private DocumentListener amountChanged() {
        return new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateAmount(e);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateAmount(e);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateAmount(e);
            }

            private void updateAmount(DocumentEvent e) {
                try {
                    amount=e.getDocument().getText(0, e.getDocument().getLength());
                } catch (BadLocationException ex) {
                }
            }
        };
    }
    
}
