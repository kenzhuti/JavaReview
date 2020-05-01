package algorithm;

public class Exchange {
    public static void exchange1() {
        int x = 10;
        int y = 20;

        int temp = x;
        x = y;
        y = temp;
        System.out.println("x:" + x +",y:" + y);
    }

    // 位移运算交换：一个数对另一个数位异或两次，该数不变
    public static void exchange2() {
        int x = 10;
        int y = 20;
        x = x ^ y; // 此时x的值为x ^ y;
        y = x ^ y; // 此时的x经上面的运算变成x ^ y，所以y =  x ^ y ^ y = x;
        x = x ^ y; // 此时的y经上面的运算变成 x，所以x =  x ^ y ^ x = y; 实现两个数的互换
    }

    public static void exchange3() {
        int x = 10;
        int y = 20;
        x = x + y;
        y = x - y;
        x = x - y;
    }
}
