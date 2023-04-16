package main;

import java.text.DecimalFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class StreamProcessor {


    public double getTotalSales(List<Sale> sales) {
        double sum = sales.stream().mapToDouble(s -> s.getSaleAmount()).sum();
        return sum;

    }

    public void getSalesByRegion(List<Sale> sales, String region) {
       List<Sale> regionStream = sales.stream().filter(s -> s.getRegion().contains(region.toLowerCase())).collect(Collectors.toList());
        for (Sale r : regionStream) {
            System.out.println("region " + region + "has " + r.getSalesPerson());
        }
    }

    public void getTopSalesPeople(List<Sale> sales, int numberOfPersons) {
//        get new list cause original is unmodifiable
//        List<Sale> newSortedSaleList = new ArrayList<>(sales);

//        test print of list
//        for (Sale s : sales) {
//            System.out.println(s.getSalesPerson());
//        }

//        compare and collect to new list sorted properties
//        Collections.sort(newSortedSaleList, new Comparator<Sale>() {
//            @Override
//            public int compare(Sale o1, Sale o2) {
//                return o2.getSaleAmount().compareTo(o1.getSaleAmount());
//            }
//        });

//        lambda example of collections.sort
//        Collections.sort(newSortedSaleList, (o1, o2) -> o2.getSaleAmount().compareTo(o1.getSaleAmount()));

//        stream example of sorting
//        List<Sale> sortedSale = sales.stream().sorted(Comparator.comparing(Sale::getSaleAmount)).toList();
//        stream example of sorting reversed
        List<Sale> sortedSale = sales.stream().sorted(Comparator.comparing(Sale::getSaleAmount).reversed()).toList();

        System.out.println("----------best sales over 600 EUR------");

//        printing lambda example results
//        for (int i = 0; i < numberOfPersons; i++) {
//            if (newSortedSaleList.get(i).getSaleAmount() > 500.00) {
//                System.out.println(newSortedSaleList.get(i).getSalesPerson() + ", " + newSortedSaleList.get(i).getSaleAmount() + " EUR");
//
//            }
//        }

//        printing stream example results
        for (int i = 0; i < numberOfPersons; i++) {
            if (sortedSale.get(i).getSaleAmount() > 500.00) {
                System.out.println(sortedSale.get(i).getSalesPerson() + ", " + sortedSale.get(i).getSaleAmount() + " EUR");

            }
        }

    }

    public double getAverageSale(List<Sale> sales) {
        OptionalDouble avg = sales.stream().mapToDouble(s -> s.getSaleAmount()).average();
//        System.out.println("Average: "  + avg.getAsDouble());
        return avg.getAsDouble();
    }
}
