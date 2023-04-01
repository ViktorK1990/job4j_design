package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class BoxTest {
    @Test
    void isThisSphere() {
        Box box = new Box(0,10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere");
    }
    @Test
    void whenGetNumberOfVertices() {
        Box box = new Box(1, 20);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(-1);
    }
    @Test
    void  whenIsExistTrue() {
        Box box = new Box(4, 20);
        boolean result = box.isExist();
        assertThat(result).isTrue();
    }
    @Test
    void whenGetArea() {
        Box box = new Box(4, 20);
        double result = box.getArea();
        assertThat(result).isEqualTo(692.82, withPrecision(0.01));
    }

}