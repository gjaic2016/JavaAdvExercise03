package main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");
    public static void main(String[] args) {

        List<Sale> salesList = List.of(
                new Sale("John", "region1", 360.33),
                new Sale("Mary", "region2", 640.45),
                new Sale("Paul", "region3", 553.56),
                new Sale("Ian", "region4", 239.78),
                new Sale("Zane", "region5", 890.89)
        );

        StreamProcessor streamsProc = new StreamProcessor();

//        for (Sale obj : salesList) {
//            System.out.println(obj.getSalesPerson());
//        }

       double totalSaleAmount = streamsProc.getTotalSales(salesList);
       System.out.println("Total sale amount: " +  decimalFormat.format(totalSaleAmount) + " EUR");

       double averageSalesAmount = streamsProc.getAverageSale(salesList);
       System.out.println("Average sales amount: " +  decimalFormat.format(averageSalesAmount) + " EUR");


    }
}

//ZADATAK - STREAMOVI

//1. kreirajte klasu "Sale" koja će predstavljati prodaju koju je prodavač napravio.
//Klasa bi  trebala sadržavati sljedeća polja:
//salesPerson - naziv prodavača
//region - regija u kojoj je prodaja obavljena
//amount - iznos prodaje

//2. Kreirajte klasu "StreamProcessor" koja će sadržavati sljedeće metode:
//getTotalSales(List<Sale> sales) - ova metoda bi trebala vratiti ukupan iznos prodaja

//getSalesByRegion(List<Sale> sales, String region) - ova metoda bi trebala vratiti listu
//svih prodaja obavljenih u određenoj regiji.

//getTopSalesPeople(List<Sale> sales, int n) - voa metoda bi trebala vratiti
//popis n prodavača koji su napravili najviše prodaja. Popis
//bi trebao biti sortiran po ukupnom iznosu prodaja u silaznom redoslijedu

//getAverageSale(List<Sale> sales) - ova metoda bi trebala vratiti prosječan iznos prodaje.

//3. U main klasi napravite listu Sale objekata i pozovite svaku od metoda.