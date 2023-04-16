package main;

import java.text.DecimalFormat;
import java.util.List;


public class Main {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    public static void main(String[] args) {

        List<Sale> salesList = List.of(
                new Sale("John", "region1", 360.33),
                new Sale("Mary", "region2", 640.45),
                new Sale("Paul", "region3", 553.56),
                new Sale("Ian", "region4", 239.78),
                new Sale("Zane", "region5", 890.89),
                new Sale("Anna", "region6", 1090.49),
                new Sale("Floki", "region7", 440.59)
        );

        StreamProcessor streamsProc = new StreamProcessor();

//        check list of sales
//        for (Sale obj : salesList) {
//            System.out.println(obj.getSalesPerson());
//        }

        streamsProc.getSalesByRegion(salesList, "region3");

       double totalSaleAmount = streamsProc.getTotalSales(salesList);
       System.out.println("Total sale amount: " +  decimalFormat.format(totalSaleAmount) + " EUR");

       streamsProc.getTopSalesPeople(salesList, 5);

       double averageSalesAmount = streamsProc.getAverageSale(salesList);
       System.out.println("Average sales amount: " +  decimalFormat.format(averageSalesAmount) + " EUR");


    }
}