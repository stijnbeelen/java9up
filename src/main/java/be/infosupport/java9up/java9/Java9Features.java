package be.infosupport.java9up.java9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class which has a method for the new features of Java 9
 * Implements {@link JavaFeatures}
 */
class Java9Features implements JavaFeatures {

    /**
     * Method which sends a get request with the new HttpRequest.Builder and new HttpClient
     * Logs the response
     *
     * @throws Java9Exception when something goes wrong
     */
    void httpRequest() throws URISyntaxException, IOException, InterruptedException {
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(new URI("https://postman-echo.com/get"))
            .GET()
            .header("Accept-Language", "nl")
            .build();

//            HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandler.asString()); //java 9
        HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString()); //java 11

        System.out.println("Response from API: " + response.body());
    }

    /**
     * Method which displays the process id and command of the current process
     */
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

    /**
     * Method which kills the child processes of the current process
     */
    void killChildren() {
        Stream<ProcessHandle> children = ProcessHandle.current().children();
        children.forEach(ProcessHandle::destroy);
    }

    /**
     * Method which prints the name of the class and interface using {@link JavaFeatures#getInterfaceAndClassName()}
     */
    void printInterfaceAndClassName() {
        System.out.println(this.getInterfaceAndClassName());
    }

    /**
     * Method which converts an incoming array of strings to a set using {@link Set#of()}
     * <p>
     * For List and Set interfaces, of(...) method is overloaded to have 0 to 10 parameters and one with var args parameter.
     *
     * @param args var args strings to insert to the list
     */
    void convertToSet(String... args) {
        Set<String> immutableSet = Set.of(args); //immutable set!

        System.out.println("The converted Set contains: " + immutableSet);
    }

    /**
     * Method which converts an incoming array of strings to a set using {@link Set#of()}
     * <p>
     * For List and Set interfaces, of(...) method is overloaded to have 0 to 10 parameters and one with var args parameter.
     *
     * @param args var args strings to insert to the list
     */
    void convertToList(String... args) {
        List<String> stringList = List.of(args);

        System.out.println("The converted List contains: " + stringList);
    }

    /**
     * @param s1 first String to add to list
     * @param s2 second String to add to list
     * @param i1 integer to add to list
     * @deprecated use {@link Java9Features#convertToList(String...)}
     * Method which converts an incoming array of strings to a set using {@link Set#of()}
     * <p>
     * For List and Set interfaces, of(...) method is overloaded to have 0 to 10 parameters and one with var args parameter.
     */
    @Deprecated(forRemoval = true, since = "9")
    void convertToList(String s1, String s2, int i1) {
        List<? extends Serializable> stringList = List.of(s1, s2, i1);

        System.out.println("The converted List contains: " + stringList);
    }

    /**
     * Method which converts an incoming array of strings to a set using {@link Map#of()}
     * <p>
     * For Map interface, of(...) method is overloaded to have 0 to 10 parameters.
     * In case of more than 10 parameters for Map interface, ofEntries(...) method can be used accepting var args parameter.
     *
     * @param key1 the key for the first map entry
     * @param var1 the variable for the first map entry
     * @param key2 the key for the first map entry
     * @param var2 the variable for the first map entry
     */
    void convertToMap(int key1, String var1, int key2, String var2) {
        Map<Integer, String> intStringMap = Map.of(key1, var1, key2, var2);

        System.out.println("Map contains: " + intStringMap);
    }

    /**
     * Method which collects all values of a list of optionals, joins them and logs them as a String
     */
    void streamOptionals() {
        List<Optional<String>> optionalList =
            List.of(Optional.of("Java"), Optional.of("9"), Optional.of("is"), Optional.of("cool"));

        String optionalsAsString = optionalList.stream().flatMap(Optional::stream).collect(Collectors.joining(" "));

        System.out.println(optionalsAsString);
    }

    /**
     * Method which declares a printer for different types of content.
     * Prints all the added contents
     */
    void innerClassDiamonds() {
        List<Printer<?>> printerList = new ArrayList<>();

        printerList.add(new Printer<>(1) {
            @Override
            void print() {
                log.info("This integer has value {}", content);
            }
        });
        printerList.add(new Printer<>("test") {
            @Override
            void print() {
                log.info("This String has value {}", content);
            }
        });
        printerList.add(new Printer<>(new Person("Stijn", 24)) {
            @Override
            void print() {
                log.info("This Person has string value {}", content);
            }
        });
        printerList.add(new Printer<>(new Person("AP", 50)) {
            @Override
            void print() {
                log.info("This other Person has string value {}", content);
            }
        });

        printerList.forEach(Printer::print);
    }
}
