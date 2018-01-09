package view.persistence;

import model.Currency;
import model.CurrencySet;

public class MockCurrencySetLoader {
    
    public CurrencySet load() {
        CurrencySet currencySet = new CurrencySet();
        currencySet.add(new Currency("EUR", "Euro", "€"));
        currencySet.add(new Currency("USD", "Dolar", "$"));
        return currencySet;
    }    
}
