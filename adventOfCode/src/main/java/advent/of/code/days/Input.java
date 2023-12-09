package advent.of.code.days;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public interface Input {

    default Map<Integer, String> readInput() throws IOException {
        String fileName = Common.buildFileName(this.getClass());
        String filePath = "src/main/resources/inputs/" + fileName;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));

        Map<Integer, String> allInput = new HashMap<>();
        Integer counter = 1;
        while (true) {
            String currentLine = reader.readLine();
            if (currentLine == null) {
                break;
            }
            allInput.put(counter, currentLine);
            counter++;
        }
        reader.close();
        return allInput;
    }

    Object processInput() throws IOException;
}
