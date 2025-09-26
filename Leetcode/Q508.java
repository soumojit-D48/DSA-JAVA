// package DSA-JAVA.Leetcode;


import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;


public class Q508 {
    Map<Integer, Integer> map = new HashMap<>();
    int maxFreq = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root == null) return new int[0];

        dfs(root);

        List<Integer> list = new ArrayList<>();

        for(int sum : map.keySet()){
            if(map.get(sum) == maxFreq) {
                list.add(sum);
            }
        }

        // return list.stream().mapToInt(i -> i).toArray();

        int[] arr = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    private int dfs(TreeNode node) {
        if(node == null) return 0;

        int left = dfs(node.left);
        int right = dfs(node.right);

        int sum = node.val + left + right;

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        maxFreq = Math.max(maxFreq, map.get(sum));

        return sum;
    }

    //  public static void main(String[] args) {
    //     TreeNode root = new TreeNode(5, new TreeNode(2), new TreeNode(-3));
    //     Q508 sol = new Q508();
    //     int[] ans = sol.findFrequentTreeSum(root);
    //     System.out.println(Arrays.toString(ans));
    // }
}
