import advent.of.code.days.Common;
import advent.of.code.days.Input;
import advent.of.code.days.day1.Day1_1;
import advent.of.code.days.day1.Day1_2;

import java.io.IOException;

public class AdventOfCode {
    public static void main(String[] args) throws IOException {
        Input day1_1 = new Day1_1();
        Common.displayResult(day1_1.processInput());
        Input day1_2 = new Day1_2();
        Common.displayResult(day1_2.processInput());
    }
}
