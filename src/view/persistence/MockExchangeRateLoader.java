package view.persistence;

import model.Currency;
import model.ExchangeRate;

public class MockExchangeRateLoader implements ExchangeRateLoader{
    
    @Override
    public ExchangeRate load(Currency fromCurrency, Currency toCurrency) {
        if(fromCurrency.getCode().equals("EUR")) return new ExchangeRate(fromCurrency, toCurrency, 1.2);
        return new ExchangeRate(fromCurrency, toCurrency, 1.9);
    }
}
