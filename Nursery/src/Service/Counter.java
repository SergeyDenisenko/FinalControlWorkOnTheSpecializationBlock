package Service;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Counter {
    private Integer counter;
    private String storageName = "counter";

    public Counter() {
        load();
    }

    public void load() {
        File file = new File(storageName);
        if (file.exists()) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                counter = Integer.parseInt(reader.readLine());
            } catch (Exception e) {
                counter = 0;
                e.printStackTrace();
            }
        } else {
            counter = 0;
        }
    }

    public int add() throws IOException {
        try (FileWriter fw = new FileWriter(storageName)) {
            fw.append(String.valueOf(++counter));
        }
        return counter;
    }

    public int lastId() {
        return counter;
    }
}
