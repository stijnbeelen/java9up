package be.infosupport.java9up.java9;

import java.io.IOException;
import java.net.URISyntaxException;

class Java9Main {

    public static void main(String[] args) throws InterruptedException, IOException, URISyntaxException {
        Java9Features java9 = new Java9Features();

        java9.httpRequest();

        java9.getProcessInfo();

        java9.killChildren();

        java9.printInterfaceAndClassName();

        java9.convertToSet("Java", "9", "is", "cool");

        java9.convertToList("Java", "9", "is", "cool");

//        java9.convertToList("Java", "is cool", 9);

        java9.convertToMap(1, "Stijn", 2, "AP");

        java9.streamOptionals();

        java9.innerClassDiamonds();

        java9.streamFeatures();
    }
}
