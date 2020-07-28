package me.liheng;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

public class FileSearchApp {

    String path;
    String regex;
    String zipFileName;
    Pattern pattern;

    public static void main( String[] args ) {
        FileSearchApp app = new FileSearchApp();

        switch(Math.min(args.length, 3)) { //either 0, 1, 2, or 3
            case 0:
                System.out.println("USAGE: FileSearchApp path [regex] [zipfile]");
                return;
            case 3: app.setZipFileName(args[2]);
            case 2: app.setRegex(args[1]);
            case 1: app.setPath(args[0]); // Making use of switch fall through
        }

        try {
            app.walkDirectory(app.getPath());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Get to all files in the directory
    public void walkDirectory(String path) throws IOException {
        Files.walk(Paths.get(path))
                .forEach(f -> processFile(f.toFile()));
    }

    private void processFile(File file) {
        try {
            if (fileContainsRegex(file)) {
                addFileToZip(file);
            }
        } catch (IOException | UncheckedIOException e) {
            System.out.println("Error processing file: " + file + " : " + e);
        }
    }

    private boolean fileContainsRegex(File file) throws IOException {
        return Files.lines(file.toPath())
                .allMatch(line -> lineContainsRegex(line)); // short-circuit evaluation
    }

    private boolean lineContainsRegex(String line) {
        return this.getRegex() == null || this.pattern.matcher(line).find();
    }

    private void addFileToZip(File file) {
        System.out.println("Adding to zip: " + file);
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
        this.pattern = Pattern.compile(regex); // More efficient. Can keep reusing this compiled pattern.
    }

    public String getZipFileName() {
        return zipFileName;
    }

    public void setZipFileName(String zipFileName) {
        this.zipFileName = zipFileName;
    }
}
