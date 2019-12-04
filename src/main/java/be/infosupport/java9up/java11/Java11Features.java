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

    void lambdaVariables(){
        var arrInteger = new Integer[]{5, 9, 3, 6, 2, 4, 8, 7, 1, null};

        //Java 10
        var amountOfItemsLargerThan5 = Arrays.stream(arrInteger)
                .filter(x -> (x != null && x > 5)).count();
        System.out.println("There are " + amountOfItemsLargerThan5 + " items larger than 5 in our list");

        //Java 11
        amountOfItemsLargerThan5 = Arrays.stream(arrInteger)
                .filter((@NotNull var a) -> (a > 5)).count();
        // .filter(@NotNull var x -> x > 5).count(); WILL NOT WORK

        System.out.println("There are " + amountOfItemsLargerThan5 + " items larger than 5 in our list");
    }

    void stringAPIAdditions(){
        var repeat = "La ".repeat(2) + "Land";

        System.out.println("Yesterday I was watching the movie " + repeat);

        var strip = "\n\t  hello   \u2005".strip(); //trim difference: trim will not recognize \u2005 as it is Unicode
        System.out.println(strip + "there!"); //also .stripTailing() & .stripLeading()

        var emptyString = "";

        if (emptyString.isBlank()){
            System.out.println("The given string was blank!");
        }

        var multipleLines = "Hello\n dear students\n \n!";

        var amountOfLines = multipleLines.lines().count();
        System.out.println("The text contained " + amountOfLines + " lines");
    }

    //Java 11 http client Updates
    void negatePredicate(){
        var people = List.of(new Person(1), new Person(20), new Person(50));

        // before 11
        var adults = people.stream().filter(Person::isAdult).collect(Collectors.toList());
        var children = people.stream().filter(x -> !x.isAdult()).collect(Collectors.toList()); //or create method isNotAdult

        //with 11
        children = people.stream().filter(Predicate.not(Person::isAdult)).collect(Collectors.toList()); //static import -> not()

        System.out.println("There are " + adults.size() + "adults and " + children.size() + "children.");
    }
}
