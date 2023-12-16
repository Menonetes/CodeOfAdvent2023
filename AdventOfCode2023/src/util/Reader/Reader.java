package util.Reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reader {
    public List<String> getText(String pathName) {
        List<String> text = new ArrayList<>();
        try {
            File myFile = new File(pathName);
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
