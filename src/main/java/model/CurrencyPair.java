package model;

import java.util.Objects;

public class CurrencyPair {

    public final String curFrom;
    public final String curTo;

    public CurrencyPair(String curFrom, String curTo) {
        this.curFrom = curFrom;
        this.curTo = curTo;
    }

    //cross pairs are equals regardless of currencies order
    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CurrencyPair other)) {
            return false;
        }
        return (this.curTo.equals(other.curTo) & this.curFrom.equals(other.curFrom));
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.curFrom, this.curTo);
    }
}
