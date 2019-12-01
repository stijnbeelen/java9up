package be.infosupport.java9up.java11;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Java11Main {
    private static final Logger log = LoggerFactory.getLogger(Java11Main.class);

    public static void main(String[] args) {
        var java11Features = new Java11Features();

        java11Features.lambdaVariables();
    }
}
