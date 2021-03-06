package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {

    public static void main(String[] args) throws IOException {
        var visitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("./"), visitor);
        visitor.getAllFiles().forEach((fileProperty, paths) -> {
            if (paths.size() > 1) {
                System.out.print(fileProperty + " - ");
                paths.forEach(System.out::println);
            }
        });
    }
}
