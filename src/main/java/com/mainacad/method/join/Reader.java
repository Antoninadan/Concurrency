package com.mainacad.method.join;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Reader {
    private String pathName;
    private String fileName;
    private String input;

    public Reader(String pathName, String fileName, String input) {
        this.pathName = pathName;
        this.fileName = fileName;
        this.input = input;
    }

    public int countWords() {
        try {
            return Files.lines(Paths.get(".\\" + pathName + "\\" + fileName))
                    .map(x -> (x.length() - x.replaceAll(input, "").length()) / input.length())
                    .mapToInt(x -> x)
                    .sum();
        } catch (IOException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
