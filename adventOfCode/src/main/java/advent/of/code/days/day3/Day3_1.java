package advent.of.code.days.day3;

import advent.of.code.days.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Day3_1 implements Input {
    @Override
    public Object processInput() throws IOException {
        Map<Integer, String> input = readInput();
        List<Integer> allNumbers = new ArrayList<>();
        for (Map.Entry line : input.entrySet()) {
            char[] lineInArray = String.valueOf(line.getValue()).toCharArray();
            for (int i = 0; i < lineInArray.length; i++) {
                if (isSymbol(lineInArray[i])) {
                    allNumbers.addAll(numbersAdjacentToThisSymbol(input, i, (int) line.getKey()));
                }
            }
        }
        return allNumbers.stream().mapToInt(value -> value).sum();
    }

    private boolean isSymbol(char c) {
        return !Character.isLetter(c) && !Character.isDigit(c);
    }

    private List<Integer> numbersAdjacentToThisSymbol(Map<Integer, String> input, int x, int y) {
        List<Integer> numbers = new ArrayList<>();
        extractNumber(input.get(y), x-1);
        extractNumber(input.get(y), x+1);
        extractNumber(input.get(y-1), x);
        extractNumber(input.get(y-1), x-1);
    }

    private Optional<Integer> extractNumber(String line, int position) {
        String number = "";
        boolean isDigit = Character.isDigit(line.toCharArray()[position]);
        if (isDigit) {
            if (Character.isDigit(line.toCharArray()[position - 1])) {
                while (isDigit && position > 0) {
                    number = number + line.toCharArray()[position];
                    position--;
                }
            } else if (Character.isDigit(line.toCharArray()[position + 1])) {
                while (isDigit && position < line.length()) {
                    number = number + line.toCharArray()[position];
                    position++;
                }
            }
            number = number + line.toCharArray()[position];
            return Optional.of(Integer.valueOf(number));
        }
        return Optional.empty();
    }
}
