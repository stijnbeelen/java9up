package be.infosupport.java9up.java12;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

class Java12Features {

    void indent() {
        var notIndentedString = "Hello there :)";

        System.out.print("This string is positively indented: " + notIndentedString.indent(3));

        var indentedString = "   Hello :)";
        System.out.print("This string is negatively indented: " + indentedString.indent(-3));
    }

    void transform() {
        Function<String, String> stringTransformation = (String x) -> x + "Students";

        var result = "hello".transform(stringTransformation);
        var intResult = "42".transform(Integer::parseInt);

        System.out.println("transformed string: " + result);
        System.out.println("transformed int: " + intResult);
    }

    void switchUpdatePreview() {
        var fruit = "PEAR";
        int numberOfLetters;

        // Java 11
        /*switch (fruit) {
            case "PEAR":
                numberOfLetters = 4;
                break;
            case "APPLE":
            case "GRAPE":
                numberOfLetters = 5;
                break;
        }*/

        // Java 12 preview
        numberOfLetters = switch (fruit) {
            case "PEAR" -> 4;
            case "APPLE", "GRAPE" -> 5;
            default -> 0;
        };

        System.out.println("Number of letters in PEAR: " + numberOfLetters);
    }

    void numberFormatting() {
        var shortFormat = NumberFormat.getCompactNumberInstance(new Locale("nl", "BE"), NumberFormat.Style.SHORT);
        shortFormat.setMaximumFractionDigits(2);

        System.out.println("Dit nummer is kort geformatteerd: " + shortFormat.format(2019));
    }

    void teeingCollector(){
        var numbers = List.of(1,2,3,4,5,6,7,8,9);

        BiFunction<Optional<Integer>, Optional<Integer>, String> merger = (x, y) -> {
            if (y.isPresent() && x.isPresent()){
                return "Max number: " + y.get() + ". Min number: " + x.get() + ".";
            }

            return "No max of min numbers are provided";
        };

        var result = numbers.stream().collect(Collectors.teeing(
            Collectors.minBy(Integer::compareTo),
            Collectors.maxBy(Integer::compareTo),
            merger
        ));

        System.out.println("Result of teeing: " + result);
    }
}
