package be.infosupport.java9up.java9;

class Person {
    private final String name;
    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("Person %s is %d years old", this.name, this.age);
    }
}
