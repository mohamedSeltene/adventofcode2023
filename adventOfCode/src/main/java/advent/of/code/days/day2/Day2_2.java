package advent.of.code.days.day2;

import advent.of.code.days.Input;

import java.io.IOException;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2_2 implements Input {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    @Override
    public Object processInput() throws IOException {
        return readInput().values().stream()
                .map(s -> processGame(s.substring(s.indexOf(':'))))
                .mapToInt(value -> value)
                .sum();
    }

    private int processGame(String game) {
        String[] subSets = game.split(";");

        EnumMap<BallColors, Integer> coloursCount = new EnumMap<>(BallColors.class);

        for (String subSet : subSets) {
            for (String grab : subSet.split(",")) {
                BallColors color = extractColor(grab);
                int number = extractNumber(grab);
                coloursCount.merge(color, number, Integer::max);
            }
        }
        return coloursCount.values().stream()
                .reduce((val1, val2) -> val1 * val2).get();
    }

    private int extractNumber(String str) {
        Matcher matcher = NUMBER_PATTERN.matcher(str);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return -1;
    }

    private BallColors extractColor(String str) {
        return Arrays.stream(BallColors.values())
                .filter(ballColors -> str.contains(ballColors.name().toLowerCase()))
                .findAny().get();
    }
}
