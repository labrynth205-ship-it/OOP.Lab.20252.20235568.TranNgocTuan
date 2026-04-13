import java.util.Arrays;
import java.util.Scanner;

public class bai65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("số lượng phần tử của mảng: ");
        int n = scanner.nextInt();
        double[] my_array = new double[n];
        System.out.println("các phần tử của mảng:");
        for (int i = 0; i < n; i++) {
            my_array[i] = scanner.nextDouble();
        }
        System.out.println("\nmảng ban đầu: " + Arrays.toString(my_array));
        Arrays.sort(my_array);
        System.out.println("mảng sau khi sắp xếp: " + Arrays.toString(my_array));
        double sum = 0;
        for (double num : my_array) {
            sum += num; 
        }
        double average = sum / n;
        System.out.println("Tổng" + sum);
        System.out.println("Giá trị trung bình: " + average);
        scanner.close();
    }
}