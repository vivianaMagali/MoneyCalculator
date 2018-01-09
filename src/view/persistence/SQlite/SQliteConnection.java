package view.persistence.SQlite;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Currency;
import model.CurrencySet;
import model.ExchangeRate;
import view.persistence.CurrencySetLoader;

public class SQliteConnection implements CurrencySetLoader{
    
    private final Connection connection;

    public SQliteConnection(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public CurrencySet loadCurrency() {
        String query = "SELECT * FROM currency";
        try {
            return processCurrencySet(connection.createStatement().executeQuery(query));
        } catch (SQLException exception) {
            System.out.println("Error Data Base ...");
            return null;
        }
    }
    
    private CurrencySet processCurrencySet(ResultSet resultSet) throws SQLException {
        CurrencySet currencySet = new CurrencySet();
        while(resultSet.next()) currencySet.add(processCurrency(resultSet));
        return currencySet;
    }

    private Currency processCurrency(ResultSet resultSet) throws SQLException {
        return new Currency(
                resultSet.getString("code"),
                resultSet.getString("name"),
                resultSet.getString("symbol")
        );
    }
    
    public ExchangeRate getExchangeRate(Currency fromCurrency, Currency toCurrency) {
        String query = "SELECT * FROM exchangeRate "
                     + "WHERE fromCurrency='" + fromCurrency + "' "
                     + "AND toCurrency='" + toCurrency + "'";
        try {
            return processExchangeRate(connection.createStatement().executeQuery(query),
                    fromCurrency,toCurrency);
        } catch (SQLException exception) {
            System.out.println("Error Data Base ...");
            return null;
        }
    }

    
    private ExchangeRate processExchangeRate(ResultSet resultSet, Currency fromCurrency, Currency toCurrency) throws SQLException {
        return new ExchangeRate(
                fromCurrency,
                toCurrency,
                Double.parseDouble(resultSet.getString("rate"))
        );
    }
}
