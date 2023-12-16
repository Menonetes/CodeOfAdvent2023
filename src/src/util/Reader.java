package util;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public List<String> getText() {
        List<String> text = new ArrayList<>();
        try {
            File myFile = new File("");
            Scanner scanner = new Scanner(myFile);
            while (scanner.hasNextLine()) {
                text.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return text;
    }
}
