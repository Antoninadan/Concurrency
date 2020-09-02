package com.mainacad.util;

import com.mainacad.settings.Settings;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileUtil {

    public static void appendTo(List<String> strLines, String pathName, String fileName) throws IOException {
        Path path = Paths.get(pathName + Settings.FILE_SEP + fileName);
        Files.write(path, strLines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public static List<String> read(String pathName, String fileName) throws IOException {
        Path path = Paths.get(pathName + Settings.FILE_SEP + fileName);
        return Files.readAllLines(path, StandardCharsets.UTF_8);
    }

    public static File[] findFiles(String pathName, String mask) {
        File file = new File(pathName);
        if (!file.exists()) System.out.println(pathName + " folder not found");

        File[] listFiles = file.listFiles(new MyFileNameFilter(mask));
        return listFiles;
    }

    // Реализация интерфейса FileNameFilter
    public static class MyFileNameFilter implements FilenameFilter {
        private String mask;

        public MyFileNameFilter(String mask) {
            this.mask = mask.toLowerCase();
        }

        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().startsWith(mask);
        }
    }


}