package EndlessIteration_1;

public class MainIterator {
    public static void main(String[] args) {
        System.out.println("\n\tЗадача 1. Бесконечная итерация (шаблон Iterator)");
        int counter = 0;
        for (int r : new Randoms(90, 100)) {
            System.out.println(++counter + ". Случайное число: " + r);
            if (r == 100 || counter == 120) {
                if (r == 100) {
                    System.out.println("Выпало число " + r + ", давайте на этом закончим");
                } else System.out.println("Прошло " + counter + " итераций, давайте на этом закончим");
                break;
            }
        }
    }
}
