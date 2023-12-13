package advent.of.code.days.day3;

public class Number {

    int value;
    int X;
    int Y;

    boolean alreadyCalculated = false;

    public int getValue() {
        return value;
    }

    public void setValue(char v) {
        this.value = Integer.parseInt(value+ String.valueOf(v));
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

    public boolean isAlreadyCalculated() {
        return alreadyCalculated;
    }

    public void setAlreadyCalculated(boolean alreadyCalculated) {
        this.alreadyCalculated = alreadyCalculated;
    }

    public int getLength(){
        return String.valueOf(value).length();
    }
    public int getLastX(){
        return X+this.getLength();
    }
}
