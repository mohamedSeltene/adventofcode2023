package advent.of.code.days.day2;

import advent.of.code.days.Input;

import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day2_1 implements Input {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    @Override
    public Object processInput() throws IOException {
        return readInput().entrySet().stream()
                .map(entry -> processGame(entry.getValue().substring(entry.getValue().indexOf(':')), entry.getKey()))
                .mapToInt(value -> value)
                .sum();
    }

    private int processGame(String game, int id) {
        String[] subSets = game.split(";");
        boolean isAllPossible = true;
        for (String subSet : subSets) {
            isAllPossible &= isPossible(subSet);
        }

        if (isAllPossible) {
            return id;
        } else {
            return 0;
        }
    }

    private boolean isPossible(String subSet) {
        String[] grabs = subSet.split(",");
        for (String grab : grabs) {
            if (extractColor(grab).getMax() < extractNumber(grab)) {
                return false;
            }
        }
        return true;
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
