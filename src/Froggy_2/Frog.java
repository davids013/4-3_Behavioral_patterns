package Froggy_2;

import java.util.Arrays;

public class Frog {
    public static final int MIN_POSITION = 0;
    public static final int MAX_POSITION = 10;
    private static final String FROG_FACE = "\uD83D\uDC38";

    private int position;

    public Frog() { position = 5; }

    public boolean jump(int steps) {
        if (position + steps <= MAX_POSITION && position + steps >= MIN_POSITION) {
            position += steps;
            System.out.println("\t- Ква-ква!");
            return true;
        }   else {
            System.out.println("Выход за пределы поля запрещён");
            return false;
        }
    }

    public String getField() {
        String[] field = new String[MAX_POSITION - MIN_POSITION + 1];
        Arrays.fill(field, "_");
        field[position - MIN_POSITION] = FROG_FACE;
        return Arrays.toString(field).replace(",", "");
    }

    public int getPosition() {
        return position;
    }
}