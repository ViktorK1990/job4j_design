package ru.job4j.io;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
       String name = "Petr Arsentyev";
       int age = 33;
       byte sec = 1;
       short a = 3;
       long b = 4;
       double c = 5;
       char d = 'd';
       LOG.debug("name: {}, age: {}, sec: {}, a: {}, b: {}, c: {}, d: {}", name, age, sec, a, b, c, d);
    }
}
