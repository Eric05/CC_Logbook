package com.company.Oktober;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.*;

public class Day_16_Currency {

    private static final Map<String, Double> CURRENCY = new HashMap<String, Double>();
    private static final Map<String, Locale> FORMAT = new HashMap<String, Locale>();

    public Day_16_Currency() {
      generateCurrencyMap();
    }

    // if there are only two currencies
    public double euroToCurrency(double money, String currency) {
        double value = (currency.equals("usd")) ? 1.07 : 1.18;
        var res = money * value;
        return res;
    }

    // overload with own currency
    public double euroToCurrency(double money, double currency) {
        var res = money * currency;
        return res;
    }

    // same with Big Decimal and more possible currencies
    public static BigDecimal euroToCurrency(BigDecimal money, String currency) {
        BigDecimal value = new BigDecimal(CURRENCY.get(currency));
        var res = money.multiply(value);
        return res;
    }

    public static BigDecimal euroToCurrency(BigDecimal money, double currency) {
        var res = money.multiply(BigDecimal.valueOf(currency));
        return res;
    }

    // e.g by Csv File
    private void generateCurrencyMap(){
        List<String> currencyList = Arrays.asList(new String[]{"chf,1.08", "usd,1.18"});

        for (String s : currencyList) {
            var key = s.split(",")[0].trim().toLowerCase();
            var value = Double.valueOf(s.split(",")[1]);
            CURRENCY.put(key,value);
        }
    }

    private void generateOutputMap(){
        List<String> currencyList = Arrays.asList(new String[]{"chf,SUISSE", "usd,CANADA"});

        for (String s : currencyList) {
            var key = s.split(",")[0].trim().toLowerCase();
            var value = new Locale(s.split(",")[1]);
            FORMAT.put(key,value);
        }
    }
}
