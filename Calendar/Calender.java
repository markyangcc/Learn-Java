import java.util.Scanner;

public class Calendar {
    public static void main(String[] args) {
        int allYearDays = 0;
        int allMonthDays = 0;

        Scanner in = new Scanner(System.in);

        System.out.print("输入年份： ");
        int nowYear = in.nextInt();

        System.out.print("输入月份： ");
        int nowMonth = in.nextInt();

        System.out.print("输入每周从周几开始： ");
        int weekStartOn = in.nextInt();
        // int nowYear = 2020;
        // int nowMonth = 12;
        // int weekStartOn = 5;

        // 计算当前年之前的年份的天数
        for (int i = 1900; i < nowYear; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                allYearDays += 366;
            } else {
                allYearDays += 365;
            }
        }

        // 计算当前年当前月之前的月份的天数
        boolean isLeapYear = (nowYear % 4 == 0 && nowYear % 100 != 0) || (nowYear % 400 == 0);
        for (int i = 1; i < nowMonth; i++) {
            // 4,6,9,11月 30天
            if (i == 4 || i == 6 || i == 9 || i == 11) {
                allMonthDays += 30;
            } else if (i == 2) {
                // 2月闰年29天，平年28天
                if (isLeapYear) {
                    allMonthDays += 29;
                } else {
                    allMonthDays += 28;
                }
            } else {
                // 其他月份31天
                allMonthDays += 31;
            }
        }

        // 计算当前月天数
        int thisMonthDays;
        if (nowMonth == 4 || nowMonth == 6 || nowMonth == 9 || nowMonth == 11) {
            thisMonthDays = 30;
        } else if (nowMonth == 2) {
            if (isLeapYear) {
                thisMonthDays = 29;
            } else {
                thisMonthDays = 28;
            }
        } else {
            thisMonthDays = 31;
        }

        // 计算当月1号对应星期几
        int dayOneOfWeek = ((allYearDays + allMonthDays) % 7) + 1;
        int spaceBeforeDayOne = ((7 - weekStartOn) + dayOneOfWeek) % 7;

        System.out.println(nowYear + " 年 " + nowMonth + " 月 日历");

        // 打印日历抬头周几
        String[] weeks = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (int i = 0; i < weeks.length; i++) {
            System.out.print(weeks[(weekStartOn - 1 + i) % 7] + "\t");
        }
        System.out.println();

        // 打印每月前的空格(Weeks starts on Monday)
        for (int i = 0; i < spaceBeforeDayOne; i++) {
            System.out.print("\t");
        }

        // 打印日历
        for (int i = 1; i <= thisMonthDays; i++) {
            System.out.print(i + "\t");

            if ((i + spaceBeforeDayOne) % 7 == 0)
                System.out.println();
        }
    }
}
