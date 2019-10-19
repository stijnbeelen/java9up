package be.infosupport.java9up.java9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        var java9 = new Java9Features();

        java9.httpRequest();
        java9.getProcessInfo();
        java9.killChildren();
        java9.printInterfaceAndClassName();
        java9.convertToSet("Java", "9", "is", "cool");
        java9.convertToList("Java", "9", "is", "cool");
        java9.streamOptionals();
        java9.innerClassDiamonds();
    }
}
