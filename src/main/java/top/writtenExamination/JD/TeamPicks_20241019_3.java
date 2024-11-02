package top.writtenExamination.JD;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @description: BFS+二分，二分答案判断是否能满足
 * @author：ruizhi
 * @date: 2024/10/27
 * @Copyright：
 */
/*
描述

小牛的集训队共有n个人，每个人都有m个属性，现在需要挑选其中的k个人组成战队出战。
战队也有m个属性，这些属性的计算方式是，挑选出的k个人里该属性的最大值。
由于“木桶理论”（一只木桶能装多少水取决于它最短的那块木板），战队的战斗力，取决于这个战队的m个属性里的那个最小值。
问如何挑选队员，可以使得战队的战斗力最强，请输出战队的最高战斗力。

输入描述

第一行一个整数T，代表样例个数（T<=5）

每个样例的第一行三个整数n,m,k。
接下来n行，每行m个整数，a[i][j]代表第i个队员的第j个属性值。

1<=k<=n<=3e5, m<10
1<=a[i][j]<=1000

输出描述

输出战队的最高战斗力

用例输入
1
5 2 2
1 6
2 6
3 7
4 3
5 2

用例输出
5
 */
public class TeamPicks_20241019_3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int[][] pro = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    pro[i][j] = in.nextInt();
                }
            }
            int left = 1;
            int right = 1000;
            while(left<=right){
                int mid = left + ((right - left)>>1);
                if(check(pro,n,m,k,mid)){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
            System.out.println(right);
        }
    }

    public static boolean check(int[][] pro, int n, int m, int k, int target) {
        final int MAX = (1 << m) - 1;
        int[] ability = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pro[i][j] >= target) {
                    ability[i] |= (1 << j);
                }
            }
        }
        boolean[] isUsed = new boolean[MAX+1];
        int peopleNum = 1;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while (!queue.isEmpty() && peopleNum <= k) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int value = queue.poll();
                for (int abi : ability) {
                    int newValue = abi | value;
                    if (isUsed[newValue]) {
                        continue;
                    }
                    if (newValue == MAX) {
                        return true;
                    }
                    isUsed[newValue] = true;
                    queue.add(newValue);
                }
            }
            peopleNum++;
        }
        return false;
    }
}
