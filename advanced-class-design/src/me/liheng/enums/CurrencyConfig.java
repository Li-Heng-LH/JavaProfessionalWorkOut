package me.liheng.enums;

public class CurrencyConfig {

    private CurrencyType currencyType;
    private String currency;

    public CurrencyConfig(CurrencyType currencyType, String currency) {
        this.currencyType = currencyType;
        this.currency = currency;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public String getCurrency() {
        return currency;
    }

    enum CurrencyType {
        FOREIGN,
        LOCAL
    }

    public static void main(String[] args) {
        CurrencyConfig config = new CurrencyConfig(CurrencyType.LOCAL, "USD");
        System.out.println(config.getCurrencyType() + " " + config.getCurrency());
    }
}
