package model;

public record CurrencyPair(String curFrom, String curTo) {

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
}
