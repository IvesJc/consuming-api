package org.example.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtil {

    public static void saveToFile(String path, String content) throws IOException {
        Files.writeString(Paths.get(path), content);
    }

    public static void write(String path, String content) throws IOException {
        Files.writeString(Paths.get(path), content);
    }


}
