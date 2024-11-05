package top.ruizhihut.memoized_search_7;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @description:
 * @author：ruizhi
 * @date: 2024/11/4
 * @Copyright：
 */
/*
描述

小马拿到了一个数组a，她准备构造一个数组b满足：

1. b的每一位都和a对应位置不同，即 bi != ai
2. b 的所有元素之和都和 a 相同。
3. b的数组均为正整数。请你告诉小马有多少种构造方式。由于答案过大，请对 10^9+7取模。

输入描述

第一行输入一个正整数n，代表数组的大小。第二行输入n个正整数ai，代表小美拿到的数组

1<=n<=100, 1<=ai<=300, 1<=Σai <= 500

输出描述

一个整数，代表构造方式对 10^9+7取模的值。

用例输入 1

```
3
1 1 3
```

用例输出 1

```
1
```

用例输入 2

```
3
1 1 1
```

用例输出 2

```
0
```
 */

//n最大只有100，考虑dfs遍历每一个位置的可能数，使用数组存放信息。
public class ConstructArray {
    static int MOD = 1000000007;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int []arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
            sum += arr[i];
        }
        dp = new int[n+1][sum+1];
        for (int i = 0; i < dp.length; ++i) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(dfs(sum,arr,0));
    }
    //dfs表示从start位置构造数组使数组结果等于sum有多少种情况
    public static int dfs(int sum,int[] arr,int start){
        if(start == arr.length-1){
            return sum != arr[arr.length - 1] ? 1 : 0;
        }
        if(dp[start][sum]!=-1){
            return dp[start][sum];
        }
        int count = 0;
        for (int i = 1; i <= sum - (arr.length-start)+1; i++) {
            if(arr[start]==i)
                continue;
            count=(count+dfs(sum-i,arr,start+1))%MOD;
        }
        dp[start][sum] = count;
        return count;
    }
}
