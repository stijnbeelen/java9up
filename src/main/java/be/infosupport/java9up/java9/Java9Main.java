package be.infosupport.java9up.java9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Java9Main {

    private static final Logger log = LoggerFactory.getLogger(Java9Main.class);

    public static void main(String[] args) {
        var java9 = new Java9Features();

        log.info("--- calling java9 httpRequest ---");
        java9.httpRequest();

        log.info("--- calling java9 getProcessInfo ---");
        java9.getProcessInfo();

        log.info("--- calling java9 killChildren ---");
        java9.killChildren();

        log.info("--- calling java9 printInterfaceAndClassName ---");
        java9.printInterfaceAndClassName();

        log.info("--- calling java9 convertToSet ---");
        java9.convertToSet("Java", "9", "is", "cool");

        log.info("--- calling java9 convertToList ---");
        java9.convertToList("Java", "9", "is", "cool");

//        log.info("--- calling deprecated java9 convertToList ---");
//        java9.convertToList("Java", "is cool", 9);

        log.info("--- calling java9 convertToMap ---");
        java9.convertToMap(1, "Stijn", 2, "AP");

        log.info("--- calling java9 convertToMap ---");
        java9.convertToMap(10, "Stijn2", 20, "AP2");

        log.info("--- calling java9 streamOptionals ---");
        java9.streamOptionals();

        log.info("--- calling java9 innerClassDiamonds ---");
        java9.innerClassDiamonds();
    }
}
