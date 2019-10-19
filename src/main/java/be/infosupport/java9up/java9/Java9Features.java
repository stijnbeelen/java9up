package be.infosupport.java9up.java9;

import be.infosupport.java9up.JavaFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class Java9Features implements JavaFeatures {
    private static final Logger log = LoggerFactory.getLogger(Java9Features.class);

    void httpRequest() throws Java9Exception {
        try {
            var httpRequest = HttpRequest.newBuilder()
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

    void getProcessInfo() {
        var processInfoBuilder = new ProcessInfo.Builder();

        var processHandle = ProcessHandle.current();
        var processHandleInfo = processHandle.info();
        var command = processHandleInfo.command().isPresent() ? processHandleInfo.command().get() : null;

        var processInfo = processInfoBuilder
                .processId(processHandle.pid())
                .command(command)
                .build();

        log.info("Process with id {} had command {}", processInfo.getProcessId(), processInfo.getCommand());
    }

    void killChildren() {
        var children = ProcessHandle.current().children();
        children.forEach(ProcessHandle::destroy);
    }

    void printInterfaceAndClassName() {
        log.info(this.getInterfaceAndClassName());
    }

    void convertToSet(String... args) {
        var immutableSet = Set.of(args); //immutable set!

        log.info(immutableSet.toString());
    }

    void convertToList(String... args) {
        var stringList = List.of(args);

        log.info(stringList.toString());
    }

    void streamOptionals() {
        List<Optional<String>> optionalList =
                List.of(Optional.of("Java"), Optional.of("9"), Optional.of("is"), Optional.of("cool"));

        var optionalsAsString = optionalList.stream().flatMap(Optional::stream).collect(Collectors.joining(" "));

        log.info(optionalsAsString);
    }

    void innerClassDiamonds() {
        List<Printer<?>> printerList = new ArrayList<>();

        printerList.add(new Printer<>(1));
        printerList.add(new Printer<>(2));
        printerList.add(new Printer<>("test"));
        printerList.add(new Printer<>(new Person("Stijn", 24)));

        printerList.forEach(Printer::print);
    }
}
