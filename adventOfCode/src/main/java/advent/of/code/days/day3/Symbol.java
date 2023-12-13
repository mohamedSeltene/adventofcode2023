package advent.of.code.days.day3;

import java.util.HashSet;
import java.util.Set;

public class Symbol {

    int X;
    int Y;

    Set<Number> adjacentNumbers;

    public Symbol(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Symbol that = (Symbol) o;
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
