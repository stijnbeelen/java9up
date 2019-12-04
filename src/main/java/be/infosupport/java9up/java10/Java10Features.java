package be.infosupport.java9up.java10;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Java10Features {

    private static boolean checkIfEven(int i) {
        return i % 2 == 0;
    }

    // TODO: wat is het verschil tussen een Set en een List?

    void copyToImmutableList(Set<String> stringSet){
        var list = List.copyOf(stringSet);

        System.out.println("list content: " + list);
    }

    void copyToImmutableSet(List<String> stringList){
        var set = Set.copyOf(stringList);

        System.out.println("Set content: {}" + set);
    }

    void toUnmodifiableList(List<Integer> integerList){
        var evenList = integerList.stream()
                .filter(Java10Features::checkIfEven)
                .collect(Collectors.toUnmodifiableList());

        evenList.add(4); //this will throw a UnsupportedOperationException!
    }

    void toUnmodifiableSet(Set<String> stringSet){
        var shortStringSet = stringSet.stream()
                .filter(i -> i.length() < 20)
                .collect(Collectors.toUnmodifiableSet());

        shortStringSet.add("short string"); //this will throw a UnsupportedOperationException!
    }

    void optionalOrElseThrow(List<Integer> integerList){
        Integer integer = integerList.stream()
                .filter(Java10Features::checkIfEven)
                .findFirst()
                .orElseThrow();
    }

}
