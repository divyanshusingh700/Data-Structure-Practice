package FileReaderJava;

import java.nio.file.Files;
import java.nio.file.Path;
public class StreamExample{
    public static void main(String[] args) throws Exception {
        try (var stream = Files.lines(Path.of("DesignPattern/ObserverDesignPattern/Explain.txt"))) {
            stream.forEach(System.out::println);
        }
    }
}