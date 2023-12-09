package advent.of.code.days.day2;

public enum BallColors {
    RED(12),
    GREEN(13),
    BLUE(14);

    private int max;

    BallColors(int max) {
        this.max = max;
    }

    public int getMax() {
        return this.max;
    }
}
