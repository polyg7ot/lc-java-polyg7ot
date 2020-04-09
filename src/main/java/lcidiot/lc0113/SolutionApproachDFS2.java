/**
 * https://leetcode.com/problems/path-sum-ii/
 */
package main.java.lcidiot.lc0113;

import java.util.ArrayList;
import java.util.List;

import main.java.lcidiot.utils.TreeNode;

public class SolutionApproachDFS2 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if(root == null) return ans;
        
        dfs(root, sum, new ArrayList<Integer>(), ans);
        return ans;
    }
    
    private void dfs(TreeNode node, 
                     int remainingSum,
                     List<Integer> intermediate, 
                     List<List<Integer>> ans){
        if(node == null) return;
        
        intermediate.add(node.val);
        if(remainingSum == node.val && node.left == null && node.right == null){
            ans.add(new ArrayList<Integer>(intermediate));
            intermediate.remove(intermediate.size() - 1);
            return;
        }
        
        dfs(node.left, remainingSum - node.val, intermediate, ans);
        dfs(node.right, remainingSum - node.val, intermediate, ans);
        intermediate.remove(intermediate.size() - 1);
    }
}