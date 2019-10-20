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
    private static final Logger log = LoggerFactory.getLogger(Java9Features.class);

    /**
     * Method which sends a get request with the new HttpRequest.Builder and new HttpClient
     * Logs the response
     *
     * @throws Java9Exception when something goes wrong
     */
    void httpRequest() throws Java9Exception {
        try {
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(new URI("https://postman-echo.com/get"))
                    .GET()
                    .header("Accept-Language", "nl")
                    .build();

//            HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandler.asString()); //java 9
            HttpResponse<String> response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString()); //java 11

            log.info("Response from API: {}", response.body());
        } catch (StackOverflowError | InterruptedException | IOException | URISyntaxException e) {
            throw new Java9Exception("Something went wrong while sending httpRequest to postman-echo", e);
        }
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

        log.info("Process with id {} had command {}", processInfo.getProcessId(), processInfo.getCommand());
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
        log.info("{}", this.getInterfaceAndClassName());
    }

    /**
     * Method which converts an incoming array of strings to a set using {@link Set#of()}
     *
     * For List and Set interfaces, of(...) method is overloaded to have 0 to 10 parameters and one with var args parameter.
     *
     * @param args var args strings to insert to the list
     */
    void convertToSet(String... args) {
        Set<String> immutableSet = Set.of(args); //immutable set!

        log.info("The converted Set contains: {}", immutableSet);
    }

    /**
     * Method which converts an incoming array of strings to a set using {@link Set#of()}
     *
     * For List and Set interfaces, of(...) method is overloaded to have 0 to 10 parameters and one with var args parameter.
     *
     * @param args var args strings to insert to the list
     */
    void convertToList(String... args) {
        List<String> stringList = List.of(args);

        log.info("The converted List contains: {}", stringList);
    }

    /**
     * @deprecated use {@link Java9Features#convertToList(String...)}
     * Method which converts an incoming array of strings to a set using {@link Set#of()}
     *
     * For List and Set interfaces, of(...) method is overloaded to have 0 to 10 parameters and one with var args parameter.
     * @param s1 first String to add to list
     * @param s2 second String to add to list
     * @param i1 integer to add to list
     */
    @Deprecated(forRemoval = true, since = "9")
    void convertToList(String s1, String s2, int i1){
        List<? extends Serializable> stringList = List.of(s1, s2, i1);

        log.info("The converted List contains: {}", stringList);
    }

    /**
     * Method which converts an incoming array of strings to a set using {@link Map#of()}
     *
     * For Map interface, of(...) method is overloaded to have 0 to 10 parameters.
     * In case of more than 10 parameters for Map interface, ofEntries(...) method can be used accepting var args parameter.
     *
     * @param key1 the key for the first map entry
     * @param var1 the variable for the first map entry
     * @param key2 the key for the first map entry
     * @param var2 the variable for the first map entry
     */
    void convertToMap(int key1, String var1, int key2, String var2){
        Map<Integer, String> intStringMap = Map.of(key1, var1, key2, var2);

        log.info("Map contains: {}", intStringMap);
    }

    /**
     * Method which collects all values of a list of optionals, joins them and logs them as a String
     */
    void streamOptionals() {
        List<Optional<String>> optionalList =
                List.of(Optional.of("Java"), Optional.of("9"), Optional.of("is"), Optional.of("cool"));

        String optionalsAsString = optionalList.stream().flatMap(Optional::stream).collect(Collectors.joining(" "));

        log.info(optionalsAsString);
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
