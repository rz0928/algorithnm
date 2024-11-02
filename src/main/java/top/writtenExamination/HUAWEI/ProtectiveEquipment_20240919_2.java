package top.writtenExamination.HUAWEI;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @description: 二分+BFS，DFS需重复判断depth会超时
 * @author：ruizhi
 * @date: 2024/10/27
 * @Copyright：
 */
/*
描述

有一个NxN 大小的迷宫。初始状态下，配送员位于迷官的左上角，他希望前往迷宫的右下角。
配送员只能沿着上下左右四个方向移动，从每个格子移动到相邻格子所需要的时间是1个单位，他必须用最多 K个(也可以少于 K 个)单位时间到达右下角格子。
迷宫的每个格子都有辐射值，配送员必须穿着防护能力不低于相应辐射值的防护服，才能通过该格子。他希望知道，防护服的防护能力最少要达到多少，他才能顺利完成任务。注意:配送员需要通过迷官的左上角和右下角，因此防护服的防护能力必须大于等于这两个格子的辐射值。

输入描述

前两行各包含一个正整数，分别对应N和K，后 N 行各包含 N 整数，以空格分隔，表示地图上每个位置的辐射值。
2≤N≤100 。K≥2N-2，以保证题目有解。所有辐射值都是非负整数，绝对值不超过 10^4

输出描述

一个整数，表示配送员穿着防护服的最低防护能力。

用例输入

5
12
0 0 0 0 0
9 9 3 9 0
0 0 0 0 0
0 9 5 9 9
0 0 0 0 0

用例输出
3
 */
public class ProtectiveEquipment_20240919_2 {
    static int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[][] arr = new int[n][n];
        int right = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = in.nextInt();
                right = Math.max(arr[i][j], right);
            }
        }
        int left = Math.max(arr[0][0], arr[n - 1][n - 1]);
        int result = right;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (check(mid, arr, n, k)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(result);
    }

    public static boolean check(int limit, int[][] arr, int n, int k) {
        boolean[][] used = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        used[0][0] = true;
        int depth = 0;
        while (!queue.isEmpty() && depth < k) {
            depth++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] pos = queue.poll();
                for (int[] ints : dir) {
                    int newI = pos[0] + ints[0];
                    int newJ = pos[1] + ints[1];
                    if (newI == n - 1 && newJ == n - 1)
                        return true;
                    if (newI >= 0 && newJ >= 0 && newI < n && newJ < n && !used[newI][newJ] && arr[newI][newJ] <= limit) {
                        used[newI][newJ] = true;
                        queue.add(new int[]{newI, newJ});
                    }
                }
            }
        }
        return false;
    }
}
