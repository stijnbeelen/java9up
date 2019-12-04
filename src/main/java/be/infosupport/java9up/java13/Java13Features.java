package be.infosupport.java9up.java13;

import java.util.List;

class Java13Features {

    /**
     * Preview Feature
     */
    void textBlockPreview() {
        var textBlock = """

                        1
                        2""";
        var stringLiteral = "\n1\n2";

        System.out.println("text block: " + textBlock);
        System.out.println("string literal: " + stringLiteral);

        System.out.println("text block and string literal equals : " + textBlock.equals(stringLiteral));
        System.out.println("text block and string literal == : " + (textBlock == stringLiteral));

        var output = "name: %s, tel: %d".formatted("Stijn", 123456789);

        System.out.println(output);
    }

    void switchPreview(){
        var chars = List.of("a", "b", "c", "d");
        chars.forEach(c -> System.out.println(getIntValue(c)));
    }

    /**
     * Preview Feature
     */
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
