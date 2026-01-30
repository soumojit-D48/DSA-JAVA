// package DSA-JAVA.Dp.memo;

import java.util.Arrays;

public class fibonacciMemo {
    static int[] dp;

    public static int fibo(int n) {
        if(n <= 1) return n;

        if(dp[n] != -1) return dp[n];

        dp[n] = fibo(n - 2) + fibo(n - 1);

        return dp[n];
    }
    public static void main(String[] args) {
        int n = 5;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);

        System.out.println(fibo(n));
    }
}
