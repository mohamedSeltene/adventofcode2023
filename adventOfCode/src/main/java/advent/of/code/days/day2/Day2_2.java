package advent.of.code.days.day2;

import advent.of.code.days.Input;

import java.io.IOException;
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
        int minRed = 0;
        int minBlue = 0;
        int minGreen = 0;

        for (String subSet : subSets) {
            if (getMinRed(subSet) > minRed) {
                minRed = getMinRed(subSet);
            }
            if (getMinBlue(subSet) > minBlue) {
                minBlue = getMinBlue(subSet);
            }
            if (getMinGreen(subSet) > minGreen) {
                minGreen = getMinGreen(subSet);
            }
        }
        return minRed * minGreen * minBlue;
    }

    private int getMinGreen(String subSet) {
        String[] grabs = subSet.split(",");
        for (String grab : grabs) {
            if (extractColor(grab).equals(BallColors.GREEN)) {
                return extractNumber(grab);
            }
        }
        return 0;
    }

    private int getMinBlue(String subSet) {
        String[] grabs = subSet.split(",");
        for (String grab : grabs) {
            if (extractColor(grab).equals(BallColors.BLUE)) {
                return extractNumber(grab);
            }
        }
        return 0;
    }

    private int getMinRed(String subSet) {
        String[] grabs = subSet.split(",");
        for (String grab : grabs) {
            if (extractColor(grab).equals(BallColors.RED)) {
                return extractNumber(grab);
            }
        }
        return 0;
    }

    private int extractNumber(String str) {
        Matcher matcher = NUMBER_PATTERN.matcher(str);

        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        return -1;
    }

    private BallColors extractColor(String str) {
        if (str.contains(BallColors.BLUE.name().toLowerCase())) {
            return BallColors.BLUE;
        } else if (str.contains(BallColors.RED.name().toLowerCase())) {
            return BallColors.RED;
        } else {
            return BallColors.GREEN;
        }
    }

}
