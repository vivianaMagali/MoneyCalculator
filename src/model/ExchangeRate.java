package model;

public class ExchangeRate {
    private final Currency fromCurrency, toCurrency;
    private final double rate;

    public ExchangeRate(Currency fromCurrency, Currency toCurrency, double rate) {
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.rate = rate;
    }

    public Currency getFromCurrency() {
        return fromCurrency;
    }

    public Currency getToCurrency() {
        return toCurrency;
    }

    public double getRate() {
        return rate;
    }   
}
