package be.infosupport.java9up.java9;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class Printer<T> {
    private static final Logger log = LoggerFactory.getLogger(Printer.class);

    private final T content;

    Printer(T content) {
        this.content = content;
    }

    void print(){
        log.info("{}", content);
    }
}