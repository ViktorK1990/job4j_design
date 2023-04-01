package ru.job4j.assertj;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameLoadTest {
    @Test
    void whenParseException() {
        var nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::parse)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Names array is empty");
    }

    @Test
    void whenValidateExceptionThenContain() {
        var nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.validate("1 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: 1 2 does not contain the symbol \"=\"");
    }

    @Test
    void whenValidateExceptionThenStartWith() {
        var nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.validate("=12"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: =12 does not contain a key");
    }

    @Test
    void whenValidateExceptionThenEndWith() {
        var nameLoad = new NameLoad();
        assertThatThrownBy(() -> nameLoad.validate("12="))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("this name: 12= does not contain a value");
    }

    @Test
    void whenValidateIsTrue() {
        var nameLoad = new NameLoad();
        assertThat(nameLoad.validate("1=2")).isTrue();
    }
    @Test
    void whenGetMapIsEmptyException() {
        var nameLoad = new NameLoad();
        assertThatThrownBy(nameLoad::getMap)
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("collection contains no data");
    }
}