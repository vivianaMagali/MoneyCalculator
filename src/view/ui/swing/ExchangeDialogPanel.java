package view.ui.swing;

import java.awt.FlowLayout;
import static java.awt.FlowLayout.LEFT;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Currency;
import model.CurrencySet;
import model.Exchange;
import model.Money;
import view.ui.ExchangeDialog;

public class ExchangeDialogPanel extends JPanel implements ExchangeDialog{
    
    private final CurrencySet currencySet;
    private JTextField amount;
    private JComboBox<Currency> fromCurrency;
    private JComboBox<Currency> toCurrency;

    public ExchangeDialogPanel(CurrencySet currencySet) {
        super();
        this.currencySet = currencySet;
        this.setLayout(new FlowLayout(LEFT));
        this.createWidgets();
    }
    
    @Override
    public Exchange getExchange() {
        if(!amount.getText().equals("")) {
            return new Exchange(new Money(getAmount(), getFromCurrency()), getToCurrency());
        }
        return null;
    }

    private void createWidgets() {
        this.add(createAmountWidget());
        this.add(createFromCurrencyWidget());
        this.add(createToCurrencyWidget());
    }

    private JTextField createAmountWidget() {
        JTextField amount = new JTextField();
        amount.setColumns(20);
        this.amount = amount;
        return amount;
    }

    private JComboBox createFromCurrencyWidget() {
        JComboBox<Currency> combo = new JComboBox<>(currencySet.getItems());
        combo.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent event) {
                if(event.getStateChange() == ItemEvent.DESELECTED) return;
                addCurrenciesToTargetCombobox();
            }
        });
        
        this.fromCurrency = combo;
        return combo;
    }

    private JComboBox createToCurrencyWidget() {
        JComboBox<Currency> combo = new JComboBox<>(currencySet.getItems());
        this.toCurrency = combo;
        addCurrenciesToTargetCombobox();
        return combo;
    }
    
    private double getAmount() {
        try {
            return Double.parseDouble(amount.getText());
        }
        catch(Exception exception) {
            return 0;
        }
    }
    
    private Currency getFromCurrency() {
        return fromCurrency.getItemAt(fromCurrency.getSelectedIndex());
    }
    
    private Currency getToCurrency() {
        return toCurrency.getItemAt(toCurrency.getSelectedIndex());
    }

    private void addCurrenciesToTargetCombobox() {
        toCurrency.removeAllItems();
        for (Currency currency : currencySet) {
            if (currency == getFromCurrency()) continue;
            toCurrency.addItem(currency);
        }
    }  
}

