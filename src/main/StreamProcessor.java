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

    /*lambda example*/
    public void getTopSalesPeople(List<Sale> sales, int numberOfPersons) {

        /*get new list cause original is unmodifiable*/
        List<Sale> newSortedSaleList = new ArrayList<>(sales);

        /*compare and collect to new list sorted properties,
        * passed new modifiable list, and instance of new Comaprator object,
        * declaring return of sorted list by paramtere*/
//        Collections.sort(newSortedSaleList, new Comparator<Sale>() {
//            @Override
//            public int compare(Sale o1, Sale o2) {
//                return o2.getSaleAmount().compareTo(o1.getSaleAmount());
//            }
//        });

        /*lambda example of collections.sort*/
        Collections.sort(newSortedSaleList, (o1, o2) -> o2.getSaleAmount().compareTo(o1.getSaleAmount()));

        System.out.println("----------best sales over 600 EUR------");

        /*printing lambda example results*/
        for (int i = 0; i < numberOfPersons; i++) {
            if (newSortedSaleList.get(i).getSaleAmount() > 500.00) {
                System.out.println(newSortedSaleList.get(i).getSalesPerson() + ", " + newSortedSaleList.get(i).getSaleAmount() + " EUR");

            }
        }



    }

    /*Stream example*/
    public void getTopSalesPeopleStream(List<Sale> sales, int numberOfPersons){

        List<Sale> sortedSale = sales.stream().sorted(Comparator.comparing(Sale::getSaleAmount).reversed()).toList();

        System.out.println("----------best sales over 600 EUR------");

        /*printing stream example results*/
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
