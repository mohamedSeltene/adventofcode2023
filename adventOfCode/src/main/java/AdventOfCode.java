import advent.of.code.days.Common;
import advent.of.code.days.Input;
import advent.of.code.days.day1.Day1_1;
import advent.of.code.days.day1.Day1_2;
import advent.of.code.days.day2.Day2_1;
import advent.of.code.days.day2.Day2_2;
import advent.of.code.days.day3.Day3_1;
import advent.of.code.days.day3.Day3_2;

import java.io.IOException;

public class AdventOfCode {
    public static void main(String[] args) throws IOException {
        System.out.println("Current working directory: " + System.getProperty("user.dir"));

        Input day1_1 = new Day1_1();
        Common.displayResult(day1_1.processInput());
        Input day1_2 = new Day1_2();
        Common.displayResult(day1_2.processInput());
        Input day2_1 = new Day2_1();
        Common.displayResult(day2_1.processInput());
        Input day2_2 = new Day2_2();
        Common.displayResult(day2_2.processInput());
        Input day3_1 = new Day3_1();
        Common.displayResult(day3_1.processInput());
        Input day3_2 = new Day3_2();
        Common.displayResult(day3_2.processInput());
    }
}

