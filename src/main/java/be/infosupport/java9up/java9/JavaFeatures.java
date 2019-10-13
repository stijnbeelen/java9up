package be.infosupport.java9up.java9;

import java.util.Arrays;

public interface JavaFeatures {
    void doSomething();

    default String getInterfaceAndClassName(){
        return String.format("Class %s is implementation of interface %s", getClassName(), getInterfaceName());
    }

    private String getClassName(){
        return this.getClass().getSimpleName();
    }

    private String getInterfaceName(){
        return this.getClass().getInterfaces()[0].getSimpleName();
    }
}
