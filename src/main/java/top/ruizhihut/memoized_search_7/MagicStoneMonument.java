package top.ruizhihut.memoized_search_7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @description:
 * @author：ruizhi
 * @date: 2024/11/4
 * @Copyright：
 */

/*
0描述

在一个神秘的魔法世界里，有一个奇怪的魔法数字石碑，上面刻着一个正整数 。
这个数字石碑有一种神奇的属性，可以通过特定的魔法操作将数字变成1。石碑的守护者希望你能找到一种方法，以最少的操作次数将石碑上的数字变成1，从而解开古老的谜题。

你可以做如下操作：

如果 n 是偶数，则用 n/2 替换 n 。
如果 n 是奇数，则可以用 n+1 或 n-1 替换 n 。
你的任务是找到将 变为 1 所需的最小替换次数。

输入描述:
输入包含一个正整数n。1<=n<=2^32-1
输出描述:
输出一个整数，表示将 n 变为 1 所需的最小替换次数。

输入 8 输出 3
输入 7 输出 4
 */

//从小到大dp时间复杂度为O(n)超时，因为会记录许多无效数据
// 使用dfs+Map记忆化时间复杂度为O(logN)且不需要使用O(n)的数组
public class MagicStoneMonument {
    static Map<Long,Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long n = in.nextLong();
        System.out.println(dfs(n));
    }
    public static int dfs(long n){
        if(n==1)
            return 0;
        if(map.containsKey(n)){
            return map.get(n);
        }
        int num;
        if(n%2==0){
            num = 1+dfs(n/2);
        }else{
            num = 1+Math.min(dfs(n-1),dfs(n+1));
        }
        map.put(n,num);
        return num;
    }
}
