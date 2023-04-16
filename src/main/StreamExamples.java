package main;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

    public static void main(String[] args) {

        //        EXAMPLE 1
//        Stream<String> stream = Stream.of("string1", "string2", "string3","string4");
//        stream.forEach(s -> System.out.println(s.contains("ing2")));

//        EXAMPLE 2
        // Get the stream
//        Stream<String> stream2 = Stream.of("Geeks", "For","Geeks", "A","Computer", "Portal");
        // Print the stream
//        stream2.forEach(s -> System.out.println(s.toUpperCase()));

//        EXAMPLE 3
//        List<String> list1 = List.of();
//        List<String> list2 = List.of("string1", "string2");
//        List<String> list3 = List.of("string3", "string4");
//
//        Stream<List<String>> listStream = Stream.of(list1, list2, list3);
//        Stream<String> stringStreams = listStream.flatMap(list -> list.stream());
//
//        stringStreams.forEach( a -> System.out.println(a));

//        EXAMPLE 3
        Stream<String> stream4 = Stream.of("Paris", "Venice","Berlin", "London","Vienna", "Helsinki");
//            List<String> stream4 = List.of("paris", "venice","berlin", "london","vienna", "helsinki");

        // ne sortira
//        Stream<String> stream4sorted = stream4.stream().sorted((s1,s2) -> s1.length() - s2.length());

//        ??? ne sortira
//        Stream<String> stream4sorted = stream4.sorted(Comparator.comparingInt(String::length));

        // sortira,
//        List<String> listString = stream4.stream().sorted().collect(Collectors.toList());
        List<String> listString = stream4.sorted().collect(Collectors.toList());

//        printStream(stream4sorted);
        printList(listString);



//        Arrays.stream(stream4).forEachOrdered(System.out::println); ????
//        Stream.of(stream4).peek(System.out::println).sorted().forEachOrdered(s -> System.out.println(s)); ????
    }

    private static void printStream(Stream<?> stream) {
        stream.forEach(System.out::println);
    }

    private static void printList(List<?> stream) {
        stream.forEach(System.out::println);
    }
}
