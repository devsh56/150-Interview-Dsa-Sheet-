/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int ans[] =new int[1];
        ans[0]= Integer.MIN_VALUE;
        int a =Calculatesumpath(root,ans);
        return ans[0];
    }
    public static int Calculatesumpath(TreeNode root , int ans[]){
        if(root.left == null && root.right == null){
            ans[0]=Math.max(root.val,ans[0]);
            return root.val;
        }
        int left =0;
        int right = 0;
        if(root.left != null)left =Calculatesumpath(root.left,ans);
        if(root.right != null)right =Calculatesumpath(root.right,ans);
        if(left < 0) left = 0;
        if(right < 0) right = 0;
        ans[0]= Math.max(ans[0],root.val+left+right);
        return root.val+Math.max(left,right);
    }
}