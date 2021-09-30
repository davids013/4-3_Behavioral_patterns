package Froggy_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static Froggy_2.FrogCommands.jumpLeftCommand;
import static Froggy_2.FrogCommands.jumpRightCommand;

public class MainFroggy {
    private static final List<FrogCommand> doneList = new ArrayList<FrogCommand>();
    private static final List<FrogCommand> undoneList = new ArrayList<FrogCommand>();

    public static void main(String[] args) {
        System.out.println("\n\tЗадача 2. Лягушка* (шаблон Command)");
        Scanner sc = new Scanner(System.in);
        Frog frog = new Frog();
        do {
            System.out.print("""
                    
                    Допустимые команды:
                        +N - прыгни на N шагов направо
                        -N - прыгни на N шагов налево
                        << - отмени последнюю команду
                        >> - повтори отменённую команду
                        !! - повтори последнюю команду
                        0 - выход
                    Текущее поле: %s
                    Введите команду:
                    >>\040""".formatted(frog.getField()));
        } while (readCommand(sc.nextLine(), frog));
        sc.close();
    }

    public static boolean doIt(FrogCommand command) {
        if (command.doCommand()) {
            doneList.add(command);
            return true;
        }   else return false;
    }

    public static boolean undoLast() {
        if (doneList.size() == 0) {
            System.out.println("Нечего отменять");
            return false;
        }
        if (doneList.get(doneList.size() - 1).undoCommand()) {
            undoneList.clear();
            undoneList.add(doneList.get(doneList.size() - 1));
            doneList.remove(doneList.size() - 1);
            return true;
        }   else return false;
    }

    public static boolean repeatLast() {
        if (doneList.size() == 0) {
            System.out.println("Нечего повторять");
            return false;
        }
        if (doneList.get(doneList.size() - 1).doCommand()) {
            doneList.add(doneList.get(doneList.size() - 1));
            return true;
        }   else return false;
    }

    public static boolean redoLast() {
        if (undoneList.size() == 0) {
            System.out.println("Нет отменённой операции");
            return false;
        }
        if (undoneList.get(undoneList.size() - 1).doCommand()) {
            doneList.add(undoneList.get(undoneList.size() - 1));
            undoneList.clear();
            return true;
        }   else return false;
    }

    public static boolean readCommand (String input, Frog frog) {
        if (input == null || input.isBlank() || input.length() > 2) {
            System.out.println("Введена некорректная команда");
            return true;
        }
        input = input.trim();
        switch (input) {
            case "<<" -> undoLast();
            case ">>" -> redoLast();
            case "!!" -> repeatLast();
            case "0" -> {
                return false;
            }
            default -> {
                if (input.charAt(0) == '+' || input.charAt(0) == '-') {
                    try {
                        if (input.charAt(0) == '+') {
                            doIt(jumpRightCommand(frog, Integer.parseInt(input.substring(1))));
                        }   else doIt(jumpLeftCommand(frog, Integer.parseInt(input.substring(1))));
                    } catch (Exception e) {
                        System.out.println("Введена некорректная команда");
                    }
                } else System.out.println("Введена некорректная команда");
            }
        }
        return true;
    }
}
