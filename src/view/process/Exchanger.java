package view.process;

import model.ExchangeRate;
import model.Money;

public class Exchanger {
    
    public static Money exchangeRate(Money money, ExchangeRate exchangeRate) {
        return new Money(calculateRate(money,exchangeRate), exchangeRate.getToCurrency());
    }

    private static double calculateRate(Money money, ExchangeRate exchangeRate) {
        return money.getAmount() * exchangeRate.getRate();
    }
    
}
