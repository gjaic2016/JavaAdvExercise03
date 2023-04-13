package main;

import java.text.DecimalFormat;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamProcessor {



    public double getTotalSales(List<Sale> sales) {
        double sum = sales.stream().mapToDouble(s -> s.getSaleAmount()).sum();
        return sum;

    }

    public void getSalesByRegion(List<Sale> sales, String region){}

    public void getTopSalesPeople(List<Sale> sales, int n) {

    }

    public double getAverageSale(List<Sale> sales) {
        OptionalDouble avg = sales.stream().mapToDouble(s -> s.getSaleAmount()).average();
//        System.out.println("Average: "  + avg.getAsDouble());
        return avg.getAsDouble();
    }
}
