package ru.job4j.io;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.nio.file.FileVisitResult.CONTINUE;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    List<String> allFiles = new ArrayList<>();
    List<FileProperty> duplicates = new ArrayList<>();
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if(allFiles.contains(file.getFileName().toString())) {
            duplicates.add(new FileProperty(attrs.size(), file.getFileName().toString()));
        }
        allFiles.add(file.getFileName().toString());
        return CONTINUE;
    }
}
