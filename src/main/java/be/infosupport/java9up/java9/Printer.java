package be.infosupport.java9up.java9;

abstract class Printer<T> {

    final T content;

    Printer(T content) {
        this.content = content;
    }

    abstract void print();
}