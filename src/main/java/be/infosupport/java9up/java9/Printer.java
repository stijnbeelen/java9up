package be.infosupport.java9up.java9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

abstract class Printer<T> {
    static final Logger log = LoggerFactory.getLogger(Printer.class);

    final T content;

    Printer(T content) {
        this.content = content;
    }

    abstract void print();
}