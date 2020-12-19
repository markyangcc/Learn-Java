import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("输入上次考试成绩: ");
        double lgrade = scanner.nextDouble();
        System.out.print("输入这次考试成绩: ");
        double ngrade = scanner.nextDouble();

        System.out.printf("上次成绩 %.1f\n这次成绩 %.1f\n提高百分率 %.2f%%\n", lgrade, ngrade, (ngrade - lgrade) / lgrade * 100); // 格式化输出

    }
}