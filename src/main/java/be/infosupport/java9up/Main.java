package be.infosupport.java9up;

import be.infosupport.java9up.java9.Java9Features;
import be.infosupport.java9up.java9.WrapperException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;
import java.util.Set;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Java9Features.class);

    public static void main(String[] args) {
        /*System.out.println("""
                           Hello my dear people
                           This is how it works
                           "
                           \\
                           """);

        var chars = List.of("a", "b", "c", "d");
        chars.forEach(c -> System.out.println(getIntValue(c)));


        System.out.println("""
                           {
                               greeting: "hello",
                               audience: "text blocks",
                               punctuation: "!"
                           }""");

        System.out.println("""
                           {
                               greeting: "hello",
                               audience: "text blocks",
                               punctuation: "!"
                           }""");

        System.out.println("""
        Hallo!""");*/

        var java9 = new Java9Features();

        try {
            log.info("Sending http request with new HttpClient");
            var response = java9.httpRequest();
            log.info("Response from API: {}", response);
        } catch (WrapperException e) {
            log.error("Exception while sending http request", e);
        }

        log.info("Retrieving process info");
        var processInfo = java9.getProcessInfo();
        log.info("Process with id {} had command {}", processInfo.getProcessId(), processInfo.getCommand());

        log.info("Killing child processes");
        java9.killChildren();

        log.info(java9.getInterfaceAndClassName());

        var stringSet1 = java9.convertToSet("Java", "9", "is", "cool");
        log.info(stringSet1.toString());
        var stringSet2 = java9.convertToSet("Java 9", "is cool");
        log.info(stringSet2.toString());
        var stringList = java9.convertToList("Java", "9", "is", "cool");
        log.info(stringList.toString());

        var stringFromOptionals = java9.streamOptionals();
        log.info(stringFromOptionals);


    }

    private static int getIntValue(String mode) {
        return switch (mode) {
            case "a", "b":
                yield 1;
            case "c", "d":
            default:
                yield 2;
        };
    }
}
