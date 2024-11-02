package top.ruizhihut.shortestPath_2;

/**
 * @description:
 * @author：ruizhi
 * @date: 2024/10/8
 * @Copyright：
 */
public class Floyd {
    public void floyd(int n) {
        int [][]arr = new int[n][n];
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
    }

}
