## 实现功能
1、打印当前月份的日历

2、可以选择每周从周几开始

## 原理
### 1、1900年1月1日是星期一

### 2、闰年366天，平年365天
```java
((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) //说明是闰年
```

### 3、每月1号从周几开始
从1900/01/01 到本月1号（算本月1号，即+1)之间共有多少天。再将结果 mod 7 即得到的结果就是本月1号对应的周几

### 4、每月有多少天数
4, 6, ，9， 11   ——30 天

2               ——28 (平年) / 29（闰年）

其他月份          ——31 天

### 5、选择每周从周几开始
```java
 String[] weeks = new String[]{"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
        for (int i = 0; i < weeks.length; i++) {
            System.out.print(weeks[(weekStartOn - 1 + i) % 7] + "\t");
```