package advent.of.code.days.day3;

import java.util.HashSet;
import java.util.Set;

public class Coordonates {

    int X;
    int Y;

    Set<Number> adjacentNumbers;

    public Coordonates(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordonates that = (Coordonates) o;
        return X == that.X && Y == that.Y;
    }

    public Set<Number> getAdjacentNumbers() {
        return adjacentNumbers;
    }

    public void addAdjacentNumber(Number number) {
        if (this.adjacentNumbers == null) {
            this.adjacentNumbers = new HashSet<>();
        }
        this.adjacentNumbers.add(number);
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
