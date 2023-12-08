package advent.of.code.days.day1;

import advent.of.code.days.Input;

import java.io.IOException;

public class Day1_1 implements Input {

    @Override
    public Object processInput() throws IOException {
        return readInput().values().stream()
                .mapToInt(this::processLine)
                .sum();
    }

    private int processLine(String line) {
        int firstDigit = -1;
        int lastDigit = -1;

        for (int i = 0; i < line.length(); i++) {
            if (Character.isDigit(line.charAt(i))) {
                if (firstDigit < 0) {
                    firstDigit = Character.getNumericValue(line.charAt(i));
                } else {
                    lastDigit = Character.getNumericValue(line.charAt(i));
                }
            }
        }
        if (lastDigit < 0) {
            lastDigit = firstDigit;
        }

        String result = firstDigit + String.valueOf(lastDigit);
        return Integer.parseInt(result);
    }
}