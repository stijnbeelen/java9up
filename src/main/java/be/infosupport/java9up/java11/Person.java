package be.infosupport.java9up.java11;

class Person {
    private static final int ADULT_AGE = 18;

    private int age;

    Person(int age) {
        this.age = age;
    }

    boolean isAdult() {
        return age >= ADULT_AGE;
    }
}