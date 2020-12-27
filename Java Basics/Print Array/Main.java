public class Main {
    public static void main(String[] args) {
        int[] ns = { 1, 4, 9, 16, 25 };
        // 倒序打印数组元素:
        for (int i = ns.length; i > 0; i--) {
            System.out.println(ns[i - 1]);
        }
    }
}
