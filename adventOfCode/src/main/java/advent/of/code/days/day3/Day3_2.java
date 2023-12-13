package advent.of.code.days.day3;

import advent.of.code.days.Input;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Day3_2 implements Input {
    @Override
    public Object processInput() throws IOException {
        Map<Integer, String> input = readInput();
        List<Number> allNumbers = identifyNumbers(input);
        List<Coordinate> allSymbols = identifySymbols(input);
        for (Number number : allNumbers) {
            for (int i = number.getX(); i < number.getX() + number.getLength(); i++) {
                for (Coordinate symbol : allSymbols) {
                    if (i >= symbol.getX() - 1
                            && i <= symbol.getX() + 1
                            && number.getY() >= symbol.getY() - 1
                            && number.getY() <= symbol.getY() + 1) {
                        symbol.addAdjacentNumber(number);
                        break;
                    }
                }
            }
        }
        return allSymbols.stream().filter(coordinate -> coordinate.getAdjacentNumbers().size()== 2)
                .mapToInt(coordinate -> coordinate.getAdjacentNumbers().stream()
                        .map(Number::getValue)
                        .reduce((integer, integer2) -> integer * integer2)
                        .get())
                .sum();
    }

    private List<Number> identifyNumbers(Map<Integer, String> input) {
        List<Number> numbers = new ArrayList<>();
        for (Map.Entry<Integer, String> line : input.entrySet()) {
            char[] currentLine = line.getValue().toCharArray();
            for (int i = 0; i < currentLine.length; i++) {
                if (Character.isDigit(currentLine[i])) {
                    Number number = new Number();
                    number.setX(i);
                    number.setY(line.getKey());
                    while (i < currentLine.length && Character.isDigit(currentLine[i])) {
                        number.setValue(currentLine[i]);
                        i++;
                    }
                    numbers.add(number);
                }
            }
        }
        return numbers;
    }

    private List<Coordinate> identifySymbols(Map<Integer, String> input) {
        List<Coordinate> coordinateList = new ArrayList<>();
        for (Map.Entry<Integer, String> line : input.entrySet()) {
            char[] currentLine = line.getValue().toCharArray();
            for (int i = 0; i < currentLine.length; i++) {
                if (isSymbol(currentLine[i])) {
                    coordinateList.add(new Coordinate(i, line.getKey()));
                }
            }
        }
        return coordinateList;
    }

    private boolean isSymbol(char c) {
        return !Character.isLetter(c) && !Character.isDigit(c) &&  c != '.';
    }
}
