package model;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CurrencySet implements Iterable<Currency> {
    
    private Set<Currency> currencySet;

    public CurrencySet() {
        this.currencySet = new HashSet<>();
    }
    
    public void add(Currency currency) {
        currencySet.add(currency);
    }
    
    public void remove(Currency currency) {
        if(currencySet.contains(currency)) currencySet.remove(currency);
    }

    public Currency[] getItems() {
        return currencySet.toArray(new Currency[currencySet.size()]);
    }

    @Override
    public Iterator<Currency> iterator() {
        return currencySet.iterator();
    }
    
}
