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
    public static int value = -1;
    public int kthSmallest(TreeNode root, int k) {
        value = -1;
        int count[]=new int[1];
        count[0] = 0;
                kthsmall(root,k,count);
        return value;
    }
    public static void kthsmall(TreeNode root,int k,int []count){
        if(root==null)return;

        kthsmall(root.left,k,count);
        count[0]++;
         if (count[0]==k){
            value = root.val;
            return;
        }
        kthsmall(root.right,k,count);

        
    }
}