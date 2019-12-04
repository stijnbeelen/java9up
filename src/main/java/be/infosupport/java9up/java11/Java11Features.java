package be.infosupport.java9up.java11;

import be.infosupport.java9up.java9.JavaFeatures;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.jetbrains.annotations.NotNull;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Class which has a method for the new features of Java 9
 */
public class Java11Features{
    private static final Logger log = LoggerFactory.getLogger(Java11Features.class);

    void lambdaVariables(){
        var arrInteger = new Integer[]{5, 9, 3, 6, 2, 4, 8, 7, 1, null};

        //Java 10
        var amountOfItemsLargerThan5 = Arrays.stream(arrInteger)
                .filter(x -> (x != null && x > 5)).count();
        log.info("There are {} items larger than 5 in our list", amountOfItemsLargerThan5);

        //Java 11
        amountOfItemsLargerThan5 = Arrays.stream(arrInteger)
                .filter((@NotNull var a) -> (a > 5)).count();
        // .filter(@NotNull var x -> x > 5).count(); WILL NOT WORK

        log.info("There are {} items larger than 5 in our list", amountOfItemsLargerThan5);
    }

    void stringAPIAdditions(){
        var repeat = "La ".repeat(2) + "Land";

        log.info("Yesterday I was watching the movie {}", repeat);

        var strip = "\n\t  hello   \u2005".strip(); //trim difference: trim will not recognize \u2005 as it is Unicode
        log.info("{} there!", strip); //also .stripTailing() & .stripLeading()

        var emptyString = "";

        if (emptyString.isBlank()){
            log.info("The given string was blank!");
        }

        var multipleLines = "Hello\n dear students\n \n!";

        var amountOfLines = multipleLines.lines().count();
        log.info("The text contained {} lines", amountOfLines);
    }

    //Java 11 http client Updates
    void negatePredicate(){
        var people = List.of(new Person(1), new Person(20));

        // before 11
        var adults = people.stream().filter(Person::isAdult).collect(Collectors.toList());
        var children = people.stream().filter(x -> !x.isAdult()).collect(Collectors.toList()); //or create method isNotAdult

        //with 11
        children = people.stream().filter(Predicate.not(Person::isAdult)).collect(Collectors.toList()); //static import -> not()
    }
}
