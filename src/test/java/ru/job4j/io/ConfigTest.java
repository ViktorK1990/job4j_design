package ru.job4j.io;

import net.bytebuddy.implementation.bytecode.Throw;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.*;

class ConfigTest {

    @Test
    void whenPairWithoutComment() throws IOException {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("Petr Arsentev");
    }
    @Test
    void whenPairWithEmptyStrings() throws IOException {
        String path = "data/emptyStrings.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name")).isEqualTo("value");
    }
    @Test
    void whenWillException() throws IOException {
        String path = "data/wrongData.properties";
        Config config = new Config(path);
        assertThatThrownBy(config::load).isInstanceOf(IllegalArgumentException.class);


    }
}