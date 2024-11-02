package top.ruizhihut.math_1;

/**
 * @description:
 * @author：ruizhi
 * @date: 2024/10/7
 * @Copyright：
 */
public class calCnm {
    public static void main(String[] args) {
        System.out.println(calCnm1(7, 3));
        System.out.println(calCnm2(7, 3));
    }

    public static long calCnm1(int n, int m) {
        if (n == m)
            return 1;
        if (n == 0)
            return 0;
        if (m == 0) {
            return 1;
        }
        return calCnm1(n - 1, m) + calCnm1(n - 1, m - 1);
    }

    public static long calCnm2(int n, int m) {
        if (m > n || m < 0) return 0;
        m = Math.min(m, n - m);
        long result = 1;
        for (int k = 1; k <= m; k++) {
            result = result * (n - k + 1) / k;
        }
        return result;
    }
}
