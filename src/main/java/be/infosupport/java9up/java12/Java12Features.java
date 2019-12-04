package be.infosupport.java9up.java12;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Java12Features {
    private static final Logger log = LoggerFactory.getLogger(Java12Features.class);

    void indent(){
        var notIndentedString = "Hello there :)";

        log.info("This string is positively indented: {}", notIndentedString.indent(3));

        var indentedString = "   Hello :)";
        log.info("This string is negatively indented: {}", indentedString.indent(-3));
    }

    void transform(){
         Function<String, String> stringTransformation = (String x) -> x + "Students";

         var result = "hello".transform(stringTransformation);
         var intResult = "42".transform(Integer::parseInt);

    }
}
