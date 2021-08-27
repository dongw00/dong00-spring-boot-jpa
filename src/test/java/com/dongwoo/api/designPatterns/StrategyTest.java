package com.dongwoo.api.designPatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import lombok.Data;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StrategyTest {

    @DisplayName("Strategy pattern")
    @Test
    void main() {
        List<Stock> stocks = new ArrayList<>();

        stocks.add(new Stock("AAPL", 318.65, 10));
        stocks.add(new Stock("Google", 99, 12.5));
        stocks.add(new Stock("MSFT", 166.86, 45));
        stocks.add(new Stock("AMZ", 1866.74, 45));

        StockFilters.filter(stocks, stock -> stock.getSymbol().equals("AMZ"))
            .forEach(System.out::println);
    }
}

@Data
class Stock {

    private final String symbol;
    private final double price;
    private final double units;
}

class StockFilters {

    static List<Stock> filter(List<Stock> list, Predicate<Stock> predicate) {
        List<Stock> filteredData = new ArrayList<>();
        for (Stock stock : list) {
            if (predicate.test(stock)) {
                filteredData.add(stock);
            }
        }

        return filteredData;
    }
}
