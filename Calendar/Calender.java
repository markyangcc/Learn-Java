import java.util.Scanner;

public class Calender{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入年份");
        int year=sc.nextInt();
        System.out.println("请输入月份");
        int month=sc.nextInt();
        /*
        1、计算当月总天数
         */
        int days;
        if(month==2){
            if(year%4==0&&year%100!=0||year%400==0){
                days=29;
            }else{
                days=28;
            }
        }else if (month==4||month==6||month==9||month==11){
            days=30;
        }else{
            days=31;
        }
        /*
        2、计算当月1号距离1900年1月1号的天数
         */
        int sum=0;
        //1.1对1900年到year之间的天数累加
        for(int i=1900;i<year;i++){
            if (i%4==0&&i%100!=0||i%400==0){
                sum+=366;
            }else {
                sum+=365;
            }
        }
        //对月份天数累加
        for(int i=1;i<month;i++){
            if(i==2){
                if(year%4==0&&year%100!=0||year%400==0){
                    sum+=29;
                }else{
                    sum+=28;
                }
            }else if(i==4||i==6||i==9||i==11){
                sum+=30;
            }else{
                sum+=31;
            }
        }
        //对天数累加
        sum+=1;
        
        /*
        3.打印当月日历
         */
        System.out.println("------"+year+"年"+month+"月"+"的日历为："+"------");
        
        //计算当月1号是星期几，前面打印几个空格
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        for(int i=0;i<sum%7;i++){
            System.out.print("\t");
        }

        //如果是星期六，换行
        for(int i=1;i<=days;i++){
            if(sum%7==6){
                System.out.println(i);
            }else{
                System.out.print(i+"\t");
            }
            sum++;
        }
    }
}

