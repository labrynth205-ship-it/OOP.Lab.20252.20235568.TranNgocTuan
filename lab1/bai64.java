import java.util.Scanner;

public class bai64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int year = -1;
        int monthIndex = -1;
        String[][] validMonths = {
            {"January", "Jan.", "Jan", "1"},
            {"February", "Feb.", "Feb", "2"},
            {"March", "Mar.", "Mar", "3"},
            {"April", "Apr.", "Apr", "4"},
            {"May", "5"}, 
            {"June", "Jun", "6"},
            {"July", "Jul", "7"},
            {"August", "Aug.", "Aug", "8"},
            {"September", "Sept.", "Sep", "9"},
            {"October", "Oct.", "Oct", "10"},
            {"November", "Nov.", "Nov", "11"},
            {"December", "Dec.", "Dec", "12"}
        };
        while (true) {
            System.out.print("Nhập tháng (Tên đầy đủ, viết tắt, 3 chữ cái hoặc số): ");
            String monthInput = scanner.nextLine().trim();
            System.out.print("Nhập năm (Số nguyên dương, đầy đủ các chữ số): ");
            String yearInput = scanner.nextLine().trim();
            try {
                year = Integer.parseInt(yearInput);
                if (year < 0) {
                    System.out.println("Năm không hợp lệ! Phải là số nguyên dương. Vui lòng nhập lại.\n");
                    continue;
                }
            } catch (NumberFormatException e) {
                System.out.println("Năm không hợp lệ! Phải bao gồm toàn bộ là chữ số. Vui lòng nhập lại.\n");
                continue;
            }
            monthIndex = -1;
            for (int i = 0; i < validMonths.length; i++) {
                for (String validFormat : validMonths[i]) {
                    if (monthInput.equals(validFormat)) {
                        monthIndex = i + 1;
                        break;
                    }
                }
                if (monthIndex != -1) break; 
            }
            if (monthIndex == -1) {
                System.out.println("Tháng không hợp lệ! Vui lòng kiểm tra lại chính tả và nhập lại.\n");
                continue;
            }
            break;
        }
        int days = 0;
        if (monthIndex == 2) {
            boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
            days = isLeapYear ? 29 : 28;
        } else if (monthIndex == 4 || monthIndex == 6 || monthIndex == 9 || monthIndex == 11) {
            days = 30;
        } else {
            days = 31;
        }
        System.out.println("\nTháng " + monthIndex + " năm " + year + " có " + days + " ngày.");
        scanner.close();
    }
}