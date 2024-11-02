package top.ruizhihut.math_1;

/**
 * @description:
 * @author：ruizhi
 * @date: 2024/10/7
 * @Copyright：
 */
public class fastPow {
    static int MOD = 100000007;

    public static void main(String[] args) {
        System.out.println(pow(3, 4));
    }

    public static long pow(int x, int n) {
        long ans = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                ans = ans * x % MOD;
            }
            x = x * x % MOD;
            n >>= 1;
        }
        return ans;
    }
}
