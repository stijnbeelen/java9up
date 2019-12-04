package be.infosupport.java9up.java10;

import java.util.List;
import java.util.Set;

public class Java10Main {
    public static void main(String[] args) {
        var java10Features = new Java10Features();

        java10Features.copyToImmutableList(Set.of("a", "b"));

        java10Features.copyToImmutableSet(List.of("a", "b"));

        java10Features.toUnmodifiableList(List.of(1,2,3,4));

        java10Features.toUnmodifiableSet(Set.of("1","2","3"));

        java10Features.optionalOrElseThrow(List.of(1,2,3,4));

        java10Features.optionalOrElseThrow(List.of(1));

    }
}
