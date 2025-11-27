package DesignPattern.AdapterDesignPattern;

import java.io.*;
import java.nio.charset.StandardCharsets;

// What it adapts: converts a byte-oriented InputStream (raw bytes) to a character-oriented Reader.
// Why it’s an Adapter: client code expects character Reader methods (read(), read(char[])), 
// while the underlying source provides bytes. InputStreamReader sits between and translates bytes → chars using a Charset (encoding).

// Key behavior / gotchas

    // Encoding matters (default charset used if not supplied). Always pass explicit charset when reading text (e.g., StandardCharsets.UTF_8).

    // It composes (wraps) an InputStream — an object adapter.
public class InputStreamReaderAdapter {
    public static void main(String[] args) {
        try (InputStream is = new FileInputStream("example.txt");
             Reader reader = new InputStreamReader(is, StandardCharsets.UTF_8);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// BufferedReader reads characters via the Reader interface; 
// InputStreamReader adapts the byte stream into that character interface.
