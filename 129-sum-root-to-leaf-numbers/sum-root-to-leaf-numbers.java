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
    public static int ans = 0;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        calculaterootsum(root,"");
        return ans;
    }
    public static void calculaterootsum(TreeNode root , String s){
        if(root.left == null && root.right==null){
            s+=root.val;
            System.out.println(s);
            ans+=Integer.parseInt(s);
            return;
        }
        s+=root.val;
        if(root.left != null){
            calculaterootsum(root.left,s);
        }
        if(root.right != null){
            calculaterootsum(root.right,s);
        }
    }
}