package advent.of.code.days;

public final class Common {
    public static String buildFileName(Class clazz) {
        int underScorePosition = clazz.getSimpleName().indexOf('_');
        return clazz.getSimpleName().toLowerCase().substring(0, underScorePosition) + ".txt";
    }

    public static void displayResult(Object result) {
        String numberStr = String.valueOf(result);
        int length = numberStr.length() + 4;

        printStars(length);
        System.out.println("* " + numberStr + " *");
        printStars(length);
    }

    private static void printStars(int length) {
        for (int i = 0; i < length; i++) {
            System.out.print("*");
        }
        System.out.println();
    }
}
