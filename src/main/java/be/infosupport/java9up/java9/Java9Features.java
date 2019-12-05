package be.infosupport.java9up.java9;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Java9Features implements JavaFeatures {

    void httpRequest() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(new URI("https://postman-echo.com/get"))
            .GET()
            .header("Accept-Language", "nl")
            .build();

//            HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandler.asString()); //java 9
        HttpResponse<String> response =
            HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2) //standard, automatically downgraded
                .build()
                .send(httpRequest, HttpResponse.BodyHandlers.ofString()); //java 11

        System.out.println("Response from API: " + response.body());
    }

    void getProcessInfo() {
        ProcessInfo.Builder processInfoBuilder = new ProcessInfo.Builder();

        ProcessHandle processHandle = ProcessHandle.current();
        ProcessHandle.Info processHandleInfo = processHandle.info();
        String command = processHandleInfo.command().isPresent() ? processHandleInfo.command().get() : null;

        ProcessInfo processInfo = processInfoBuilder
            .processId(processHandle.pid())
            .command(command)
            .build();

        System.out.println("Process with id " + processInfo.getProcessId() + " had command " + processInfo.getCommand());
    }

    void killChildren() {
        Stream<ProcessHandle> children = ProcessHandle.current().children();
        children.forEach(ProcessHandle::destroy);
    }

    void printInterfaceAndClassName() {
        System.out.println(this.getInterfaceAndClassName());
    }


    void convertToSet(String... args) {
        Set<String> immutableSet = Set.of(args); //immutable set!

        System.out.println("The converted Set contains: " + immutableSet);
    }


    void convertToList(String... args) {
        List<String> stringList = List.of(args);

        System.out.println("The converted List contains: " + stringList);
    }


    @Deprecated(forRemoval = true, since = "9")
    void convertToList(String s1, String s2, int i1) {
        List<? extends Serializable> stringList = List.of(s1, s2, i1);

        System.out.println("The converted List contains: " + stringList);
    }

    void convertToMap(int key1, String var1, int key2, String var2) {
        Map<Integer, String> intStringMap = Map.of(key1, var1, key2, var2);

        System.out.println("Map contains: " + intStringMap);
    }

    void streamOptionals() {
        List<Optional<String>> optionalList =
            List.of(Optional.of("Java"), Optional.of("9"), Optional.of("is"), Optional.of("cool"));

        String optionalsAsString = optionalList.stream().flatMap(Optional::stream).collect(Collectors.joining(" "));

        System.out.println(optionalsAsString);
    }

    void innerClassDiamonds() {
        List<Printer<?>> printerList = new ArrayList<>();

        printerList.add(new Printer<>(1) {
            @Override
            void print() {
                System.out.println("This integer has value " + content);
            }
        });
        printerList.add(new Printer<>("test") {
            @Override
            void print() {
                System.out.println("This String has value " + content);
            }
        });
        printerList.add(new Printer<>(new Person("Stijn", 24)) {
            @Override
            void print() {
                System.out.println("This Person has string value " + content);
            }
        });
        printerList.add(new Printer<>(new Person("AP", 50)) {
            @Override
            void print() {
                System.out.println("This other Person has string value " + content);
            }
        });

        printerList.forEach(Printer::print);
    }

    void streamFeatures() {
        var intList = List.of(9, 5, 3, 6, 2, 1, 8, 4, 7);

        // Java 8
        for (Integer i : intList) {
            if (i == 6) {
                break;
            }
            System.out.println(i);
        }

        //Java 9
        intList.stream()
            .takeWhile(i -> i!=6)
            .forEach(System.out::println);


        // Java 8
        boolean passed6 = false;
        for (Integer i : intList){
            if (i == 6){
                passed6 = true;
            }
            if (passed6){
                System.out.println(i);
            }
        }

        // Java 9
        intList.stream()
            .dropWhile(i -> i != 6)
            .forEach(System.out::println);

        // Java 8
        for(int i = 0; i < 100; i++) {
            System.out.println(i);
        }

        // Java 9
        IntStream.iterate(1, i -> i < 100, i -> i + 1)
            .forEach(System.out::println);

        // Java 9
        IntStream.iterate(1, i -> i + 1)
            .limit(100)
            .forEach(System.out::println);
    }
}
