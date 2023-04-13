package main;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperationsExample {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("Paris", "Venice","Berlin", "London","Vienna", "Helsinki");
        long count = stream.count();
        System.out.println(count);

        Stream<String> stream2 = Stream.of("Paris", "Venice","Berlin", "London","Vienna", "Helsinki", "Lisbon", "Rome");
        Optional<String> min = stream2.min((o1, o2) -> o1.length() - o2.length());
        if(min.isPresent()) {
            System.out.println("Min: " + min.get());
        }

        Stream<String> stream3 = Stream.of("Paris", "Venice","Berlin", "London","Vienna", "Helsinki", "Lisbon", "Rome");
        Optional<String> max = stream3.max((o1, o2) -> o1.length() - o2.length());
        if(max.isPresent()) {
            System.out.println("Max: " + max.get());
        }

        Stream<String> stream4 = Stream.of("Paris", "Venice","Berlin", "London","Vienna", "Helsinki", "Lisbon", "Rome");
        Optional<String> optionalFirst = stream4.findFirst();
        System.out.println("Find first: " +  optionalFirst.get());

        Stream<String> stream5 = Stream.of("Paris", "Venice","Berlin", "London","Vienna", "Helsinki", "Lisbon", "Rome");
        Optional<String> findAny = stream5.findAny();
        System.out.println("Find any: " +  findAny.get());

        Stream<String> stream6 = Stream.of("Paris", "Venice","Berlin", "London","Vienna", "Helsinki", "Lisbon", "Rome");
        boolean isAnyMatch = stream6.anyMatch(s -> s.startsWith("V"));
        System.out.println("Find any match: " +  isAnyMatch);

        Stream<String> stream7 = Stream.of("Paris", "Venice","Berlin", "London","Vienna", "Helsinki", "Lisbon", "Rome");
        boolean allMAtch = stream7.allMatch(s -> s.startsWith("P"));
        System.out.println("Find all match: " +  allMAtch);

        Stream<Double> doubleStream = Stream.of(1.0,2.0,3.0);
        //inital value, acumulator-current value combined with value in stream in iteration/order, combiner - spaja akumulatore
        Double doubleOptional = doubleStream.reduce(0.0,
                (currentValue, streamValue) -> currentValue + streamValue,
                (accumulator1, accumulator2) -> accumulator1 + accumulator2);
        System.out.println("Reduce: " +  doubleOptional);

        Stream<String> stream9 = Stream.of("Paris", "Venice","Berlin", "London","Vienna", "Helsinki", "Lisbon", "Rome");
        List<String> listStrings = stream9.collect(Collectors.toList());
        listStrings.stream().forEach( s-> System.out.println("collect: " + s));


    }
}
