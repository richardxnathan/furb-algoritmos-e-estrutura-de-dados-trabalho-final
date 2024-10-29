package org.furb.service;

import org.furb.dataStructure.StaticList;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArchiveReader {

    static final String REGEX = "<[^>]+>";
    HtmlValidator htmlValidator = new HtmlValidator();
    File file;

    public ArchiveReader(String path) throws FileNotFoundException {
        this.file = new File(path);
        if (!file.exists()) throw new FileNotFoundException("Arquivo não encontrado.");
    }

    public void readArchiveLines() throws IOException {
        Scanner scanner = new Scanner(file, StandardCharsets.UTF_8);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            StaticList<String> formattedTags = formatTagsInLine(line);
            String[] tags = castListToArray(formattedTags);
            htmlValidator.isValidTags(tags);
        }
        scanner.close();
    }

    public StaticList<String> formatTagsInLine(String line) {
        StaticList<String> formattedTags = new StaticList<>();
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            formattedTags.insert(matcher.group());
        }
        return formattedTags;
    }

    private String[] castListToArray(StaticList<String> list) {
        String[] stringsFromObjectList = new String[list.getSize()];
        for (int i = 0; i < list.getSize(); i++) {
            stringsFromObjectList[i] = list.get(i);
        }
        return stringsFromObjectList;
    }
}
