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

某公司有n名员工，第i名员工具有的能力可以用一个正整数ai描述，称为员工的能力值，现在，公司有一个项目需要交给恰好[n/2]名员工负责。为了保证项目能顺利进行，要求负责该项目的所有员工能力值之和大于等于x。
公司希望你可以帮忙求出，有多少种不同的派遣员工来负责这个项目的方案。
上文中，[x]风表示大于等于x的最小整数，例[4] =4，[4.2]=5。认为两个方案不同，当且仅当存在一名员工在一种方案中负责该项目，而在另一种方案中不负责.

输入描述

输入包含多组数据，输入第一行包含一个整数T (1<=T<=10) ，表示数据组数.
接下来2T行，每两行描述了一组数据.
每组数据第一行包含两个正整数n(1<=n<=16) 和x (1<=x<=210^4)，分别表示公司的员工总数和项目对负责员工能力值之和的要求。
每组数据第二行包含n个整数，第i个整数表示第i名员工的能力值ai(1<=ai<=10^3)。
对于100%的数据，满足1<=n<=16，1<=x<=2104，1<=T<=10，1<=ai<=103。

输出描述

输出包含T行。对于每组数据输出一行一个整数，表示可行的派遣方案数.

用例输入 1
```
3
5 10
3 2 3 4 5
3 3
1 1 1
10 10
3 1 2 8 5 4 2 9 12 7
```
用例输出 1
```
7
0
252
```
 */
public class ProjectDispatch {
    static int[][][] dp;
    //最大能力值和
    static int MAXSUM = 16001;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while(T-->0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int []arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
            }
            int num = n%2==0?n/2:(n/2+1);
            dp = new int[n+1][num+1][MAXSUM];
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    Arrays.fill(dp[i][j],-1);
                }
            }
            System.out.println(dfs(num,x,0,arr,0));
        }
    }
    public static int dfs(int num,int x,int depth,int[] arr,int sum){
        if(num == 0){
            return sum>=x?1:0;
        }
        if(num<0||depth>=arr.length){
            return 0;
        }

        if(dp[depth][num][sum]!=-1)
            return dp[depth][num][sum];
        int count = dfs(num-1,x,depth+1,arr,sum+arr[depth])+dfs(num,x,depth+1,arr,sum);
        dp[depth][num][sum] = count;
        return count;
    }
}
