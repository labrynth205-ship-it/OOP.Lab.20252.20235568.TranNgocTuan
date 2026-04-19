package hust.soict.dsai.lab01;
import java.util.Scanner;

public class bai66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("số hàng của ma trận: ");
        int rows = scanner.nextInt();
        System.out.print("số cột của ma trận: ");
        int cols = scanner.nextInt();
        int[][] matrix1 = new int[rows][cols];
        int[][] matrix2 = new int[rows][cols];
        int[][] sumMatrix = new int[rows][cols];
        System.out.println("\nNhập các phần tử của Ma trận 1:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                matrix1[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nNhập các phần tử của Ma trận 2:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print("Phần tử [" + i + "][" + j + "]: ");
                matrix2[i][j] = scanner.nextInt();
            }
        }
        System.out.println("\nMa Trận Tổng");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
                System.out.print(sumMatrix[i][j] + "\t");
            }
            System.out.println();
        }
        scanner.close();
    }
}