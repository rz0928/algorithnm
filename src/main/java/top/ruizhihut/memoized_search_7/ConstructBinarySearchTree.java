package top.ruizhihut.memoized_search_7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：ruizhi
 * @date: 2024/11/5
 * @Copyright：
 */
/*
描述

二叉查找树，是具有下列性质的二叉树: 若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值; 它的左、右子树也分别为二叉查找树。
给定一个数n，表示值由1到n的节点构造成二叉查找树，问对应能构造的高度小于等于k的不同二叉查找树的个数，根节点的高度为1。
0< n < 36，0< k< 36.

解答要求
时间限制: C/C++ 1000ms, 其他语言: 2000ms 内存限制: C/C++ 256MB,其他语言: 512MB

输入描述

树的节点个数n，树的高度k，用空格分割。

输出描述

不同二又查找树的个数。

用例输入 1
```
3 2
```
用例输出 1
```
1
```
 */
public class ConstructBinarySearchTree {
    static long[][][] dp;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        dp = new long[k + 1][n + 1][n + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                Arrays.fill(dp[i][j],-1);
            }
        }
        System.out.println(dfs(k, 1, n));
    }

    public static long dfs(int k, int start, int end) {
        if(start>=end)
            return 1;
        if (k == 1) {
            return 0;
        }
        if (dp[k][start][end] != -1) {
            return dp[k][start][end];
        }
        long res = 0;
        for (int i = start; i <= end; i++) {
            res += dfs(k - 1, i + 1, end) * dfs(k - 1, start, i - 1);
        }
        dp[k][start][end] = res;
        return res;
    }
}
