package top.ruizhihut.segment_tree_6;

/**
 * @description: 线段树模版
 * @author：ruizhi
 * @date: 2024/10/31
 * @Copyright：
 */
public class SegmentTree {
    private int[] tree;
    private int[] nums;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        tree = new int[nums.length * 2 + 1];
        constructTree(0, nums, 0, nums.length - 1);
    }

    private void constructTree(int node, int[] nums, int left, int right) {
        if (left == right) {
            tree[node] = nums[left];
        } else {
            int mid = left + (right - left) / 2;
            constructTree(node * 2 + 1, nums, left, mid);
            constructTree(node * 2 + 2, nums, mid + 1, right);
            tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
        }
    }

    public void updateTree(int index, int val) {
        updateTree(0, index, val, 0, nums.length - 1);
    }

    private void updateTree(int node, int index, int val, int left, int right) {
        if (left == right) {
            tree[node] = val;
        } else {
            int mid = left + (right - left) / 2;
            if (index >= left && index <= mid) {
                updateTree(node * 2 + 1, index, val, left, mid);
            } else {
                updateTree(node * 2 + 2, index, val, mid + 1, right);
            }
            tree[node] = tree[node * 2 + 1] + tree[node * 2 + 2];
        }
    }

    public int queryTree(int left, int right) {
        return queryTree(0, left, right, 0, nums.length - 1);
    }

    private int queryTree(int node, int left, int right, int l, int r) {
        if (left == l && right == r) {
            return tree[node];
        } else {
            int mid = l + (r - l) / 2;
            if (right <= mid) {
                return queryTree(node * 2 + 1, left, right, l, mid);
            } else if (left > mid) {
                return queryTree(node * 2 + 2, left, right, mid + 1, r);
            } else {
                return queryTree(node * 2 + 1, left, mid, l, mid) + queryTree(node * 2 + 2, mid + 1, right, mid + 1, r);
            }
        }
    }
}
