import java.util.Scanner;

public class Matrix {
    private static final int MIN_RANGE = 0;
    private static final int MAX_RANGE = 100;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Введіть кількість рядків матриці (максимум 20):");
        int rows = input.nextInt();
        System.out.print("Введіть кількість стовпців матриці (максимум 20):");
        int cols = input.nextInt();

        // Перевірка розміру матриці
        if (rows > 20 || cols > 20) {
            System.out.println("Помилка: розмір матриці не може бути більше 20x20");
            return;
        }

        int[][] matrix = new int[rows][cols];

        // Яким чином користувач хоче заповнювати матрицю
        System.out.print("Ви хочете заповнити матрицю вручну чи випадковим чином? (M/R):");
        String answer = input.next();

        if (answer.equalsIgnoreCase("M")) {
            // Заповнити матрицю вручну
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    System.out.print("Введіть елемент у позиції (" + i + "," + j + "): ");
                    matrix[i][j] = input.nextInt();
                }
            }
        } else if (answer.equalsIgnoreCase("R")) {
            // Заповнити матрицю випадковим чином
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    matrix[i][j] = (int) (Math.random() * (MAX_RANGE - MIN_RANGE + 1) + MIN_RANGE);
                }
            }
        } else {
            System.out.println("Помилка: недійсний параметр");
            return;
        }

        // Роздрукувати матрицю
        System.out.println("Матриця є:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        // Мінімальний і максимальний елемент у матриці
        int min = matrix[0][0];
        int max = matrix[0][0];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] < min) {
                    min = matrix[i][j];
                }
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                }
            }
        }

        // Середнє арифметичне
        double sum = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sum += matrix[i][j];
            }
        }
        double mean = sum / (rows * cols);

        // Результати
        System.out.println("Мінімальним елементом у матриці є: " + min);
        System.out.println("Максимальний елемент у матриці становить: " + max);
        System.out.println("Середнє арифметичне елементів матриці дорівнює: " + mean);
    }
}
