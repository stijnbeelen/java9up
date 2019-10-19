package be.infosupport.java9up;

import be.infosupport.java9up.java9.Java9Features;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
